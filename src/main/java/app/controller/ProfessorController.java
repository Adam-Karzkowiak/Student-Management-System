package app.controller;

import app.model.AppUser;
import app.model.StudentSubjectGradeDTO;
import app.model.Subject;
import app.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @Autowired
    public ProfessorController(SubjectService subjectService) {
        this.subjectService = subjectService;
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

    @PatchMapping("/subjects")
    @ResponseStatus(value = HttpStatus.NO_CONTENT, reason = "Grades updated!")
    public void callGiveAGrade(@RequestBody StudentSubjectGradeDTO studentSubjectKey) {
        subjectService.giveAGrade(
                studentSubjectKey.getSubjectName(),
                studentSubjectKey.getStudentId(),
                studentSubjectKey.getGrade());
    }

    @Transactional
    @PatchMapping("/tasks/{id}")
    public ResponseEntity<?> toggleTask(@PathVariable int id) {
        if (!appUser.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.findById(id)
                .ifPresent(task -> task.setDone(!task.isDone()));
        return ResponseEntity.noContent().build();
    }
}