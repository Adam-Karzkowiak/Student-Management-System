package presentation;

import logic.AdminService;
import logic.ProfessorService;
import logic.StudentService;

import java.util.Scanner;

public class LoginMenu {
    final static Scanner scanDecision = new Scanner(System.in);


    public static void login() {
        System.out.print("Login :");
        String provideLogin = scanDecision.nextLine();
        System.out.print("Password :");
        String providePassword = scanDecision.nextLine();
        if (provideLogin.matches(AdminService.getLogin()) && providePassword.matches(AdminService.getPassword())) {
            AdminMenu.adminPanel();
        } else if (ProfessorService.checkPasswordAndLogin(provideLogin,providePassword)) {
            ProfessorMenu.professorMenu();
        }else if (StudentService.checkPasswordAndLogin(provideLogin,providePassword)){
            StudentMenu.studentMenu();
        }
    }
}
