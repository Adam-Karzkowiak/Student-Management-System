package app.data;

import app.model.AppUser;
import org.springframework.stereotype.Repository;


@Repository
public interface AppUserRepository  {
    AppUser findByUsername(String username);

    AppUser save(AppUser appUser);

    void deleteById(long id);

}
