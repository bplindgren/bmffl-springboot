package com.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Service;

import com.entity.Game;
import com.entity.MatchupStats;
import com.entity.Owner;
import com.entity.Team;
import com.entity.TeamGame;
import com.repository.GameRepository;

@Service
public class GameService {

	private GameRepository gameRepo;
	@PersistenceContext
	private EntityManager em;

	public GameService(GameRepository gameRepo) {
		this.gameRepo = gameRepo;
	}

	public List<Game> getGames() {
		return gameRepo.findAll();
	}

	public List<Game> getGamesByGameType(String gameType) {
		return gameRepo.findByGameType(gameType);
	}

	public List<TeamGame> getGamesByTeamId(long id) {
		List<Game> games = gameRepo.findByHomeTeamIdOrAwayTeamId(id, id);
		List<TeamGame> teamGames = new ArrayList<TeamGame>();

		short w = 0;
		short l = 0;
		short t = 0;

		String lastResult = "";
		short streak = 0;
		for (Game g : games) {
			long homeId = g.getHomeTeam().getId();
			String isHome = (homeId == id) ? "" : "@";

			if (homeId == id) {
				float teamScore = g.getHomeScore();
				float opponentScore = g.getAwayScore();
				String result;
				if (teamScore > opponentScore) {
					result = "W";
					w++;
				} else if (teamScore < opponentScore) {
					result = "L";
					l++;
				} else {
					result = "T";
					t++;
				}

				if (result == lastResult) {
					streak++;
				} else {
					lastResult = result;
					streak = 1;
				}

				String team = g.getHomeTeam().getName();
				String owner = g.getHomeTeam().getOwner().getFirstName() + " "
						+ g.getHomeTeam().getOwner().getLastInitial();
				String opposingTeam = g.getAwayTeam().getName();
				long opposingTeamId = g.getAwayTeam().getId();
				String opposingOwner = g.getAwayTeam().getOwner().getFirstName() + " "
						+ g.getAwayTeam().getOwner().getLastInitial();
				long opposingOwnerId = g.getAwayTeam().getOwner().getId();
				String division = g.getAwayTeam().getDivision();
				String fullStreak = lastResult + String.valueOf(streak);

				TeamGame teamGame = new TeamGame(g.getWeek(), team, owner, isHome, opposingTeam, opposingTeamId,
						opposingOwner, opposingOwnerId, division, result, teamScore, opponentScore, g.getGameType(), w, l,
						t, fullStreak);
				teamGames.add(teamGame);
			} else {
				float teamScore = g.getAwayScore();
				float opponentScore = g.getHomeScore();
				String result;
				if (teamScore > opponentScore) {
					result = "W";
					w++;
				} else if (teamScore < opponentScore) {
					result = "L";
					l++;
				} else {
					result = "T";
					t++;
				}

				if (result == lastResult) {
					streak++;
				} else {
					lastResult = result;
					streak = 1;
				}

				String team = g.getAwayTeam().getName();
				String owner = g.getAwayTeam().getOwner().getFirstName() + " "
						+ g.getAwayTeam().getOwner().getLastInitial();
				String opposingTeam = g.getHomeTeam().getName();
				long opposingTeamId = g.getHomeTeam().getId();
				String opposingOwner = g.getHomeTeam().getOwner().getFirstName() + " "
						+ g.getHomeTeam().getOwner().getLastInitial();
				long opposingOwnerId = g.getHomeTeam().getOwner().getId();
				String division = g.getHomeTeam().getDivision();
				String fullStreak = lastResult + String.valueOf(streak);

				TeamGame teamGame = new TeamGame(g.getWeek(), team, owner, isHome, opposingTeam, opposingTeamId,
						opposingOwner, opposingOwnerId, division, result, teamScore, opponentScore, g.getGameType(), w, l,
						t, fullStreak);
				teamGames.add(teamGame);
			}
		}
		return teamGames;
	}

	public List<Game> getWeekGames(long seasonId, int week) {
		long season = seasonId - 2010;
		return gameRepo.findBySeasonIdAndWeek(season, week);
	}

	public List<Game> getSeasonPlayoffGames(long seasonId) {
		String qf = "Quarter Final";
		String sf = "Semi Final";
		String sb = "Super Bowl";
		List<Game> quarters = gameRepo.findBySeasonIdAndGameType(seasonId, qf);
		List<Game> semis = gameRepo.findBySeasonIdAndGameType(seasonId, sf);
		List<Game> superBowl = gameRepo.findBySeasonIdAndGameType(seasonId, sb);

		List<Game> fullList = new ArrayList<Game>();
		fullList.addAll(quarters);
		fullList.addAll(semis);
		fullList.addAll(superBowl);

		return fullList;
	}

	// Get Matchup Games from a stored procedure
	@SuppressWarnings("unchecked")
	public List<Game> getMatchupGames(long owner1Id, long owner2Id) {
		StoredProcedureQuery query = em.createStoredProcedureQuery("get_matchup_games");
		query.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, Long.class, ParameterMode.IN);
		query.setParameter(1, owner1Id);
		query.setParameter(2, owner2Id);

		List<Integer> gamesIDlist = query.getResultList();
		List<Long> gamesLong = new ArrayList<Long>();
		for (Integer i : gamesIDlist) {
			long l = i.longValue();
			gamesLong.add(l);

		}

		return gameRepo.findByIdIn(gamesLong);
	}

	public MatchupStats getMatchupStats(long owner1Id, long owner2Id) {
		List<Game> matchupGames = this.getMatchupGames(owner1Id, owner2Id);
		int o1wins = 0;
		int o2wins = 0;
		int ties = 0;
		float o1points = 0;
		float o2points = 0;

		for (Game g : matchupGames) {
			if (g.isCompleted() == true) {
				Team winner = null;
				try {
					winner = g.getWinner();

					if (winner.getOwner().getId() == owner1Id) {
						o1wins += 1;
					} else if (winner.getOwner().getId() == owner2Id) {
						o2wins += 1;
					}

					if (g.getAwayTeam().getId() == owner1Id) {
						o1points += g.getAwayScore();
						o2points += g.getHomeScore();
					} else {
						o2points += g.getAwayScore();
						o1points += g.getHomeScore();
					}

				} catch (Exception e) {
					String s = "hi";
					System.out.println(s);
					ties += 1;
					o1points += g.getAwayScore();
					o2points += g.getHomeScore();
				}
			}
		}

		MatchupStats matchupStats = new MatchupStats(matchupGames, o1wins, o2wins, ties, o1points, o2points);
		return matchupStats;
	}

}
