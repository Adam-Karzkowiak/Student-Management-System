package app.controller;


import app.data.ProfessorRepository;
import app.exception.ProfessorNotFoundException;
import app.model.Professor;
import app.model.Student;
import app.service.ProfessorService;
import app.service.StudentService;
import app.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public Student callCreateStudent(@RequestBody Student newStudent) {
        return studentService.createStudent(
                newStudent.getLogin(),
                newStudent.getPassword(),
                newStudent.getName(),
                newStudent.getSurname(),
                newStudent.getPesel());
    }

    @DeleteMapping("/delete/professors")
    public ResponseEntity<String> callRemoveProfessorAccount(@RequestBody String pesel) {
        if (ProfessorRepository.professorDatabase.stream().noneMatch(o -> o.getPesel().equals(pesel))) {
            throw new ProfessorNotFoundException(pesel);
        }
        professorService.removeProfessorAccount(pesel);
        return new ResponseEntity<>(pesel, HttpStatus.OK);

    }

    public ResponseEntity<V> callRemoveStudentAccount() {
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
