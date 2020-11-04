package presentation;

import authorization.LoggedUser;
import data.ProfessorRepository;
import data.StudentRepository;
import data.SubjectRepository;
import logic.*;

import java.util.Scanner;


public class ControllerMenu {
    public ProfessorRepository professorRepository;
    public StudentRepository studentRepository;
    public SubjectRepository subjectRepository;
    public IdentifierProvider identifierProvider;
    public ProfessorService professorService;
    public StudentService studentService;
    public SubjectService subjectService;
    public LoginMenu loginMenu;
    public AdminMenu adminMenu;
    public ProfessorMenu professorMenu;
    public StudentMenu studentMenu;

    public ControllerMenu(ProfessorRepository professorRepository, StudentRepository studentRepository, SubjectRepository subjectRepository, IdentifierProvider identifierProvider, ProfessorService professorService, StudentService studentService, SubjectService subjectService, LoginMenu loginMenu, AdminMenu adminMenu, ProfessorMenu professorMenu, StudentMenu studentMenu) {
        this.professorRepository = professorRepository;
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
        this.identifierProvider = identifierProvider;
        this.professorService = professorService;
        this.studentService = studentService;
        this.subjectService = subjectService;
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
    }

    public void callAdminMenu() {
        adminMenu.adminPanel();
        callLoginMenu();
    }

    public void callProfessorMenu() {
        if (professorMenu.professorMenu() == false) {
            callProfessorMenu();
        }
        callLoginMenu();
    }

    public void callStudentMenu() {
        studentMenu.studentMenu();
        callLoginMenu();
    }

}
