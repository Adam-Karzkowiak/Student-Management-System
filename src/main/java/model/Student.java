package model;

import lombok.Data;


public class Student extends User {
    public Student(int id, String login, String password, String name, String surname, String pesel) {
        super(id, login, password, name, surname, pesel);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", pesel='" + pesel + '\'' +
                '}';
    }
}
