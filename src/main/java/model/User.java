package model;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

@ToString
@Data
@Component
abstract class User {
    int id;
    String login;
    String password;
    String name;
    String surname;
    String pesel;

    public User(int id, String login, String password, String name, String surname, String pesel) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;

    }
    public User(){

    }


}
