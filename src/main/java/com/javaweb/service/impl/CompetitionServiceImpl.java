package com.javaweb.service.impl;

import java.util.List;
import java.util.Map;

import javax.management.relation.RelationService;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.javaweb.entity.competitions.CompetitionEntity;
import com.javaweb.entity.competitions.CompetitionProblemEntity;
import com.javaweb.model.dto.CompetitionDTO;
import com.javaweb.model.dto.CompetitionProblemDTO;
import com.javaweb.repository.ICompetitionProblemRepository;
import com.javaweb.repository.ICompetitionRepository;
import com.javaweb.service.ICompetitionService;
import com.javaweb.utils.NullAwareBeanUtils;
@Service
public class CompetitionServiceImpl implements ICompetitionService{
	@Autowired
	private ICompetitionRepository competitionRepository;
	@Autowired
	private ICompetitionProblemRepository problemRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public List<CompetitionEntity> getAllCompetition() {
		return competitionRepository.getAllCompetition();
	}

	@Override
	public CompetitionEntity getCompetitionById(Long competitionId) {
		return competitionRepository.getSingleCompetition(competitionId);
	}

	@Override
	@Transactional
	public ResponseEntity<Object> insertCompetition(CompetitionDTO competitionDTO) {
		try {
			CompetitionEntity competitionEntity = modelMapper.map(competitionDTO, CompetitionEntity.class);
			competitionRepository.save(competitionEntity);
			return ResponseEntity.ok(Map.of("competitionId", competitionEntity.getCompetitionID()));
		} catch (Exception e) {
			throw new RuntimeException(e + " Can not insert competition");
		}
	}

	@Override
	public ResponseEntity<Object> getCompetitionLeaderboard(Long competitionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompetitionProblemEntity> getProblems(Long competitionId) {
		return problemRepository.getAllProblem(competitionId);
	}

	@Override
	public CompetitionProblemEntity getProblemById(Long competitionId, Long problemId) {
		return problemRepository.getSingleProblem(problemId);
	}

	@Override
	public ResponseEntity<Object> insertProblem(Long competitionId,CompetitionProblemDTO competitionProblemDTO) {
		CompetitionEntity competitionEntity = competitionRepository.findById(competitionId).orElseThrow(() -> new RuntimeException("not found comeptition"));
		try {
			CompetitionProblemEntity problem = modelMapper.map(competitionProblemDTO, CompetitionProblemEntity.class);
			problem.setCompetition(competitionEntity);
			problemRepository.save(problem);
			return ResponseEntity.ok(Map.of("problemId",problem.getProblemID()));
		} catch (Exception e) {
			throw new RuntimeException(e + " Can not insert problem");
		}
	}

	@Override
	@Transactional
	public ResponseEntity<Object> updateCompetition(Long competitionId ,CompetitionDTO competitionDTO) {
		try {
			CompetitionEntity competitionEntity = competitionRepository.findById(competitionId).orElseThrow(() -> new RuntimeException("Not found competition"));
			NullAwareBeanUtils.copyNonNullProperties(competitionDTO, competitionEntity);
			competitionRepository.save(competitionEntity);
			return ResponseEntity.ok(HttpStatus.OK);
		} catch(Exception e) {
			throw new RuntimeException(e + " Can not update competition");
		}
	}

	@Override
	public ResponseEntity<Object> updateCompetitionStatus(Long competitionId ,String status) {
		try {
			CompetitionEntity competitionEntity = competitionRepository.findById(competitionId).orElseThrow(() -> new RuntimeException("Not found competition"));
			competitionEntity.setStatus(status);
			competitionRepository.save(competitionEntity);
			return ResponseEntity.ok(HttpStatus.OK);
		} catch(Exception e) {
			throw new RuntimeException(e + " Can not update competition");
		}
	}

	@Override
	public ResponseEntity<Object> updateProblem(Long problemId,CompetitionProblemDTO problemDTO) {
		try {
			CompetitionProblemEntity problemEntity = problemRepository.findById(problemId).orElseThrow(() -> new RuntimeException("Not found competition"));
			NullAwareBeanUtils.copyNonNullProperties(problemDTO, problemEntity);
			problemRepository.save(problemEntity);
			return ResponseEntity.ok(HttpStatus.OK);
		} catch(Exception e) {
			throw new RuntimeException(e + " Can not update problem");
		}
	}

	@Override
	@Transactional
	public ResponseEntity<Object> deleteCompetition(Long competitionId) {
		try {
			//CompetitionEntity competitionEntity = competitionRepository.findById(competitionId).orElseThrow(() -> new RuntimeException("Not found competition"));
			competitionRepository.deleteById(competitionId);
			return ResponseEntity.ok(HttpStatus.OK);
		} catch(Exception e) {
			throw new RuntimeException(e + " Can not update competition");
		}
	}

	@Override
	public ResponseEntity<Object> deleteProblem(Long problemId) {
		try {
			//CompetitionEntity competitionEntity = competitionRepository.findById(competitionId).orElseThrow(() -> new RuntimeException("Not found competition"));
			//NullAwareBeanUtils.copyNonNullProperties(competitionDTO, competitionEntity);
			//competitionRepository.save(competitionEntity);
			problemRepository.deleteById(problemId);
			return ResponseEntity.ok(HttpStatus.OK);
		} catch(Exception e) {
			throw new RuntimeException(e + " Can not update problem");
		}
	}

}
