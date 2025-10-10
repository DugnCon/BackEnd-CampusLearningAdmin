package com.javaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.javaweb.entity.competitions.CompetitionEntity;

public interface ICompetitionRepository extends JpaRepository<CompetitionEntity, Long>{
	@Query("select com from CompetitionEntity com")
	List<CompetitionEntity> getAllCompetition();
	@Query("select com from CompetitionEntity com where CompetitionID = :competitionId")
	CompetitionEntity getSingleCompetition(@Param("competitionId") Long competitionId);
}
