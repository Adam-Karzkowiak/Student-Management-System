package app.model;


import lombok.*;


@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
@Data
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
