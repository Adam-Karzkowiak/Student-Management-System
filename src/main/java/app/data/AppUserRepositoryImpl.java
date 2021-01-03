package app.data;

import app.model.AppUser;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Qualifier("appUsers")
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

    @Override
    public AppUser getOne(long id){
        for(AppUser appUser : appUserDatabase){
            if(appUser.getId()==id){
                return appUser;
            }
        }
        return null;
    }
}
