package logic;

import data.ProfessorRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;

@ToString
@EqualsAndHashCode(callSuper = true)
@Data
public class ProfessorService extends UserService {


    public static int id;

    public ProfessorService() {
    }

    public ProfessorService(String login, String password, String name, String surname, String pesel) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        id++;
    }
    public static ArrayList<ProfessorService> addToRepository(ProfessorService object) {
        ProfessorRepository.professorDatabase.add(object);
        return ProfessorRepository.professorDatabase;
    }

    public static boolean checkPasswordAndLogin(String login, String password) {

        for (ProfessorService obj : ProfessorRepository.professorDatabase) {

            if (obj.getLogin().equals(login) && obj.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void printID (String login, String password){
        for (ProfessorService obj : ProfessorRepository.professorDatabase){
            if(obj.getLogin().equals(login) && obj.getPassword().equals(password)){
                System.out.println(obj.getId());
            }
        }
    }

    public static ArrayList<logic.ProfessorService> removeProfessorAccount(String pesel){

        ProfessorRepository.professorDatabase.removeIf(professor ->professor.getPesel().equals(pesel));
        return ProfessorRepository.professorDatabase;
    }

    public static void printNameAndSurname (String pesel){
        for(ProfessorService obj : ProfessorRepository.professorDatabase){
            if(obj.getPesel().equals(pesel)){
                System.out.println(obj.getName()+ " "+obj.getSurname());
            }
        }
    }



}
