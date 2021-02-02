package app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    @ElementCollection
    public Map<AppUser, ArrayList<Integer>> grades;


    public Subject(final String subjectName, final HashMap<AppUser, ArrayList<Integer>> grades) {
    }


    @Override
    public String toString() {
        return "Subject name :" + subjectName + "\n" +
                "Student grades :" + grades;
    }
}
