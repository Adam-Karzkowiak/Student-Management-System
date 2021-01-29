package app.data;

import app.model.AppUser;


public interface AppUserRepository {
    AppUser findByUsername(String username);

    boolean existsById(Long id);

    AppUser save(AppUser entity);

    void deleteById(Integer id);

    AppUser getOne(int id);
}
