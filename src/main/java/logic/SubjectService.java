package logic;

import data.SubjectRepository;
import model.Student;
import model.Subject;

import java.util.ArrayList;
import java.util.HashMap;

public class SubjectService {
    private SubjectRepository subjectRepository;
    HashMap<Student, ArrayList<Integer>> grades;

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

    public void showSubjectList() {
        System.out.println(SubjectRepository.subjectDatabase.toString());
    }


//    public void addGrade(String lessonName, int grade) {
//        if (lessons.get(lessonName) == null) {
//            ArrayList<Integer> grades = new ArrayList<>();
//            lessons.put(lessonName, grades);
//        }
//        lessons.get(lessonName).add(grade);
//    }
}
