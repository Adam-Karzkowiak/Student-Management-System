package model;

import lombok.Data;

import java.util.ArrayList;
import java.util.Map;

@Data
public class Subject {

    String subjectName;
    public Map<Student, ArrayList<Integer>> grades;


    public Subject(String subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectName='" + subjectName + '\'' +
                '}';
    }

}
