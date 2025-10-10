package com.javaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.javaweb.entity.competitions.CompetitionProblemEntity;

public interface ICompetitionProblemRepository extends JpaRepository<CompetitionProblemEntity, Long>{
	@Query("select prb from CompetitionProblemEntity prb where prb.competition.CompetitionID = :competitionId")
	List<CompetitionProblemEntity> getAllProblem(@Param("competitionId") Long competitionId);
	@Query("select prb from CompetitionProblemEntity prb where ProblemID = :problemId")
	CompetitionProblemEntity getSingleProblem(@Param("problemId") Long problemId);
}
