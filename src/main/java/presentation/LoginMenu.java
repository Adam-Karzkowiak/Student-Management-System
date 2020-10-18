package presentation;

import data.StudentRepository;
import logic.AdminService;
import logic.IdentifierProvider;
import logic.ProfessorService;
import logic.StudentService;

import java.util.Scanner;

public class LoginMenu {
    final static Scanner scanDecision = new Scanner(System.in);
    private AdminMenu adminMenu;
    private ProfessorService professorService;
    private ProfessorMenu professorMenu;
    private StudentService studentService;
    private StudentMenu studentMenu;

    public LoginMenu(ProfessorService professorService) {
        this.studentService = new StudentService(new IdentifierProvider(), new StudentRepository());//FIXME instancja na potrzebe uruchomienia
        this.adminMenu = new AdminMenu(professorService, this, studentService);
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
        } else if (studentService.checkPasswordAndLogin(provideLogin, providePassword)) {
            studentMenu.studentMenu();
        }
    }
}
