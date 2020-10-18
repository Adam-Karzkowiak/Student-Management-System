package model;

import lombok.Data;

@Data
public class Subject {

    String subjectName;

    public Subject(String subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectName='" + subjectName + '\'' +
                '}';
    }
    //map
}
