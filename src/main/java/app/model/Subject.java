package app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Entity
@Data
@NoArgsConstructor
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String subjectName;
    public Map<AppUser, ArrayList<Integer>> grades;


    public Subject(final String subjectName, final HashMap<AppUser, ArrayList<Integer>> grades) {
    }


    @Override
    public String toString() {
        return "Subject name :" + subjectName + "\n" +
                "Student grades :" + grades;
    }
}
