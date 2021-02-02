package app.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StudentSubjectGradeDTO {
    String subjectName;
    int studentId;
    int grade;
}
