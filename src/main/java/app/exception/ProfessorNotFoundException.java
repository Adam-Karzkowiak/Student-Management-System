package app.exception;


public class ProfessorNotFoundException extends RuntimeException {

    public ProfessorNotFoundException(String professorPesel) {
        super("Could not find professor with pesel " + professorPesel);
    }
}


