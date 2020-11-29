package app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ProfessorNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String professorNotFoundHandler(ProfessorNotFoundException exception) {
        return exception.getMessage();
    }
}
