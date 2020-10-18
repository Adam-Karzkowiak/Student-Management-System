package logic;

final public class ValidationService {


    public static void passwordValidation(String password) {

        if (password.length() > 20 || password.length() < 8) {
            throw new IllegalArgumentException("Password must be less than 20 and more than 8 characters in length.");
        }
        String upperCaseChars = "(.*[A-Z].*)";
        if (!password.matches(upperCaseChars)) {
            throw new IllegalArgumentException("Password must have at least one uppercase character.");
        }
        String lowerCaseChars = "(.*[a-z].*)";
        if (!password.matches(lowerCaseChars)) {
            throw new IllegalArgumentException("Password must have at least one lowercase character");
        }
        String numbers = "(.*[0-9].*)";
        if (!password.matches(numbers)) {
            throw new IllegalArgumentException("Password must have at least one number");
        }

    }

    public static void peselValidation(String pesel) {
        int[] digits = new int[11];
        for (int i = 0; i < 11; i++) {
            digits[i] = Integer.parseInt(pesel.substring(i, i + 1));
        }
        int[] weights = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};
        int check = 0;
        for (int i = 0; i < 10; i++) {
            check += weights[i] * digits[i];
        }
        int lastNumber = check % 10;
        int controlNumber = 10 - lastNumber;

        if (controlNumber != digits[10]) {
            throw new IllegalArgumentException("Pesel is not correct.");
        }
    }

    public static void checkName(String name) {
        if (!name.matches("[A-Za-z]+")) {
            throw new IllegalArgumentException("Wrong name. If you are Elon Musk daughter, Æ A-12, contact with our customer service.");
        }
    }

    public static void checkSurname(String surname) {
        if (!surname.matches("[A-Za-z]+")) {
            throw new IllegalArgumentException("Wrong surname.");
        }
    }

}
