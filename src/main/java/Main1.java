import data.ProfessorRepository;
import logic.IdentifierProvider;
import logic.ProfessorService;
import presentation.LoginMenu;

public class Main1 {
    public static void main(String[] args) {
        IdentifierProvider identifierProvider = new IdentifierProvider();
        ProfessorRepository professorRepository = new ProfessorRepository();
        ProfessorService professorService = new ProfessorService(identifierProvider, professorRepository);

        LoginMenu loginMenu = new LoginMenu(professorService);
        loginMenu.login();
    }
}