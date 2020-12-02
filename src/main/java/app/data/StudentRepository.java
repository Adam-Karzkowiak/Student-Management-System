package app.data;

import app.exception.StudentNotFoundException;
import app.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class StudentRepository {
    // Spring Data @RepositoryRestResource(collectionResourceRel = "student", path = "student")
    public static List<Student> studentDatabase = new ArrayList<>();

    public Student saveStudent(Student student) {
        studentDatabase.add(student);
        return student;
    }

    public void deleteStudent(String pesel) {
        if (StudentRepository.studentDatabase.stream().noneMatch(o -> o.getPesel().equals(pesel))) {
            throw new StudentNotFoundException(pesel);
        }
        Iterator<Student> iterator = studentDatabase.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getPesel().equals(pesel)) {
                iterator.remove();
            }
        }
    }
}
