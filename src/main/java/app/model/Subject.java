package app.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Map;


@NoArgsConstructor
@Getter
@Setter
public class Subject {

    String subjectName;
    public Map<Student, ArrayList<Integer>> grades;


    public Subject(String subjectName, Map<Student, ArrayList<Integer>> grades) {
        this.subjectName = subjectName;
        this.grades = grades;
    }

    @Override
    public String toString() {
        return "Subject :" + subjectName + '\'' +
                " grades :" + grades;
    }
}
