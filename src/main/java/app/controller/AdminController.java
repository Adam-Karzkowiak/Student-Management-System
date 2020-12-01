package app.controller;


import app.data.ProfessorRepository;
import app.data.StudentRepository;
import app.exception.ProfessorNotFoundException;
import app.exception.StudentNotFoundException;
import app.model.Professor;
import app.model.Student;
import app.service.ProfessorService;
import app.service.StudentService;
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


    @PostMapping("/professors")
    @ResponseStatus(value = HttpStatus.CREATED, reason = "Professor created!")
    public Professor callCreateProfessor(@RequestBody Professor newProfessor) {
        return professorService.createProfessor(
                newProfessor.getLogin(),
                newProfessor.getPassword(),
                newProfessor.getName(),
                newProfessor.getSurname(),
                newProfessor.getPesel());
    }


    @PostMapping("/students")
    @ResponseStatus(value = HttpStatus.CREATED, reason = "Student created!")
    public Student callCreateStudent(@RequestBody Student newStudent) {
        return studentService.createStudent(
                newStudent.getLogin(),
                newStudent.getPassword(),
                newStudent.getName(),
                newStudent.getSurname(),
                newStudent.getPesel());
    }

    @DeleteMapping("/professors")
    public ResponseEntity<String> callRemoveProfessorAccount(@RequestParam String pesel) {
        if (ProfessorRepository.professorDatabase.stream().noneMatch(o -> o.getPesel().equals(pesel))) {
            throw new ProfessorNotFoundException(pesel);
        }
        professorService.removeProfessorAccount(pesel);
        return new ResponseEntity<>(pesel, HttpStatus.OK);

    }

    @DeleteMapping("/students")
    public ResponseEntity<String> callRemoveStudentAccount(@RequestParam String pesel) {
        if (StudentRepository.studentDatabase.stream().noneMatch(o -> o.getPesel().equals(pesel))) {
            throw new StudentNotFoundException(pesel);
        }
        studentService.removeStudentAccount(pesel);
        return new ResponseEntity<>(pesel, HttpStatus.OK);

    }


}
