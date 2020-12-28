package app.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StudentSubjectGradeDTO {
    String subjectName;
    long studentId;
    int grade;
}
