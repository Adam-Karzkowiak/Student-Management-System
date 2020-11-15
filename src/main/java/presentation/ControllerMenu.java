package presentation;

import authorization.LoggedUser;
import org.springframework.web.bind.annotation.GetMapping;


public class ControllerMenu {

    public LoginMenu loginMenu;
    public AdminMenu adminMenu;
    public ProfessorMenu professorMenu;
    public StudentMenu studentMenu;

    public ControllerMenu(LoginMenu loginMenu, AdminMenu adminMenu, ProfessorMenu professorMenu, StudentMenu studentMenu) {

        this.loginMenu = loginMenu;
        this.adminMenu = adminMenu;
        this.professorMenu = professorMenu;
        this.studentMenu = studentMenu;
    }

    @GetMapping("/loginMenu") //gdy wejde na localhost 8080 /loginMenu wywolam funkcje loginMenu
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

    @GetMapping("/adminMenu")
    public void callAdminMenu() {
        if (adminMenu.adminPanel() == false) {
            callAdminMenu();
        }
        callLoginMenu();
    }

    @GetMapping("/professorMenu")
    public void callProfessorMenu() {
        if (professorMenu.professorMenu() == false) {
            callProfessorMenu();
        }
        LoggedUser.professor = null;
        callLoginMenu();
    }
    @GetMapping("/studentMenu")
    public void callStudentMenu() {
        if (studentMenu.studentMenu() == false) {
            callStudentMenu();
        }
        LoggedUser.student = null;
        callLoginMenu();
    }

}
