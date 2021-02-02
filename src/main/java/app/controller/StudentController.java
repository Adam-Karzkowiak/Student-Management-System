package app.controller;


import app.model.dto.StudentSubjectDTO;
import app.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student-home")
public class StudentController {

    SubjectService subjectService;

    @Autowired
    public StudentController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }


    @GetMapping("/subjects")
    public List<String> callShowSubjectList() {
        return subjectService.showSubjectList();
    }

    @PatchMapping("/subjects")
    @ResponseStatus(value = HttpStatus.NO_CONTENT, reason = "Registered!")
    public void callRegisterToSubject(@RequestBody StudentSubjectDTO studentSubjectDTO) {
        subjectService.registerToSubject(
                studentSubjectDTO.getStudentId(),
                studentSubjectDTO.getSubjectName());
    }

//  TODO showAllStudentGrades 1)Change method in service layer to save data in some collections, create method with GetMapping

}
