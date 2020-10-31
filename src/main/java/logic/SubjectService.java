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

    public ArrayList<Subject> removeSubject(String subjectName) {
        subjectRepository.deleteSubject(subjectName);
        return SubjectRepository.subjectDatabase;
    }

    public ArrayList<Subject> addToSubjectDatabase(Subject subject) {
        subjectRepository.addSubjectToRepository(subject);
        return SubjectRepository.subjectDatabase;
    }

    public void showSubjectList() {  // zmienic-ma wyswietlac tylko przedmioty, bez HashMapy grades

        System.out.println(SubjectRepository.subjectDatabase.toString());
    }

    public void registerToSubject(String pesel, String subjectName) {
        Subject subject = getSubject(subjectName); //sprawdzanie-czy nie zarejestrowany-czy nic sie nie dubluje
        Student student = getStudent(pesel);
        subjectRepository.addStudentToSubject(subject,student);
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
                System.out.println(obj.grades.keySet()); //uzywa toString Student
            }
        }
    }

    public void giveAGrade(String subjectName, String studentPesel, int grade) {
        Subject subject = returnSubject(subjectName);
        Student student = returnStudent(studentPesel);
        subject.grades.get(student).add(grade);
    }

//    public void calculateAvgForStudent(String subjectName, String studentPesel) {
//        Subject subject = returnSubject(subjectName);
//        Student student = returnStudent(studentPesel);
//        subject.grades.get(student).re
//    }

//    public double avgCalculation(ArrayList<Integer> array){
//        int sum=0;
//        double avg=0;
//        for (Integer integer : array) {
//            sum = integer;
//        }
//        avg=(double) sum/array.size();
//        return avg;
//    }

}
