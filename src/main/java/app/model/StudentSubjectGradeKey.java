package app.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StudentSubjectGradeKey {
    String subjectName;
    String studentPesel;
    int grade;
}
