package app.authorization;


import app.model.Professor;
import app.model.Student;
import lombok.Getter;

@Getter
public class LoggedUser {

    public static Professor professor = null;
    public static Student student = null;

}
