package app.controller;


import app.model.Professor;
import app.service.ProfessorService;
import app.service.StudentService;
import app.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/admin")
public class AdminController {

    ProfessorService professorService;
    StudentService studentService;

    @Autowired
    public AdminController(ProfessorService professorService, StudentService studentService) {
        this.professorService = professorService;
        this.studentService = studentService;
    }


        @PostMapping("/create-acc/professor")
    @ResponseStatus(value = HttpStatus.CREATED, reason = "Professor created!")
    public Professor callCreateProfessor(@RequestBody Professor newProfessor) {
        return professorService.createProfessor(
                newProfessor.getLogin(),
                newProfessor.getPassword(),
                newProfessor.getName(),
                newProfessor.getSurname(),
                newProfessor.getPesel());
    }


    @PostMapping("/create-acc/student")
    public void callCreateStudent() {
        System.out.println("Enter Login");
        scanDecision.nextLine();
        String login = scanDecision.nextLine();
        System.out.println("Enter Passowrd. ( 8 < X < 20 letters, at least: one uppercase, one lowercase, one number");
        String password = scanDecision.nextLine();
        ValidationService.passwordValidation(password);
        System.out.println("Enter name");
        String name = scanDecision.nextLine();
        ValidationService.checkName(name);
        System.out.println("Enter surname");
        String surname = scanDecision.nextLine();
        ValidationService.checkSurname(surname);
        System.out.println("Enter pesel number");
        String pesel = scanDecision.nextLine();
        ValidationService.peselValidation(pesel);
        studentService.createStudent(login, password, name, surname, pesel);
    }

    public void callRemoveProfessorAccount() {
        System.out.println("Provide PESEL number to delete account");
        scanDecision.nextLine();
        String peselToDelete = scanDecision.nextLine();
        System.out.println("Do you want to delete ");
        professorService.printNameAndSurname(peselToDelete);
        System.out.println("Y/N?");
        String decision = scanDecision.nextLine();
        if (decision.equalsIgnoreCase("Y")) {
            professorService.removeProfessorAccount(peselToDelete);
            System.out.println("Account has been deleted");
        } else {
            System.out.println("Procedure has been cancelled");
        }
    }

    public void callRemoveStudentAccount() {
        System.out.println("Provide PESEL number to delete account");
        scanDecision.nextLine();
        String peselToDelete = scanDecision.nextLine();
        System.out.println("Do you want to delete ");
        studentService.printNameAndSurname(peselToDelete);
        System.out.println("Y/N?");
        String decision = scanDecision.nextLine();
        if (decision.equalsIgnoreCase("Y")) {
            studentService.removeStudentAccount(peselToDelete);
            System.out.println("Account has been deleted");
        } else {
            System.out.println("Procedure has been cancelled");
        }
    }
}
