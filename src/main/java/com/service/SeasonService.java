package com.service;

import java.util.List;

import javax.persistence.EntityManager;
//import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
//import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Service;

import com.entity.OwnerSeasons;
import com.entity.Season;
import com.repository.OwnerSeasonsRepository;
import com.repository.SeasonRepository;

@Service
public class SeasonService {

	private SeasonRepository seasonRepo;
	@PersistenceContext
	private EntityManager em;
//	private OwnerSeasonsRepository ownerSeasonsRepo;

	public SeasonService(SeasonRepository seasonRepo) {
		this.seasonRepo = seasonRepo;
	}
	
	public List<Season> getSeasons() {
		return seasonRepo.findAll();
	}
	
//	public List<OwnerSeasons> getOwnerSeasons(Long owner_id) {
//		return ownerSeasonsRepo.findById(ownerId);
//	}
	
//	public OwnerSeasons getOwnerSeasons(String owner_id) {
//		Integer owner_int = Integer.parseInt(owner_id);
//		
//		StoredProcedureQuery query = em.createStoredProcedureQuery("get_owner_seasons");
//		query.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
//		query.setParameter(1, owner_int);	
//		
//		String result = (String) query.getSingleResult();
//		
//		String[] values = result.split("-");
//		String firstSeason = values[0];
//		String lastSeason = values[1];
//		System.out.println(result);
//		
//		OwnerSeasons os = new OwnerSeasons(owner_int, firstSeason, lastSeason);
//		return os;
//	}
	
}
