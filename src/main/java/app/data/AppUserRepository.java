package app.data;

import app.model.AppUser;


public interface AppUserRepository {
    AppUser findByUsername(String username);

    boolean existsById(Long id);
}
