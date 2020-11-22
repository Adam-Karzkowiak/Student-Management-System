package app.presentation;

import app.authorization.LoggedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
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

    @GetMapping("/loginmenu")
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
