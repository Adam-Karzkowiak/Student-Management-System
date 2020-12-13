package app.appUserDemo.repository;

import app.appUserDemo.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;



public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);

}
