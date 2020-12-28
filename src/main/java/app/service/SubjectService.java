package app.service;

import app.data.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SubjectService {
    private SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {

        this.subjectRepository = subjectRepository;
    }

    public Subject createSubject(String subjectName) {
        HashMap<Student, ArrayList<Integer>> grades = new HashMap<>();
        Subject subject = new Subject(subjectName, grades);
        addToSubjectDatabase(subject);
        return subject;
    }

    public List<Subject> removeSubject(String subjectName) {
        subjectRepository.deleteSubject(subjectName);
        return SubjectRepository.subjectDatabase;
    }

    public List<Subject> addToSubjectDatabase(Subject subject) {
        subjectRepository.addSubjectToRepository(subject);
        return SubjectRepository.subjectDatabase;
    }

    public List<String> showSubjectList() {
        List<String> subNames = new ArrayList<>();
        for (Subject o : SubjectRepository.subjectDatabase) {
            subNames.add(o.getSubjectName());
        }
        return subNames;
    }

    public void registerToSubject(String pesel, String subjectName) {
        Subject subject = getSubject(subjectName);
        Student student = getStudent(pesel);
        subjectRepository.addStudentToSubject(subject, student);
    }

    public Student getStudent(String pesel) {
        for (Student obj : StudentRepository.studentDatabase) {
            if (obj.getPesel().equals(pesel)) {
                return obj;
            }
        }
        return null;
    }

    public Subject getSubject(String subjectName) {
        for (Subject obj : SubjectRepository.subjectDatabase) {
            if (obj.getSubjectName().equalsIgnoreCase(subjectName)) {
                return obj;
            }
        }
        return null;
    }

    public Set<Student> showRegisteredToSubject(String subjectName) {
        for (Subject obj : SubjectRepository.subjectDatabase) {
            if (obj.getSubjectName().equalsIgnoreCase(subjectName)) {
                return obj.grades.keySet();
            }
        }
        return null;
    }

    public void showAllStudentGrades(String pesel) {
        Student student = getStudent(pesel);
        for (Subject obj : SubjectRepository.subjectDatabase) {
            if (obj.grades.containsKey(student)) {
                System.out.println(obj.getSubjectName() + " : " + obj.grades.get(student));

            }
        }

    }

    public void giveAGrade(String subjectName, String studentPesel, int grade) {
        Subject subject = getSubject(subjectName);
        Student student = getStudent(studentPesel);
        subjectRepository.addAGrade(subject, student, grade);
    }

    public double calculateAvgForStudent(String subjectName, String studentPesel) {
        Subject subject = getSubject(subjectName);
        Student student = getStudent(studentPesel);
        ArrayList<Integer> calculatedAvg = subject.grades.get(student);
        return calculatedAvg.stream().mapToInt(a -> a).average().orElse(0.0);


    }

    public Map<String, Double> calculateAverageForWholeClass(String subjectName) {
        Subject subject = getSubject(subjectName);
        Map<String, Double> avgForClass = new HashMap<>();
        for (Map.Entry<Student, ArrayList<Integer>> entry : subject.grades.entrySet()) {
            ArrayList<Integer> studentGrades = entry.getValue();
            double average = studentGrades.stream().mapToInt(a -> a).average().orElse(0.0);
            avgForClass.put(entry.getKey().getSurname(), average);
        }
        return avgForClass;
    }


}
