package presentation;


import java.util.Scanner;

public class StudentMenu {
    LoginMenu loginMenu;

    public StudentMenu(LoginMenu loginMenu) {
        this.loginMenu = loginMenu;
    }

    final static Scanner scanDecision = new Scanner(System.in);
    private static int action;

    public void studentMenu() {
        do {
            System.out.println("Student panel");
            System.out.println("1. Check my grades");
            System.out.println("2. Register to subject");
            System.out.println("3. Logout");
            action = scanDecision.nextInt();
            switch (action) {
                case 1:
                    //TODO Show subjects list
                    break;
                case 2:
                    break;
            }
        } while (action != 3);
        loginMenu.login();
    }
}
