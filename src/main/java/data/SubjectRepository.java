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
}
