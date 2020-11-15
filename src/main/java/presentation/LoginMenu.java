package presentation;

import authorization.LoggedUser;
import logic.AdminService;
import logic.ProfessorService;
import logic.StudentService;
import org.springframework.stereotype.Controller;


import java.util.Scanner;
@Controller
public class LoginMenu {
    static final Scanner scanDecision = new Scanner(System.in);
    public ProfessorService professorService;
    public StudentService studentService;

    public LoginMenu(ProfessorService professorService, StudentService studentService) {
        this.professorService = professorService;
        this.studentService = studentService;
    }

    public int login() {
        System.out.print("Login :");
        String provideLogin = scanDecision.nextLine();
        System.out.print("Password :");
        String providePassword = scanDecision.nextLine();
        if (provideLogin.matches(AdminService.getLogin()) && providePassword.matches(AdminService.getPassword())) {
            return 1;
        } else if (professorService.checkPasswordAndLogin(provideLogin, providePassword)) {
            LoggedUser.professor = professorService.getProfessor(provideLogin);
            return 2;
        } else if (studentService.checkPasswordAndLogin(provideLogin, providePassword)) {
            LoggedUser.student = studentService.getStudent(provideLogin);
            return 3;

        }
        return 0;
    }
}
