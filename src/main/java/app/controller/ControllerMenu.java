package app.controller;

import app.authorization.LoggedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerMenu {
    public LoginMenu loginMenu;
    public AdminController adminController;
    public ProfessorMenu professorMenu;
    public StudentMenu studentMenu;

    @Autowired
    public ControllerMenu(LoginMenu loginMenu,AdminController adminController , ProfessorMenu professorMenu, StudentMenu studentMenu) {
        this.loginMenu = loginMenu;
        this.adminController = adminController;
        this.professorMenu = professorMenu;
        this.studentMenu = studentMenu;
    }

    @PostMapping("/login-menu")
    public void callLoginMenu() {
        int callMenu = loginMenu.login();
        if (callMenu == 1) {
            callAdminController();
        } else if (callMenu == 2) {
            callProfessorMenu();
        } else if (callMenu == 3) {
            callStudentMenu();
        }
        callLoginMenu();
    }

    @GetMapping("/test")
    public String checkTomcat(){
        return "its working";
    }

    @GetMapping("/admin-menu")
    public void callAdminController() {
        if (!adminController.adminPanel()) {
            callAdminController();
        }
        callLoginMenu();
    }

    @GetMapping("/professormenu")
    public void callProfessorMenu() {
        if (!professorMenu.professorMenu()) {
            callProfessorMenu();
        }
        LoggedUser.professor = null;
        callLoginMenu();
    }
    @GetMapping("/studentmenu")
    public void callStudentMenu() {
        if (!studentMenu.studentMenu()) {
            callStudentMenu();
        }
        LoggedUser.student = null;
        callLoginMenu();
    }

}
