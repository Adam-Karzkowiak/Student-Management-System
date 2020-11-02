package presentation;

import data.ProfessorRepository;
import data.StudentRepository;
import data.SubjectRepository;
import logic.IdentifierProvider;
import logic.ProfessorService;
import logic.StudentService;
import logic.SubjectService;


public class ControllerMenu {
//listener wzorzec projektowy<-
    //jako konstruktor-wszystkie Menu.
    //wstrzykiwanie zaleznosci
    //booleany do kontroli przeplywu

    public ControllerMenu() {

    }

    public static void callLoginMenu() {
        StudentRepository studentRepository = new StudentRepository();
        ProfessorRepository professorRepository = new ProfessorRepository();
        IdentifierProvider identifierProvider = new IdentifierProvider();
        StudentService studentService = new StudentService(identifierProvider, studentRepository);
        ProfessorService professorService = new ProfessorService(identifierProvider, professorRepository);
        LoginMenu loginMenu = new LoginMenu(professorService, studentService);
        loginMenu.login();
    }

    public static void callAdminMenu() {
        StudentRepository studentRepository = new StudentRepository();
        ProfessorRepository professorRepository = new ProfessorRepository();
        IdentifierProvider identifierProvider = new IdentifierProvider();
        StudentService studentService = new StudentService(identifierProvider, studentRepository);
        ProfessorService professorService = new ProfessorService(identifierProvider, professorRepository);
        AdminMenu adminMenu = new AdminMenu(professorService, studentService);
        adminMenu.adminPanel();
    }

    public static void callProfessorMenu() {
        SubjectRepository subjectRepository = new SubjectRepository();
        SubjectService subjectService = new SubjectService(subjectRepository);
        ProfessorMenu professorMenu = new ProfessorMenu(subjectService);
        professorMenu.professorMenu();
    }

    public static void callStudentMenu() {
        IdentifierProvider identifierProvider = new IdentifierProvider();
        StudentRepository studentRepository = new StudentRepository();
        StudentService studentService = new StudentService(identifierProvider, studentRepository);
        SubjectRepository subjectRepository = new SubjectRepository();
        SubjectService subjectService = new SubjectService(subjectRepository);
        StudentMenu studentMenu = new StudentMenu(studentService, subjectService);
        studentMenu.studentMenu();
    }
}
