package app.model;


import lombok.*;


@Getter
@Setter
@NoArgsConstructor
public class Student extends User {
    public Student(int id, String login, String password, String name, String surname, String pesel) {
        super(id, login, password, name, surname, pesel);
    }


    @Override
    public String toString() {
        return "Student :" +
                "id :" + id +
                ", name :" + name + '\'' +
                ", surname :" + surname + '\'' +
                ", pesel :" + pesel + '\'' ;
    }
}
