package app.service;

import app.data.StudentRepository;
import app.exception.StudentNotFoundException;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import app.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;



@ToString
@EqualsAndHashCode(callSuper = false)
@Data
@Service
public class StudentService {
    private IdentifierProvider identifierProvider;
    private StudentRepository studentRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public StudentService(IdentifierProvider identifierProvider,
                          StudentRepository studentRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.identifierProvider = identifierProvider;
        this.studentRepository = studentRepository;
        this.bCryptPasswordEncoder=bCryptPasswordEncoder;
    }

    public Student createStudent(String login, String password, String name, String surname, String pesel) {
        int id = identifierProvider.getId();
        Student student = new Student(id, login, password, name, surname, pesel);
        student.setPassword(bCryptPasswordEncoder.encode(student.getPassword()));
        return studentRepository.saveStudent(student);
    }

    public void removeStudentAccount(String pesel) {
        if (StudentRepository.studentDatabase.stream().noneMatch(o -> o.getPesel().equals(pesel))) {
            throw new StudentNotFoundException(pesel);
        }
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



    public Student getStudent(String login) {
        for (Student obj : StudentRepository.studentDatabase) {
            if (obj.getLogin().equals(login)) {
                return obj;
            }
        }
        return null;
    }

}
