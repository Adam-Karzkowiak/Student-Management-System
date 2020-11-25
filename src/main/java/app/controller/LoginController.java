package app.controller;

import app.authorization.LoggedUser;
import app.service.AdminService;
import app.service.ProfessorService;
import app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


import java.util.Scanner;
@RestController
public class LoginController {
    static final Scanner scanDecision = new Scanner(System.in);
    public ProfessorService professorService;
    public StudentService studentService;

    @Autowired
    public LoginController(ProfessorService professorService, StudentService studentService) {
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
