package com.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.entity.AllTimeStandingsView;

public interface AllTimeStandingsRepository extends JpaRepository<AllTimeStandingsView, Long> {
	
	List<AllTimeStandingsView> findAll();
}
