package app.exception;

public class SubjectNotFoundException extends RuntimeException {

    public SubjectNotFoundException(String subjectName) {
        super("Could not find subject "+subjectName);
    }
}
