package app.appUserDemo.service;

import app.appUserDemo.model.AppUser;
import app.appUserDemo.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AppUserService {

    AppUserRepository appUserRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public AppUserService(AppUserRepository appUserRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.appUserRepository = appUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public AppUser createAppUser(AppUser appUser) {
        appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));
        appUserRepository.save(appUser);
        return appUser;
    }

    public void deleteAppUser(long id) {
        appUserRepository.deleteById(id);
    }
}
