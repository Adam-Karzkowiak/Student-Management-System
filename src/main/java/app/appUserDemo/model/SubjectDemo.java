package app.appUserDemo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class SubjectDemo {
    String subjectName;
    public Map<AppUser, ArrayList<Integer>> grades;


    public SubjectDemo(String subjectName, Map<AppUser, ArrayList<Integer>> grades) {
        this.subjectName = subjectName;
        this.grades = grades;
    }


    @Override
    public String toString() {
        return "Subject name :" + subjectName + "\n" +
                "Student grades :" + grades;
    }
}
