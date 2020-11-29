package app.controller;

import app.authorization.LoggedUser;
import app.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping("/professor")
public class ProfessorController {


    SubjectService subjectService;

    @Autowired
    public ProfessorController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }


    @GetMapping("/subjects")
    public List<String> callShowSubjectList() {
        return subjectService.showSubjectList();
    }

    @PostMapping("/subjects")
    @ResponseStatus(value = HttpStatus.CREATED, reason = "Subject created!")
    private void callCreateSubject(@RequestBody String subjectName) {
        subjectService.createSubject(subjectName);
    }

    @GetMapping("/subjects/{subjectName}")
    private void callShowRegisteredToSubject(@PathVariable String subjectName) {
        subjectService.showRegisteredToSubject(subjectName);
    }

    @GetMapping("/subjects/avg/{subjectName}")
    private void callCalculateAverageForWholeClass(@PathVariable String subjectName) {
        subjectService.calculateAverageForWholeClass(subjectName);
    }

    @PostMapping("/subjects/avg/{subjectName}")
    private void callCalculateAvgForStudent(@PathVariable String subjectName, @RequestBody String studentPesel) {
        subjectService.calculateAvgForStudent(subjectName, studentPesel);

    }

    @PatchMapping("/subjects/{subjectName}/{studentPesel}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT, reason = "Grades updated!")
    private void callGiveAGrade(@PathVariable String subjectName, @PathVariable String studentPesel, @RequestBody int grade) {
        subjectService.giveAGrade(subjectName, studentPesel, grade);
    }
}