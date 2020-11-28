package app.exception;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(String studentPesel) {
        super("Could not find student with pesel " + studentPesel);
    }
}
