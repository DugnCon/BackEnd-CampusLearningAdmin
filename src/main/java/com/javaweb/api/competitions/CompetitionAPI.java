package com.javaweb.api.competitions;

import com.javaweb.model.dto.CompetitionDTO;
import com.javaweb.model.dto.CompetitionProblemDTO;
import com.javaweb.service.FileStorageService;
import com.javaweb.service.ICompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping
public class CompetitionAPI {
    @Autowired
    private FileStorageService fileStorageService;
	@Autowired
	private ICompetitionService competitionService;
    // ===== GET =====

    // Lấy tất cả competitions
    @GetMapping("/competitions")
    public ResponseEntity<Object> getAllCompetitions() {
        return ResponseEntity.ok(Map.of("competitions", competitionService.getAllCompetition()));
    }

    // Lấy competition theo ID
    @GetMapping("/competitions/{id}")
    public ResponseEntity<Object> getCompetitionById(@PathVariable Long id) {
        return ResponseEntity.ok(Map.of("competition", competitionService.getCompetitionById(id)));
    }

    // Lấy leaderboard
    @GetMapping("/competitions/{id}/leaderboard")
    public ResponseEntity<Object> getCompetitionLeaderboard(@PathVariable Long id) {
        // TODO: lấy leaderboard từ service
        return ResponseEntity.ok().body(null);
    }

    // Lấy danh sách problems
    @GetMapping("/competitions/{id}/problems")
    public ResponseEntity<Object> getProblems(@PathVariable Long id) {
        return ResponseEntity.ok(Map.of("problems", competitionService.getProblems(id)));
    }

    // Lấy 1 problem cụ thể
    @GetMapping("/competitions/{competitionId}/problems/{problemId}")
    public ResponseEntity<Object> getProblem(
            @PathVariable Long competitionId,
            @PathVariable Long problemId) {
        return ResponseEntity.ok(Map.of("problem",competitionService.getProblemById(competitionId, problemId)));
    }

    // Lấy danh sách participants
    @GetMapping("/competitions/{id}/participants")
    public ResponseEntity<Object> getCompetitionParticipants(@PathVariable Long id) {
        // TODO: lấy participants từ service
        return ResponseEntity.ok().body(null);
    }

    // ===== POST =====

    // Tạo mới competition
    @PostMapping("/competitions")
    public ResponseEntity<Object> createCompetition(@RequestBody CompetitionDTO competitionDTO) {
        return competitionService.insertCompetition(competitionDTO);
    }

    @PostMapping("/upload")
    public ResponseEntity<Object> uploadImage(@RequestBody MultipartFile file) throws IOException {
        return ResponseEntity.ok(Map.of("url", fileStorageService.saveFile(file)));
    }

    // Tạo mới problem cho competition
    @PostMapping("/competitions/{competitionId}/problems")
    public ResponseEntity<Object> createProblem(
            @PathVariable Long competitionId,
            @RequestBody CompetitionProblemDTO problemDTO) {
        // TODO: gọi service lưu problem
        return competitionService.insertProblem(competitionId,problemDTO);
    }

    // ===== PUT =====

    // Cập nhật competition
    @PutMapping("/competitions/{id}")
    public ResponseEntity<Object> updateCompetition(
            @PathVariable Long id,
            @RequestBody CompetitionDTO competitionDTO) {
        // TODO: gọi service update
        return competitionService.updateCompetition(id, competitionDTO);
    }

    // Cập nhật status competition
    @PutMapping("/competitions/{id}/status")
    public ResponseEntity<Object> updateCompetitionStatus(
            @PathVariable Long id,
            @RequestBody String status) {
        // TODO: gọi service update status
        return competitionService.updateCompetitionStatus(id, status);
    }

    // Cập nhật problem
    @PutMapping("/competitions/{competitionId}/problems/{problemId}")
    public ResponseEntity<Object> updateProblem(
            @PathVariable Long competitionId,
            @PathVariable Long problemId,
            @RequestBody CompetitionProblemDTO problemDTO) {
        // TODO: gọi service update problem
        return competitionService.updateProblem(problemId, problemDTO);
    }

    // ===== DELETE =====

    // Xóa competition
    @DeleteMapping("/competitions/{id}")
    public ResponseEntity<Object> deleteCompetition(@PathVariable Long id) {
        // TODO: gọi service xóa
        return competitionService.deleteCompetition(id);
    }

    // Xóa problem
    @DeleteMapping("/competitions/{competitionId}/problems/{problemId}")
    public ResponseEntity<Object> deleteProblem(
            @PathVariable Long competitionId,
            @PathVariable Long problemId) {
        // TODO: gọi service xóa
        return competitionService.deleteProblem(problemId);
    }
}
