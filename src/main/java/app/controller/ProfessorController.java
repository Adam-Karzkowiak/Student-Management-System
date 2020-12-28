package app.controller;

import app.model.StudentSubjectGradeDTO;
import app.model.Subject;
import app.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/professor-home")
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
    public Subject callCreateSubject(@RequestBody String subjectName) {
        return subjectService.createSubject(subjectName);
    }

    @GetMapping("/subjects/{subjectName}")
    public Set<Student> callShowRegisteredToSubject(@PathVariable String subjectName) {
        return subjectService.showRegisteredToSubject(subjectName);
    }

    @GetMapping("/subjects/avg/{subjectName}")
    public Map<String,Double> callCalculateAverageForWholeClass(@PathVariable String subjectName) {
        return subjectService.calculateAverageForWholeClass(subjectName);
    }

    @PostMapping("/subjects/avg/{subjectName}")
    public double callCalculateAvgForStudent(@PathVariable String subjectName, @RequestBody String studentPesel) {
        return subjectService.calculateAvgForStudent(subjectName, studentPesel);
    }

    @PatchMapping("/subjects")
    @ResponseStatus(value = HttpStatus.NO_CONTENT, reason = "Grades updated!")
    public void callGiveAGrade(@RequestBody StudentSubjectGradeDTO studentSubjectKey) {
        subjectService.giveAGrade(
                studentSubjectKey.getSubjectName(),
                studentSubjectKey.getStudentPesel(),
                studentSubjectKey.getGrade());
    }
}