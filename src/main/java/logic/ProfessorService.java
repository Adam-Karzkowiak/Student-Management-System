package logic;

import data.ProfessorRepository;
import lombok.Data;
import model.Professor;

import java.util.ArrayList;

@Data
public class ProfessorService  {
    private IdentifierProvider identifierProvider;
    private ProfessorRepository professorRepository;

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

    public ArrayList<Professor> removeProfessorAccount(String pesel) {
        ProfessorRepository.professorDatabase.removeIf(professor -> professor.getPesel().equals(pesel));
        return ProfessorRepository.professorDatabase;
    }

    public ArrayList<Professor> addToRepository(Professor professor) {
        professorRepository.addToDatabase(professor);
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


}
