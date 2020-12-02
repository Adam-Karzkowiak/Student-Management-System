package app.controller;

import app.authorization.LoggedUser;
import app.service.AdminService;
import app.service.ProfessorService;
import app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {
    public ProfessorService professorService;
    public StudentService studentService;

    @Autowired
    public LoginController(ProfessorService professorService, StudentService studentService) {
        this.professorService = professorService;
        this.studentService = studentService;
    }

    @PostMapping("/login")
    public int login(@RequestParam("login") String login,@RequestParam("password") String password) {
        if (login.matches(AdminService.getLogin()) && password.matches(AdminService.getPassword())) {
            return 1;
        } else if (professorService.checkPasswordAndLogin(login, password)) {
            LoggedUser.professor = professorService.getProfessor(login);
            return 2;
        } else if (studentService.checkPasswordAndLogin(login, password)) {
            LoggedUser.student = studentService.getStudent(login);
            return 3;

        }
        return 0;
    }


}
