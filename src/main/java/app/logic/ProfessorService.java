package app.logic;

import app.data.ProfessorRepository;
import lombok.Data;
import app.model.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class ProfessorService  {
    private IdentifierProvider identifierProvider;
    private ProfessorRepository professorRepository;

    @Autowired
    public ProfessorService(IdentifierProvider identifierProvider, ProfessorRepository professorRepository) {
        this.identifierProvider = identifierProvider;
        this.professorRepository = professorRepository;
    }


    public Professor createProfessor(String login, String password, String name, String surname, String pesel) {
        int id = identifierProvider.getId();
        Professor professor = new Professor(id, login, password, name, surname, pesel);
        addToRepository(professor);
        return professor;
    }

    public List<Professor> removeProfessorAccount(String pesel) {
        professorRepository.deleteProfessor(pesel);
        return ProfessorRepository.professorDatabase;
    }

    public List<Professor> addToRepository(Professor professor) {
        professorRepository.safeProfessor(professor);
        return ProfessorRepository.professorDatabase;
    }

    public boolean checkPasswordAndLogin(String login, String password) {

        for (Professor obj : ProfessorRepository.professorDatabase) {

            if (obj.getLogin().equals(login) && obj.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void printID(String login, String password) {
        for (Professor obj : ProfessorRepository.professorDatabase) {
            if (obj.getLogin().equals(login) && obj.getPassword().equals(password)) {
                System.out.println(obj.getId());
            }
        }
    }

    public void printNameAndSurname(String pesel) {
        for (Professor obj : ProfessorRepository.professorDatabase) {
            if (obj.getPesel().equals(pesel)) {
                System.out.println(obj.getName() + " " + obj.getSurname());
            }
        }
    }
    public Professor getProfessor(String login) {
        for (Professor obj : ProfessorRepository.professorDatabase) {
            if (obj.getLogin().equals(login)) {
                return obj;
            }
        }
        return null;
    }


}
