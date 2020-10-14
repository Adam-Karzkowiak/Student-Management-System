package presentation;

import data.ProfessorRepository;
import logic.ProfessorService;
import logic.ValidationService;
import java.util.Scanner;

public class AdminMenu {

    final static Scanner scanDecision = new Scanner(System.in);
    private static int action;
    private ProfessorService professorService;
    public AdminMenu(ProfessorService professorService) {
        this.professorService = professorService;

    }

    public static void adminPanel()  {
        String login;
        String password;
        String name;
        String surname;
        String pesel;

        do {
            System.out.println("Administration panel");
            System.out.println("1. Create professor account");
            System.out.println("2. Create student account");
            System.out.println("3. Delete professor account");
            System.out.println("4. Delete student account");
            System.out.println("5. Logout");
            action = scanDecision.nextInt();

            switch (action) {
                case 1:
                    System.out.println("Enter Login");
                    scanDecision.nextLine();
                    login = scanDecision.nextLine();
                    System.out.println("Enter Passowrd. ( 8 < X < 20 letters, at least: one uppercase, one lowercase, one number");
                    password = scanDecision.nextLine();
                    ValidationService.isPasswordValid(password);
                    System.out.println("Enter name");
                    name = scanDecision.nextLine();
                    ValidationService.checkName(name);
                    System.out.println("Enter surname");
                    surname = scanDecision.nextLine();
                    ValidationService.checkSurname(surname);
                    System.out.println("Enter pesel number");
                    pesel = scanDecision.nextLine();
                    ValidationService.isPeselValid(pesel);
                    professorService.createProfessor(login, password, name, surname, pesel);
                    System.out.println(ProfessorRepository.professorDatabase);
                    break;
                case 2:
                    break;
                case 3:
                    System.out.println("Provide PESEL number to delete account");
                    scanDecision.nextLine();
                    String peselToDelete = scanDecision.nextLine();
                    System.out.println("Do you want to delete ");
                    ProfessorService.printNameAndSurname(peselToDelete);
                    System.out.println("Y/N?");
                    String decision = scanDecision.nextLine();
                    if (decision.equalsIgnoreCase("Y")) {
                        ProfessorService.removeProfessorAccount(peselToDelete);
                        System.out.println("Account has been deleted");
                    } else {
                        System.out.println("Procedure has been cancelled");
                    }
                    break;
                case 4:
                    break;
            }
        } while (action != 5);
        LoginMenu.login();
    }



}

