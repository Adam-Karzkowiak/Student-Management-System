package app.model;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class Professor extends User {


    public Professor(int id, String login, String password, String name, String surname, String pesel) {
    super(id, login, password, name, surname, pesel);}

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", pesel='" + pesel + '\'' +
                '}';
    }
}
