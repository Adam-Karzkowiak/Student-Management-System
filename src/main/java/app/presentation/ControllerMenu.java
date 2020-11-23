package app.presentation;

import app.authorization.LoggedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerMenu {
    public LoginMenu loginMenu;
    public AdminMenu adminMenu;
    public ProfessorMenu professorMenu;
    public StudentMenu studentMenu;

    @Autowired
    public ControllerMenu(LoginMenu loginMenu, AdminMenu adminMenu, ProfessorMenu professorMenu, StudentMenu studentMenu) {
        this.loginMenu = loginMenu;
        this.adminMenu = adminMenu;
        this.professorMenu = professorMenu;
        this.studentMenu = studentMenu;
    }

    @PostMapping("/login-menu")
    public void callLoginMenu() {
        int callMenu = loginMenu.login();
        if (callMenu == 1) {
            callAdminMenu();
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

    @GetMapping("/adminmenu")
    public void callAdminMenu() {
        if (!adminMenu.adminPanel()) {
            callAdminMenu();
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
