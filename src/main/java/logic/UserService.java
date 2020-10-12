package logic;

import lombok.Data;

import java.util.Scanner;

@Data
public class UserService {
    int id =1; // DO POPRAWY
    String login;
    String password;
    String name;
    String surname;
    String pesel;
    final Scanner scanner = new Scanner(System.in);

    public UserService(int id, String login, String password, String name, String surname, String pesel) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        id++;
    }


    public UserService() {
    }





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserService userService = (UserService) o;

        return id == userService.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}

