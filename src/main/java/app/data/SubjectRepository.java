package app.data;


import app.model.AppUser;
import app.model.Subject;

import java.util.ArrayList;
import java.util.List;

public class SubjectRepository {
    public static List<Subject> subjectDatabaseDemo = new ArrayList<>();


    public List<Subject> addSubjectToRepository(Subject subject) {
        subjectDatabaseDemo.add(subject);
        return subjectDatabaseDemo;
    }

    public List<Subject> deleteSubject(String subjectName) {
        subjectDatabaseDemo.removeIf(subject -> subject.getSubjectName().equals(subjectName));
        return subjectDatabaseDemo;
    }

    public void addStudentToSubject(Subject subject, AppUser appUser) {
        if (!subject.grades.containsKey(appUser)) {
            subject.grades.put(appUser, new ArrayList<Integer>());
        }
    }

    public void addAGrade(Subject subject, AppUser appUser, int grade) {
        subject.grades.get(appUser).add(grade);
    }

}
