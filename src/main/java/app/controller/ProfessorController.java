package app.controller;

import app.model.AppUser;
import app.model.dto.StudentSubjectGradeDTO;
import app.model.Subject;
import app.service.AppUserService;
import app.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/professor-home")
public class ProfessorController {


    private SubjectService subjectService;
    private AppUserService appUserService;

    @Autowired
    ProfessorController(SubjectService subjectService, AppUserService appUserService) {
        this.subjectService = subjectService;
        this.appUserService = appUserService;
    }

    @GetMapping("/subjects")
    ResponseEntity<List<String>> callShowSubjectList() {
        return ResponseEntity.ok(subjectService.showSubjectList());
    }


    @PostMapping("/subjects")
    ResponseEntity<Subject> callCreateSubject(@RequestBody String subjectName) {
        Subject createdSubject = subjectService.createSubject(subjectName);
        return ResponseEntity
                .created(URI.create("/" + createdSubject.getSubjectName()))
                .body(createdSubject);
    }


    @GetMapping("/subjects/{subjectName}")
    ResponseEntity<Set<AppUser>> callShowRegisteredToSubject(@PathVariable String subjectName) {
        return ResponseEntity.ok(subjectService.showRegisteredToSubject(subjectName));
    }

    @GetMapping("/subjects/avg/{subjectName}")
    ResponseEntity<Map<String, Double>> callCalculateAverageForWholeClass(@PathVariable String subjectName) {
        return ResponseEntity.ok(subjectService.calculateAverageForWholeClass(subjectName));
    }

    @PostMapping("/subjects/avg/{subjectName}")
    ResponseEntity<Double> callCalculateAvgForStudent(
            @PathVariable String subjectName,
            @RequestBody long id) {
        return ResponseEntity.ok(subjectService.calculateAvgForStudent(subjectName, id));
    }


    @Transactional
    @PatchMapping("/subjects}")
    public ResponseEntity<Void> callGiveAGrade(@RequestBody StudentSubjectGradeDTO stuSubGraKey) {
        if (!appUserService.callExistsById(stuSubGraKey.getStudentId())) {
            return ResponseEntity.notFound().build();
        }
        subjectService.giveAGrade(
                stuSubGraKey.getSubjectName(),
                stuSubGraKey.getStudentId(),
                stuSubGraKey.getGrade()
        );
        return ResponseEntity.noContent().build();
    }
}