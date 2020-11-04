package presentation;


import authorization.LoggedUser;
import data.SubjectRepository;
import logic.StudentService;
import logic.SubjectService;

import java.util.Scanner;

public class StudentMenu {
    final static Scanner scanDecision = new Scanner(System.in);
    private static int action;
    StudentService studentService;
    SubjectService subjectService;

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
                case 1:
                    subjectService.showAllStudentGrades(LoggedUser.student.getPesel());
                    break;
                case 2:
                    System.out.println("Subject registration");
                    subjectService.showSubjectList();
                    System.out.println("Provide subject name (case insensitive)");
                    scanDecision.nextLine();
                    String subjectName=scanDecision.nextLine();
                    subjectService.registerToSubject(LoggedUser.student.getPesel(),subjectName);
                    break;
            }
        } while (action != 3);
        System.out.println("Logout? (YES/NO)");
        scanDecision.nextLine();
        String logout = scanDecision.nextLine();
        if (logout.equalsIgnoreCase("yes")) {
            return true;
        }
        return false;
    }
}
