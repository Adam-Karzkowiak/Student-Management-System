package app.data;

import app.model.Subject;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SubjectRepository {
    public static List<Subject> subjectDatabase = new ArrayList<>();


    public List<Subject> addSubjectToRepository(Subject subject) {
        SubjectRepository.subjectDatabase.add(subject);
        return SubjectRepository.subjectDatabase;
    }

    public List<Subject> deleteSubject(String subjectName) {
        SubjectRepository.subjectDatabase.removeIf(subject -> subject.getSubjectName().equals(subjectName));
        return SubjectRepository.subjectDatabase;
    }

    public void addStudentToSubject(Subject subject, Student student) {
        if (!subject.grades.containsKey(student)) {
            subject.grades.put(student, new ArrayList<Integer>());
        }
    }

    public void addAGrade(Subject subject, Student student, int grade) {

        subject.grades.get(student).add(grade);
    }
}
