package logic;

import lombok.Data;

@Data
public class AdminService {
    final static String login = "admin";
    final static String password = "admin";

    public static String getLogin() {

        return login;
    }

    public static String getPassword() {

        return password;
    }

}
