package presentation;

import authorization.LoggedUser;
import data.ProfessorRepository;
import logic.AdminService;
import logic.ProfessorService;
import logic.StudentService;

import java.util.Scanner;

public class LoginMenu {
    final static Scanner scanDecision = new Scanner(System.in);
    private ProfessorService professorService;
    private StudentService studentService;

    public LoginMenu(ProfessorService professorService, StudentService studentService) {
        this.professorService = professorService;
        this.studentService = studentService;
    }
//statyczne pole-logged user. Klasa LoggedUser, osobny modul.
    public void login() {
        System.out.print("Login :");
        String provideLogin = scanDecision.nextLine();
        System.out.print("Password :");
        String providePassword = scanDecision.nextLine();
        if (provideLogin.matches(AdminService.getLogin()) && providePassword.matches(AdminService.getPassword())) {
            ControllerMenu.callAdminMenu();
        } else if (professorService.checkPasswordAndLogin(provideLogin, providePassword)) {
            LoggedUser.professor= ProfessorRepository.professorDatabase.
            ControllerMenu.callProfessorMenu();
        } else if (studentService.checkPasswordAndLogin(provideLogin, providePassword)) {
            ControllerMenu.callStudentMenu();
        }
    }
}
