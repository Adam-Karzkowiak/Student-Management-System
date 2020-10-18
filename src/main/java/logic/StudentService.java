package logic;

import data.StudentRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import model.Student;

import java.util.ArrayList;

@ToString
@EqualsAndHashCode(callSuper = false)
@Data
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
        addToRepository(student);
        return student;
    }

    public ArrayList<Student> removeStudentAccount(String pesel) {
        studentRepository.studentDatabase.removeIf(student -> student.getPesel().equals(pesel));
        return studentRepository.studentDatabase;
    }

    public ArrayList<Student> addToRepository(Student student) {
        studentRepository.studentDatabase.add(student);
        return studentRepository.studentDatabase;
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

}
