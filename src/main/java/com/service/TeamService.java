package com.service;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Service;

import com.entity.Record;
import com.entity.Team;
import com.repository.TeamRepository;

@Service
public class TeamService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TeamRepository teamRepo;
	@PersistenceContext
	private EntityManager em;

	public TeamService(TeamRepository teamRepo) {
		this.teamRepo = teamRepo;
	}

	public Team getTeamById(int id) {
		return teamRepo.findById(id);
	}

	public Record getWeekRecord(String id, String week) {
		Long long_id = Long.parseLong(id);
		Long long_week = Long.parseLong(week);
		
		StoredProcedureQuery query = em.createStoredProcedureQuery("get_week_record");
		query.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, Long.class, ParameterMode.IN);
		query.setParameter(1, long_id);
		query.setParameter(2, long_week);
		
		String result = (String) query.getSingleResult();
		String[] values = result.split("-");
		int wins = Integer.parseInt(values[0]);
		int losses = Integer.parseInt(values[1]);
		int ties = Integer.parseInt(values[2]);
		
		Record record = new Record(wins, losses, ties);		
//		System.out.println(record.getWins());
//		System.out.println(record.getLosses());
//		System.out.println(record.getTies());
		return record;
	}
	
}
