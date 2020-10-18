package logic;

import data.SubjectRepository;
import model.Subject;

import java.util.ArrayList;

public class SubjectService {
    private SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public Subject createSubject(String subjectName) {

        Subject subject = new Subject(subjectName);
        addToRepository(subject);
        return subject;
    }

    public ArrayList<Subject> removeSubject(String subjectName) {
        SubjectRepository.subjectDatabase.removeIf(subject -> subject.getSubjectName().equals(subjectName));
        return SubjectRepository.subjectDatabase;
    }

    public ArrayList<Subject> addToRepository(Subject subject) {
        SubjectRepository.subjectDatabase.add(subject);
        return SubjectRepository.subjectDatabase;
    }
    public void showSubjectList(){
        System.out.println(SubjectRepository.subjectDatabase.toString());
    }
}
