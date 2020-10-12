package presentation;


import logic.SubjectService;

import java.util.Scanner;

public class StudentMenu {

    final static Scanner scanDecision = new Scanner(System.in);
    private static int action;

    public static void studentMenu() {
        do {
            System.out.println("Student panel");
            System.out.println("1. Check my grades");
            System.out.println("2. Register to subject");
            System.out.println("3. Logout");
            action = scanDecision.nextInt();
            switch (action) {
                case 1:
                    //Show subjects list
                    break;
                case 2:
                    SubjectService.registerToSubject();
                    break;
            }
        } while (action != 3);
        LoginMenu.login();
    }
}
