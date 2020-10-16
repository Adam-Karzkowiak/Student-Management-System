package presentation;

import logic.AdminService;
import logic.ProfessorService;

import java.util.Scanner;

public class LoginMenu {
    final static Scanner scanDecision = new Scanner(System.in);
    private AdminMenu adminMenu;
    private ProfessorService professorService;
    private ProfessorMenu professorMenu;

    public LoginMenu(ProfessorService professorService) {
        this.adminMenu = new AdminMenu(professorService, this);
        this.professorService = professorService;
        this.professorMenu = new ProfessorMenu(this);
    }

    public void login() {
        System.out.print("Login :");
        String provideLogin = scanDecision.nextLine();
        System.out.print("Password :");
        String providePassword = scanDecision.nextLine();
        if (provideLogin.matches(AdminService.getLogin()) && providePassword.matches(AdminService.getPassword())) {
            adminMenu.adminPanel();
        } else if (professorService.checkPasswordAndLogin(provideLogin, providePassword)) {
            professorMenu.professorMenu();
         }
    }
}
