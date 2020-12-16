package app.appUserDemo.service;

import app.appUserDemo.model.AppUser;
import app.appUserDemo.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserDetailsServiceImplDemo implements UserDetailsService {
    AppUserRepository appUserRepository;
    @Value("${spring.security.user.name}")
    private String adminUserName;

    @Value("${spring.security.user.password}")
    private String adminPassword;

    @Value("${spring.security.user.roles}")
    private String adminRole;


    @Autowired
    public UserDetailsServiceImplDemo(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String admin = "admin";
        AppUser appUser = appUserRepository.findByUsername(username);
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        if (appUser.getUsername().equalsIgnoreCase(admin)) {
            authorities.add(new SimpleGrantedAuthority("ADMIN"));
            return new User(admin, admin, authorities);
        }

        if (appUser.isProfessor()) {
            authorities.add(new SimpleGrantedAuthority("PROFESSOR"));
            return new User(appUser.getUsername(), appUser.getPassword(), authorities);
        }
        if (!appUser.isProfessor()) {
            authorities.add(new SimpleGrantedAuthority("STUDENT"));
            return new User(appUser.getUsername(), appUser.getPassword(), authorities);
        }
        throw new UsernameNotFoundException(username);
    }

}



