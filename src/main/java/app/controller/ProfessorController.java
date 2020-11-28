package app.controller;

import app.authorization.LoggedUser;
import app.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Scanner;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    final static Scanner scanDecision = new Scanner(System.in);
    private static int action;
    private String subjectName;
    private String studentPesel;
    private int grade;
    SubjectService subjectService;

    @Autowired
    public ProfessorController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/home")
    public boolean professorMenu() {
        do {
            System.out.println(LoggedUser.professor.getName() + " " + LoggedUser.professor.getSurname() + " professor panel");
            System.out.println("1. Show a list of subjects");
            System.out.println("2. Add subject");
            System.out.println("3. Show registered students to a subject");
            System.out.println("4. Show average grades of all students from subject");
            System.out.println("5. Show specific student grades from a subject");
            System.out.println("6. Give student a grade from a subject");
            System.out.println("7. Logout");
            action = scanDecision.nextInt();
            switch (action) {
                case 1:
                    callShowSubjectList();
                    break;
                case 2:
                    callCreateSubject(subjectName);
                    break;
                case 3:
                    callShowRegisteredToSubject(subjectName);
                    break;
                case 4:
                    callCalculateAverageForWholeClass(subjectName);
                    break;
                case 5:
                    callCalculateAvgForStudent(subjectName, studentPesel);
                    break;
                case 6:
                    callGiveAGrade(subjectName, studentPesel, grade);
                    break;
            }

        } while (action != 7);
        System.out.println("Logout? (YES/NO)");
        scanDecision.nextLine();
        String logout = scanDecision.nextLine();
        return logout.equalsIgnoreCase("yes");
    }

    @GetMapping("/subjects")
    public void callShowSubjectList() {
        subjectService.showSubjectList();
    }

    @PostMapping("/subjects")
    @ResponseStatus(value = HttpStatus.CREATED, reason = "Subject created!")
    private void callCreateSubject(@RequestBody String subjectName) {
        subjectService.createSubject(subjectName);
    }

    public void callShowRegisteredToSubject() {
        System.out.println("Show students registered for the subject");
        System.out.println("Subject name: ");
        scanDecision.nextLine();
        String subjectName = scanDecision.nextLine();
        System.out.println("Students list : ");
        subjectService.showRegisteredToSubject(subjectName);
    }

    public void callCalculateAverageForWholeClass() {
        System.out.println("Show average grades from subject");
        System.out.println("Provide subject name :");
        scanDecision.nextLine();
        String subjectName = scanDecision.nextLine();
        subjectService.calculateAverageForWholeClass(subjectName);
    }

    public void callCalculateAvgForStudent() {
        System.out.println("Show student grades from subject");
        System.out.println("Student pesel:");
        scanDecision.nextLine();
        String studentPesel = scanDecision.nextLine();
        System.out.println("Subject name");
        String subjectName = scanDecision.nextLine();
        subjectService.calculateAvgForStudent(subjectName, studentPesel);

    }

    public void callGiveAGrade() {
        System.out.println("Grading a student");
        System.out.println("Subject name :");
        scanDecision.nextLine();
        String subjectName = scanDecision.nextLine();
        System.out.println("Student pesel number :");
        String studentPesel = scanDecision.nextLine();
        System.out.println("Grade : ");
        int grade = scanDecision.nextInt();
        subjectService.giveAGrade(subjectName, studentPesel, grade);
    }
}