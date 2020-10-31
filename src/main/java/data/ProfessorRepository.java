package data;


import model.Professor;

import java.util.ArrayList;

public class ProfessorRepository {
    public static ArrayList<Professor> professorDatabase = new ArrayList<>();

    public void addToDatabase(Professor professor){
        professorDatabase.add(professor);
    }

}
