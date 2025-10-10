package com.javaweb.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.javaweb.entity.competitions.CompetitionEntity;
import com.javaweb.entity.competitions.CompetitionProblemEntity;
import com.javaweb.model.dto.CompetitionDTO;
import com.javaweb.model.dto.CompetitionProblemDTO;

@Service
public interface ICompetitionService {
	List<CompetitionEntity> getAllCompetition();
	CompetitionEntity getCompetitionById(Long competitionId);
	ResponseEntity<Object> insertCompetition(CompetitionDTO competitionDTO);
	ResponseEntity<Object> getCompetitionLeaderboard(Long competitionId);
	List<CompetitionProblemEntity> getProblems(Long competitionId);
	CompetitionProblemEntity getProblemById(Long competitionId, Long problemId);
	ResponseEntity<Object> insertProblem(Long competitionId,CompetitionProblemDTO competitionProblemDTO);
	ResponseEntity<Object> updateCompetition(Long competitionId,CompetitionDTO competitionDTO);
	ResponseEntity<Object> updateCompetitionStatus(Long competitionId,String status);
	ResponseEntity<Object> updateProblem(Long problemId,CompetitionProblemDTO problemDTO);
	ResponseEntity<Object> deleteCompetition(Long competitionId);
	ResponseEntity<Object> deleteProblem(Long problemId);
}
