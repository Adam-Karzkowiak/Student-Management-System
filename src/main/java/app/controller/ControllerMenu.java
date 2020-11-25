package app.controller;

import app.authorization.LoggedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerMenu {
    public LoginController loginController;
    public AdminController adminController;
    public ProfessorController professorController;
    public StudentController studentController;

    @Autowired
    public ControllerMenu(LoginController loginController, AdminController adminController, ProfessorController professorController, StudentController studentController) {
        this.loginController = loginController;
        this.adminController = adminController;
        this.professorController = professorController;
        this.studentController = studentController;
    }

    @PostMapping("/login-menu")
    public void callLoginMenu() {
        int callMenu = loginController.login();
        if (callMenu == 1) {
            callAdminController();
        } else if (callMenu == 2) {
            callProfessorController();
        } else if (callMenu == 3) {
            callStudentController();
        }
        callLoginMenu();
    }

    @GetMapping("/test")
    public String checkTomcat() {
        return "its working";
    }

    @GetMapping("/admin-menu")
    public void callAdminController() {
        if (!adminController.adminPanel()) {
            callAdminController();
        }
        callLoginMenu();
    }

    @GetMapping("/professor-menu")
    public void callProfessorController() {
        if (!professorController.professorMenu()) {
            callProfessorController();
        }
        LoggedUser.professor = null;
        callLoginMenu();
    }

    @GetMapping("/student-menu")
    public void callStudentController() {
        if (!studentController.studentMenu()) {
            callStudentController();
        }
        LoggedUser.student = null;
        callLoginMenu();
    }

}
