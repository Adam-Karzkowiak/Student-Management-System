package app.service;

import app.model.AppUser;
import app.data.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AppUserService {

    private AppUserRepository appUserRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

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

    public void deleteAppUser(int id) {
        appUserRepository.deleteById(id);
    }

    public boolean callExistsById(long id) {
        return appUserRepository.existsById(id);
    }
}
