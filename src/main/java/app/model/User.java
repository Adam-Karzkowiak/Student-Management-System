package app.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Data
@Getter
@Setter
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
