package app.controller;


import app.model.StudentSubjectKey;
import app.service.StudentService;
import app.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/student")
public class StudentController {

    StudentService studentService;
    SubjectService subjectService;

    @Autowired
    public StudentController(StudentService studentService, SubjectService subjectService) {
        this.studentService = studentService;
        this.subjectService = subjectService;
    }



    @GetMapping("/subjects")
    public List<String> callShowSubjectList() {
        return subjectService.showSubjectList();
    }

    @PatchMapping("/subjects")
    @ResponseStatus(value = HttpStatus.NO_CONTENT, reason = "Registered!")
    public void callRegisterToSubject(@RequestBody StudentSubjectKey studentSubjectKey){
        subjectService.registerToSubject(
                studentSubjectKey.getStudentPesel(),
                studentSubjectKey.getSubjectName());
    }

//  TODO subjectService.registerToSubject(LoggedUser.student.getPesel(), subjectName);

}
