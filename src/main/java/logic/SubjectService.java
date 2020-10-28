package logic;

import data.StudentRepository;
import data.SubjectRepository;
import model.Student;
import model.Subject;

import java.util.ArrayList;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

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

    public void showSubjectList() {

        System.out.println(SubjectRepository.subjectDatabase.toString());
    }

    public void registerToSubject(String pesel, String subjectName) {
        Subject subject=returnSubject(subjectName);
        subject.grades.put(returnStudent(pesel), new ArrayList<Integer>());
    }

    public Student returnStudent(String pesel) {
        for (Student obj : StudentRepository.studentDatabase) {
            if (obj.getPesel().equals(pesel)) {
                return obj;
            }
        }
        return null; // Optional-doczytac-w przypadku, gdy spodziewam sie czestego bledu przy wprowadzania ID-lepiej uzyc Optional.
    }

    public Subject returnSubject(String subjectName) {
        for (Subject obj : SubjectRepository.subjectDatabase) {
            if (obj.getSubjectName().equalsIgnoreCase(subjectName)) {
                return obj;
            }
        }
        return null;
    }


}
