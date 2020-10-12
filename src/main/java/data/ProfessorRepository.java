package data;

import lombok.Data;

import java.util.ArrayList;
import java.util.Scanner;

@Data
public class ProfessorRepository {
    public static ArrayList<logic.ProfessorService> professorDatabase = new ArrayList<>();
static final Scanner scan = new Scanner(System.in);


}
