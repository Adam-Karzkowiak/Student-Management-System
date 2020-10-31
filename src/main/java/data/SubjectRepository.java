package data;

import model.Subject;

import java.util.ArrayList;

public class SubjectRepository {
    public static ArrayList<Subject> subjectDatabase = new ArrayList<>();

//addsubject np

    public ArrayList<Subject> addSubjectToRepository(Subject subject) {
        SubjectRepository.subjectDatabase.add(subject);
        return SubjectRepository.subjectDatabase;
    }

    public ArrayList<Subject> deleteSubject(String subjectName) {
        SubjectRepository.subjectDatabase.removeIf(subject -> subject.getSubjectName().equals(subjectName));
        return SubjectRepository.subjectDatabase;
    }
}
