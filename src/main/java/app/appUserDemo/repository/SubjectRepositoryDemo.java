package app.appUserDemo.repository;


import app.appUserDemo.model.AppUser;
import app.appUserDemo.model.SubjectDemo;

import java.util.ArrayList;
import java.util.List;

public class SubjectRepositoryDemo {
    public static List<SubjectDemo> subjectDatabaseDemo = new ArrayList<>();


    public List<SubjectDemo> addSubjectToRepository(SubjectDemo subject) {
        subjectDatabaseDemo.add(subject);
        return subjectDatabaseDemo;
    }

    public List<SubjectDemo> deleteSubject(String subjectName) {
        subjectDatabaseDemo.removeIf(subjectDemo -> subjectDemo.getSubjectName().equals(subjectName));
        return subjectDatabaseDemo;
    }

    public void addStudentToSubject(SubjectDemo subject, AppUser appUser) {
        if (!subject.grades.containsKey(appUser)) {
            subject.grades.put(appUser, new ArrayList<Integer>());
        }
    }

    public void addAGrade(SubjectDemo subject, AppUser appUser, int grade) {
        subject.grades.get(appUser).add(grade);
    }

}
