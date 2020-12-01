package app.controller;


import app.authorization.LoggedUser;
import app.model.StudentSubjectKey;
import app.service.StudentService;
import app.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Scanner;
@RestController
@RequestMapping("/student")
public class StudentController {
    static final Scanner scanDecision = new Scanner(System.in);
    private static int action;
    StudentService studentService;
    SubjectService subjectService;

    @Autowired
    public StudentController(StudentService studentService, SubjectService subjectService) {
        this.studentService = studentService;
        this.subjectService = subjectService;
    }

    public boolean studentMenu() {
        do {
            System.out.println(LoggedUser.student.getName()+" "+LoggedUser.student.getSurname()+ " student panel");
            System.out.println("1. Show my grades");
            System.out.println("2. Register to subject");
            System.out.println("3. Logout");
            action = scanDecision.nextInt();
            switch (action) {
                case 1 -> subjectService.showAllStudentGrades(LoggedUser.student.getPesel());
                case 2 -> {
                    System.out.println("Subject registration");
                    subjectService.showSubjectList();
                    System.out.println("Provide subject name (case insensitive)");
                    scanDecision.nextLine();
                    String subjectName = scanDecision.nextLine();
                    subjectService.registerToSubject(LoggedUser.student.getPesel(), subjectName);
                }
            }
        } while (action != 3);
        System.out.println("Logout? (YES/NO)");
        scanDecision.nextLine();

        String logout = scanDecision.nextLine();
        return logout.equalsIgnoreCase("yes");
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

}
