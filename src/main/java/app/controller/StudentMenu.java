package app.controller;


import app.authorization.LoggedUser;
import app.service.StudentService;
import app.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Scanner;
@RestController
public class StudentMenu {
    static final Scanner scanDecision = new Scanner(System.in);
    private static int action;
    StudentService studentService;
    SubjectService subjectService;

    @Autowired
    public StudentMenu(StudentService studentService, SubjectService subjectService) {
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
}
