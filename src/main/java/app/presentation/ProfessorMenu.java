package app.presentation;

import app.authorization.LoggedUser;
import app.logic.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Scanner;
@Controller
public class ProfessorMenu {

    final static Scanner scanDecision = new Scanner(System.in);
    private static int action;
    SubjectService subjectService;

    @Autowired
    public ProfessorMenu(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

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
                    subjectService.showSubjectList();
                    break;
                case 2:
                    System.out.println("Create subject.");
                    System.out.println("Subject title: ");
                    scanDecision.nextLine();
                    String subjectName = scanDecision.nextLine();
                    subjectService.createSubject(subjectName);
                    break;
                case 3:
                    System.out.println("Show students registered for the subject");
                    System.out.println("Subject name: ");
                    scanDecision.nextLine();
                    subjectName = scanDecision.nextLine();
                    System.out.println("Students list : ");
                    subjectService.showRegisteredToSubject(subjectName);
                    break;
                case 4:
                    System.out.println("Show average grades from subject");
                    System.out.println("Provide subject name :");
                    scanDecision.nextLine();
                    subjectName = scanDecision.nextLine();
                    subjectService.calculateAverageForWholeClass(subjectName);
                    break;
                case 5:
                    System.out.println("Show student grades from subject");
                    System.out.println("Student pesel:");
                    scanDecision.nextLine();
                    String studentPesel = scanDecision.nextLine();
                    System.out.println("Subject name");
                    subjectName = scanDecision.nextLine();
                    subjectService.calculateAvgForStudent(subjectName, studentPesel);
                    break;
                case 6:
                    System.out.println("Grading a student");
                    System.out.println("Subject name :");
                    scanDecision.nextLine();
                    subjectName = scanDecision.nextLine();
                    System.out.println("Student pesel number :");
                    studentPesel = scanDecision.nextLine();
                    System.out.println("Grade : ");
                    int grade = scanDecision.nextInt();
                    subjectService.giveAGrade(subjectName, studentPesel, grade);
                    break;
            }

        } while (action != 7);
        System.out.println("Logout? (YES/NO)");
        scanDecision.nextLine();
        String logout = scanDecision.nextLine();
        if (logout.equalsIgnoreCase("yes")) {
            return true;
        }
        return false;
    }


}

