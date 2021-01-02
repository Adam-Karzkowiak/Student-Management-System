package app.data;

import app.model.AppUser;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AppUserRepositoryImpl implements AppUserRepository {
    public static List<AppUser> appUserDatabase = new ArrayList<>();


    @Override
    public AppUser findByUsername(String username) {
        for (AppUser appUser : appUserDatabase) {
            if (appUser.getUsername().equals(username)) {
                return appUser;
            }
        }
        return null;
    }


    @Override
    public void save(AppUser appUser) {
        appUserDatabase.add(appUser);
    }

    @Override
    public void deleteById(long id) {


    }
}
