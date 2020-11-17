package app;

import app.data.ProfessorRepository;
import app.data.StudentRepository;
import app.data.SubjectRepository;
import app.logic.IdentifierProvider;
import app.logic.ProfessorService;
import app.logic.StudentService;
import app.logic.SubjectService;
import app.presentation.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Run {

    public static void main(String[] args) {
        ProfessorRepository professorRepository=new ProfessorRepository();
        StudentRepository studentRepository=new StudentRepository();
        SubjectRepository subjectRepository=new SubjectRepository();
        IdentifierProvider identifierProvider=new IdentifierProvider();
        ProfessorService professorService=new ProfessorService(identifierProvider,professorRepository);
        StudentService studentService=new StudentService(identifierProvider,studentRepository);
        SubjectService subjectService=new SubjectService(subjectRepository);
        AdminMenu adminMenu=new AdminMenu(professorService,studentService);
        LoginMenu loginMenu=new LoginMenu(professorService,studentService);
        ProfessorMenu professorMenu=new ProfessorMenu(subjectService);
        StudentMenu studentMenu=new StudentMenu(studentService,subjectService);
        ControllerMenu controllerMenu=new ControllerMenu(loginMenu,adminMenu,professorMenu,studentMenu);
        controllerMenu.callLoginMenu();
    }
}