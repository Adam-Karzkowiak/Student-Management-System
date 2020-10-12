package logic;

import data.StudentRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;

@ToString
@EqualsAndHashCode
@Data
public class StudentService extends UserService {
//utworz modele danych
public StudentService() {
}

    public StudentService(String login, String password, String name, String surname, String pesel) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
    }
    public static ArrayList<StudentService> addToRepository(StudentService object) {
        StudentRepository.studentDatabase.add(object);
        return StudentRepository.studentDatabase;
    }

    public static boolean checkPasswordAndLogin(String login, String password) {

        for (StudentService obj : StudentRepository.studentDatabase) {

            if (obj.getLogin().equals(login) && obj.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void printNameAndSurname (String pesel){
        for(StudentService obj : StudentRepository.studentDatabase){
            if(obj.getPesel().equals(pesel)){
                System.out.println(obj.getName()+ " "+obj.getSurname());
            }
        }
    }
    public static ArrayList<logic.StudentService> removeStudentAccount(String pesel){

        StudentRepository.studentDatabase.removeIf(student ->student.getPesel().equals(pesel));
        return StudentRepository.studentDatabase;
    }
}
