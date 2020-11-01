package data;


import model.Professor;
import model.Student;

import java.util.ArrayList;
import java.util.Iterator;

public class ProfessorRepository {
    public static ArrayList<Professor> professorDatabase = new ArrayList<>();

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
