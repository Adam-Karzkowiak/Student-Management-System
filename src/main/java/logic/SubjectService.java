package logic;

import data.StudentRepository;
import data.SubjectRepository;
import model.Student;
import model.Subject;

import java.util.*;


public class SubjectService {
    private SubjectRepository subjectRepository;

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

    public void showSubjectList() {  // zmienic-ma wyswietlac tylko przedmioty, bez HashMapy grades

        System.out.println(SubjectRepository.subjectDatabase.toString());
    }

    public void registerToSubject(String pesel, String subjectName) { //zrobione
        Subject subject = getSubject(subjectName); //sprawdzanie-czy nie zarejestrowany-czy nic sie nie dubluje
        Student student = getStudent(pesel);
        subjectRepository.addStudentToSubject(subject, student);
    }

    public Student getStudent(String pesel) { //getStudent
        for (Student obj : StudentRepository.studentDatabase) {
            if (obj.getPesel().equals(pesel)) {
                return obj;
            }
        }
        return null; // Optional-doczytac. Gdy spodziewam sie czestego bledu przy wprowadzania ID-lepiej uzyc Optional.
    }

    public Subject getSubject(String subjectName) { //getSubject
        for (Subject obj : SubjectRepository.subjectDatabase) {
            if (obj.getSubjectName().equalsIgnoreCase(subjectName)) {
                return obj;
            }
        }
        return null;
    }

    public void showRegisteredToSubject(String subjectName) {
        for (Subject obj : SubjectRepository.subjectDatabase) {
            if (obj.getSubjectName().equalsIgnoreCase(subjectName)) {
                System.out.println(obj.grades.keySet());
            }
        }
    }

    public void giveAGrade(String subjectName, String studentPesel, int grade) {
        Subject subject = getSubject(subjectName);
        Student student = getStudent(studentPesel);
        subjectRepository.addAGrade(subject, student, grade);
    }

    public void calculateAvgForStudent(String subjectName, String studentPesel) {
        Subject subject = getSubject(subjectName);
        Student student = getStudent(studentPesel);
        ArrayList<Integer> calculatedAvg = subject.grades.get(student);
        double average = calculatedAvg.stream().mapToInt(a -> a).average().orElse(0.0);
        System.out.println("Student :" + student.getName() + " " + student.getSurname() + " Average: " + average + " " + subjectName);

    }

    public void calculateAverageForWholeClass(String subjectName) {
        Subject subject = getSubject(subjectName);
        System.out.println("Subject :"+subjectName);
        for (Map.Entry<Student, ArrayList<Integer>> entry : subject.grades.entrySet()) {
            ArrayList<Integer> studentGrades = entry.getValue();
            double average = studentGrades.stream().mapToInt(a -> a).average().orElse(0.0);
            System.out.println("Student " + entry.getKey().getName() + " " + entry.getKey().getSurname() + " Average : " + average);
        }
    }


}
