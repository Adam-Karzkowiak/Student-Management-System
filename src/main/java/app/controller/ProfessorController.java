package app.controller;

import app.model.Student;
import app.model.StudentSubjectKey;
import app.model.Subject;
import app.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

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
    private Subject callCreateSubject(@RequestBody String subjectName) {
        return subjectService.createSubject(subjectName);
    }

    @GetMapping("/subjects/{subjectName}")
    private Set<Student> callShowRegisteredToSubject(@PathVariable String subjectName) {
        return subjectService.showRegisteredToSubject(subjectName);
    }

    @GetMapping("/subjects/avg/{subjectName}")
    private void callCalculateAverageForWholeClass(@PathVariable String subjectName) {
        subjectService.calculateAverageForWholeClass(subjectName);
    }

    @PostMapping("/subjects/avg/{subjectName}")
    private double callCalculateAvgForStudent(@PathVariable String subjectName, @RequestBody String studentPesel) {
       return subjectService.calculateAvgForStudent(subjectName, studentPesel);
    }

    @PatchMapping("/subjects")
    @ResponseStatus(value = HttpStatus.NO_CONTENT, reason = "Grades updated!")
    private void callGiveAGrade(@RequestBody StudentSubjectKey studentSubjectKey) {
        subjectService.giveAGrade(
                studentSubjectKey.getSubjectName(),
                studentSubjectKey.getStudentPesel(),
                studentSubjectKey.getGrade());
    }
}