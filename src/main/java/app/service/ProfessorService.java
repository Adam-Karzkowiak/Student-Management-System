package app.service;

import lombok.Data;
import app.model.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class ProfessorService  {
    private IdentifierProvider identifierProvider;
    private ProfessorRepository professorRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    public ProfessorService(IdentifierProvider identifierProvider,
                            ProfessorRepository professorRepository,
                            BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.identifierProvider = identifierProvider;
        this.professorRepository = professorRepository;
        this.bCryptPasswordEncoder=bCryptPasswordEncoder;
    }


    public Professor createProfessor(String login, String password, String name, String surname, String pesel) {
        int id = identifierProvider.getId();
        Professor professor = new Professor(id, login, password, name, surname, pesel);
        professor.setPassword(bCryptPasswordEncoder.encode(professor.getPassword()));
        addToRepository(professor);
        return professor;
    }

    public List<Professor> removeProfessorAccount(String pesel) {
        professorRepository.deleteProfessor(pesel);
        return ProfessorRepository.professorDatabase;
    }

    public List<Professor> addToRepository(Professor professor) {
        professorRepository.saveProfessor(professor);
        return ProfessorRepository.professorDatabase;
    }

    public boolean checkPasswordAndLogin(String login, String password) {

        for (Professor obj : professorRepository.professorDatabase) {

            if (obj.getLogin().equals(login) && obj.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public Professor getProfessor(String login) {
        for (Professor obj : professorRepository.professorDatabase) {
            if (obj.getLogin().equals(login)) {
                return obj;
            }
        }
        return null;
    }


}
