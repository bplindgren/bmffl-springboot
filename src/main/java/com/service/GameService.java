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
	
	public List<Game> getGamesByTeamId(long id) {
		return gameRepo.findByHomeTeamIdOrAwayTeamId(id, id);
	}
	
	public List<Game> getWeekGames(long seasonId, int week) {
		long season = seasonId-2010;
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
			Team winner = null;
			try {
				winner = g.getWinner();
				
				if (winner.getOwner().getId() == owner1Id) {
					o1wins+=1;
				} else if (winner.getOwner().getId() == owner2Id) {
					o2wins+=1;
				} 
				
				if (g.getAwayTeam().getId() == owner1Id) {
					o1points+=g.getAwayScore();
					o2points+=g.getHomeScore();
				} else {
					o2points+=g.getAwayScore();
					o1points+=g.getHomeScore();				
				}
				
			} catch (Exception e) {
				String s = "hi";
				System.out.println(s);
				ties+=1;
				o1points+=g.getAwayScore();
				o2points+=g.getHomeScore();
				
			} 
			
		}
		
		MatchupStats matchupStats = new MatchupStats(matchupGames, o1wins, o2wins, ties, o1points, o2points);
		
		return matchupStats;
	}
	
}
