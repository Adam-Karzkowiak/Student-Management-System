import data.ProfessorRepository;
import data.StudentRepository;
import data.SubjectRepository;
import logic.IdentifierProvider;
import logic.ProfessorService;
import logic.StudentService;
import logic.SubjectService;
import model.Professor;
import presentation.*;

public class Main1 {
    public static void main(String[] args) {
        ProfessorRepository professorRepository=new ProfessorRepository();
        StudentRepository studentRepository=new StudentRepository();
        SubjectRepository subjectRepository=new SubjectRepository();
        IdentifierProvider identifierProvider=new IdentifierProvider();
        ProfessorService professorService=new ProfessorService(identifierProvider,professorRepository);
        StudentService studentService=new StudentService(identifierProvider,studentRepository);
        SubjectService subjectService=new SubjectService(subjectRepository);
        AdminMenu adminMenu=new AdminMenu();
        LoginMenu loginMenu=new LoginMenu(professorService,studentService);
        ProfessorMenu professorMenu=new ProfessorMenu(subjectService);
        StudentMenu studentMenu=new StudentMenu();
        ControllerMenu controllerMenu=new ControllerMenu(professorRepository,studentRepository,subjectRepository,identifierProvider,professorService,studentService,subjectService,loginMenu,adminMenu,professorMenu,studentMenu);
        controllerMenu.callLoginMenu();
    }
}