package logic;

import data.ProfessorRepository;
import data.StudentRepository;
import data.SubjectRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.Scanner;

@Data
@EqualsAndHashCode

public class SubjectService {
    String subjectName;
    final static Scanner scanWords= new Scanner(System.in);
    private static ArrayList<StudentService> listOfStudents = new ArrayList<>(); //to chyba wypad do data package-TU JEST BLAD
    //TA LISTA NIE MOZE BYC STATYCZNA-KAZDA INSTANCJA MA POSIADAC SWOJA WLASNA LISTE STUDENTOW.

    public SubjectService(String subjectName) {
        this.subjectName = subjectName;
    }

    public SubjectService() {

    }

    public static ArrayList<logic.StudentService> registerToSubject() {
        System.out.println("Subject registration");
        System.out.println("Provide your pesel");
        String peselNumber = scanWords.nextLine();
        System.out.println("Name of subject :");
        String subjectName = scanWords.nextLine();
        for (StudentService obj : StudentRepository.studentDatabase)
            if(obj.getPesel().equals(peselNumber)){
                listOfStudents.add(obj);
            }
        return listOfStudents;
    }

    public static ArrayList<logic.SubjectService> addToRepository(SubjectService object) {
        SubjectRepository.subjectDatabase.add(object);
        return SubjectRepository.subjectDatabase;
    }

    public static void showListOfSubjects() {
        System.out.println(SubjectRepository.subjectDatabase.toString());
    }

    @Override
    public String toString() {
        return "Subject name : " + subjectName + '\n'+
                "Registered students : "+ listOfStudents +'\n';
    }
}
