package app.logic;

import app.data.StudentRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import app.model.Student;
import app.model.Subject;
import org.springframework.stereotype.Service;


import java.util.ArrayList;

@ToString
@EqualsAndHashCode(callSuper = false)
@Data
@Service
public class StudentService {
    private IdentifierProvider identifierProvider;
    private StudentRepository studentRepository;

    public StudentService(IdentifierProvider identifierProvider, StudentRepository studentRepository) {
        this.identifierProvider = identifierProvider;
        this.studentRepository = studentRepository;
    }

    public Student createStudent(String login, String password, String name, String surname, String pesel) {
        int id = identifierProvider.getId();
        Student student = new Student(id, login, password, name, surname, pesel);
        return studentRepository.saveStudent(student);
    }

    public void removeStudentAccount(String pesel) {
        studentRepository.deleteStudent(pesel);
    }


    public boolean checkPasswordAndLogin(String login, String password) {

        for (Student obj : studentRepository.studentDatabase) {

            if (obj.getLogin().equals(login) && obj.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void printID(String login, String password) {
        for (Student obj : studentRepository.studentDatabase) {
            if (obj.getLogin().equals(login) && obj.getPassword().equals(password)) {
                System.out.println(obj.getId());
            }
        }
    }

    public void printNameAndSurname(String pesel) {
        for (Student obj : studentRepository.studentDatabase) {
            if (obj.getPesel().equals(pesel)) {
                System.out.println(obj.getName() + " " + obj.getSurname());
            }
        }
    }

    public Student getStudent(String login) {
        for (Student obj : StudentRepository.studentDatabase) {
            if (obj.getLogin().equals(login)) {
                return obj;
            }
        }
        return null;
    }

    public void printAllStudentGrades(ArrayList<Subject> grades,String studentPesel){

    }

}
