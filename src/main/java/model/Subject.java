package model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

@Data
@Component
public class Subject {

    String subjectName;
    public HashMap<Student, ArrayList<Integer>> grades;


    public Subject(String subjectName, HashMap<Student, ArrayList<Integer>> grades) {
        this.subjectName = subjectName;
        this.grades = grades;
    }

    @Override
    public String toString() {
        return "Subject :" + subjectName + '\'' +
                " grades :" + grades;
    }
}
