package app.controller;

import app.data.ProfessorRepository;
import app.data.StudentRepository;
import app.logic.ProfessorService;
import app.logic.StudentService;
import app.logic.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;
@Controller
public class AdminMenu  {

    static final Scanner scanDecision = new Scanner(System.in);
    private static int action;
    ProfessorService professorService;
    StudentService studentService;

    @Autowired
    public AdminMenu(ProfessorService professorService, StudentService studentService) {
        this.professorService = professorService;
        this.studentService = studentService;
    }

    public boolean adminPanel() {
        String login;
        String password;
        String name;
        String surname;
        String pesel;
        String peselToDelete;
        String decision;

        do {
            System.out.println("Administration panel");
            System.out.println("1. Create professor account");
            System.out.println("2. Create student account");
            System.out.println("3. Delete professor account");
            System.out.println("4. Delete student account");
            System.out.println("5. Logout");
            action = scanDecision.nextInt();

            switch (action) {
                case 1 -> {
                    System.out.println("Enter Login");
                    scanDecision.nextLine();
                    login = scanDecision.nextLine();
                    System.out.println("Enter Passowrd. ( 8 < X < 20 letters, at least: one uppercase, one lowercase, one number");
                    password = scanDecision.nextLine();
                    ValidationService.passwordValidation(password);
                    System.out.println("Enter name");
                    name = scanDecision.nextLine();
                    ValidationService.checkName(name);
                    System.out.println("Enter surname");
                    surname = scanDecision.nextLine();
                    ValidationService.checkSurname(surname);
                    System.out.println("Enter pesel number");
                    pesel = scanDecision.nextLine();
                    ValidationService.peselValidation(pesel);
                    professorService.createProfessor(login, password, name, surname, pesel);
                    System.out.println(ProfessorRepository.professorDatabase);
                }
                case 2 -> {
                    System.out.println("Enter Login");
                    scanDecision.nextLine();
                    login = scanDecision.nextLine();
                    System.out.println("Enter Passowrd. ( 8 < X < 20 letters, at least: one uppercase, one lowercase, one number");
                    password = scanDecision.nextLine();
                    ValidationService.passwordValidation(password);
                    System.out.println("Enter name");
                    name = scanDecision.nextLine();
                    ValidationService.checkName(name);
                    System.out.println("Enter surname");
                    surname = scanDecision.nextLine();
                    ValidationService.checkSurname(surname);
                    System.out.println("Enter pesel number");
                    pesel = scanDecision.nextLine();
                    ValidationService.peselValidation(pesel);
                    studentService.createStudent(login, password, name, surname, pesel);
                    System.out.println(StudentRepository.studentDatabase);
                }
                case 3 -> {
                    System.out.println("Provide PESEL number to delete account");
                    scanDecision.nextLine();
                    peselToDelete = scanDecision.nextLine();
                    System.out.println("Do you want to delete ");
                    professorService.printNameAndSurname(peselToDelete);
                    System.out.println("Y/N?");
                    decision = scanDecision.nextLine();
                    if (decision.equalsIgnoreCase("Y")) {
                        professorService.removeProfessorAccount(peselToDelete);
                        System.out.println("Account has been deleted");
                    } else {
                        System.out.println("Procedure has been cancelled");
                    }
                }
                case 4 -> {
                    System.out.println("Provide PESEL number to delete account");
                    scanDecision.nextLine();
                    peselToDelete = scanDecision.nextLine();
                    System.out.println("Do you want to delete ");
                    studentService.printNameAndSurname(peselToDelete);
                    System.out.println("Y/N?");
                    decision = scanDecision.nextLine();
                    if (decision.equalsIgnoreCase("Y")) {
                        studentService.removeStudentAccount(peselToDelete);
                        System.out.println("Account has been deleted");
                    } else {
                        System.out.println("Procedure has been cancelled");
                    }
                }
            }
        } while (action != 5);
        System.out.println("Logout? (YES/NO)");
        scanDecision.nextLine();
        String logout = scanDecision.nextLine();
        return logout.equalsIgnoreCase("yes");
    }


}

