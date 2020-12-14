package app.repository;


import app.exception.ProfessorNotFoundException;
import app.model.Professor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ProfessorRepository {
    public static List<Professor> professorDatabase = new ArrayList<>();

    public void saveProfessor(Professor professor) {
        professorDatabase.add(professor);
    }

    public void deleteProfessor(String pesel) {
        if (professorDatabase.stream().noneMatch(o -> o.getPesel().equals(pesel))) {
            throw new ProfessorNotFoundException(pesel);
        }
        Iterator<Professor> iterator = professorDatabase.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getPesel().equals(pesel)) {
                iterator.remove();
            }
        }
    }

    public Professor returnProfessor(String pesel) {
        for (Professor prof : professorDatabase) {
            if (prof.getPesel().equals(pesel)) {
                return prof;
            }
        }
        return null;
    }

}
