package app.data;


import app.model.Professor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ProfessorRepository {
    public static List<Professor> professorDatabase = new ArrayList<>();

    public void safeProfessor(Professor professor){
        professorDatabase.add(professor);
    }

    public void deleteProfessor(String pesel) {
        Iterator<Professor> iterator = professorDatabase.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getPesel().equals(pesel)) {
                iterator.remove();
            }
        }
    }

}