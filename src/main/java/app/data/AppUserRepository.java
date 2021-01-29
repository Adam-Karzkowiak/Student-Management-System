package app.data;

import app.model.AppUser;


interface AppUserRepository {
    AppUser findByUsername(String username);

    boolean existsById(Long id);
}
