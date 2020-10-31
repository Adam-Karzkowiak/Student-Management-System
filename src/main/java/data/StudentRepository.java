package data;

import model.Student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentRepository {
    public static List<Student> studentDatabase = new ArrayList<>();

    public Student save(Student student) {
        studentDatabase.add(student);
        return student;
    }

    public Student delete(String pesel) {
        Iterator<Student> iterator = studentDatabase.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getPesel().equals(pesel)) {
                iterator.remove();
            }
        }
    }
}
