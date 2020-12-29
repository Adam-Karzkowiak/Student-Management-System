package app.data;

import app.model.AppUser;
import org.springframework.stereotype.Repository;

@Repository
public class AppUserRepositoryImpl implements AppUserRepository {


    @Override
    public AppUser findByUsername(String username) {
        return null;
    }

    @Override
    public AppUser save(AppUser appUser) {
        return null;
    }

    @Override
    public void deleteById(long id) {

    }
}
