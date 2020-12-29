package app.data;

import app.model.AppUser;


public interface AppUserRepository  {
    AppUser findByUsername(String username);

    AppUser save(AppUser appUser);

    void deleteById(long id);

}
