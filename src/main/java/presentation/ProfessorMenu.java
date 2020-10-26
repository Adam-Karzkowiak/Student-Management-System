package presentation;

import logic.SubjectService;
//import logic.SubjectService;

import java.util.Scanner;

public class ProfessorMenu {

    final static Scanner scanDecision = new Scanner(System.in);
    private static int action;
private SubjectService subjectService;

    public ProfessorMenu(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    public void professorMenu() {
        do {
            System.out.println("Professor panel ID ");
            System.out.println("1. Show a list of subjects");
            System.out.println("2. Add subject");
            System.out.println("3. Show registered students to a subject");
            System.out.println("4. Show average grades of all students from subject");
            System.out.println("5. Show specific student grades from a subject");
            System.out.println("6. Give student a grade from subject");
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
                    //TODO Show list of students registered to specific subject
                    break;
                case 4:
                    //TODO Calculate avg grades from all students to specific subject
                    break;
                case 5:
                    //TODO Show specific student grades from a subject
                    break;
                case 6:
                    //TODO Add grade (int) to grade arraylist from specific subject to specific student
                    break;
            }

        } while (action != 7);
        ControllerMenu.callLoginMenu();
    }


}

