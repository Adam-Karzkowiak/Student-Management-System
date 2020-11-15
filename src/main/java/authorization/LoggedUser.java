package authorization;

import model.Professor;
import model.Student;
import org.springframework.stereotype.Component;

@Component
public class LoggedUser {
    public static Professor professor=null;
    public static Student student=null;

}
