package presentation;

import authorization.LoggedUser;
import data.ProfessorRepository;
import data.StudentRepository;
import data.SubjectRepository;
import logic.*;

import java.util.Scanner;


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

    public void callAdminMenu() {
        if (adminMenu.adminPanel() == false) {
            callAdminMenu();
        }
        callLoginMenu();
    }

    public void callProfessorMenu() {
        if (professorMenu.professorMenu() == false) {
            callProfessorMenu();
        }
        callLoginMenu();
    }

    public void callStudentMenu() {
        if (studentMenu.studentMenu() == false) {
            callStudentMenu();
        }
        callLoginMenu();
    }

}
