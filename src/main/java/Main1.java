import data.ProfessorRepository;
import data.StudentRepository;
import logic.IdentifierProvider;
import logic.ProfessorService;
import logic.StudentService;
import presentation.LoginMenu;

public class Main1 {
    public static void main(String[] args) {
        IdentifierProvider identifierProvider = new IdentifierProvider();
        ProfessorRepository professorRepository = new ProfessorRepository();
        ProfessorService professorService = new ProfessorService(identifierProvider, professorRepository);
        StudentRepository studentRepository=new StudentRepository();
        StudentService studentService=new StudentService(identifierProvider,studentRepository);
        LoginMenu loginMenu=new LoginMenu(professorService,studentService);
        loginMenu.login();

    }
}