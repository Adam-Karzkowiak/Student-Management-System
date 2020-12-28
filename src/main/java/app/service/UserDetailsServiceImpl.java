package app.service;

import app.model.AppUser;
import app.data.AppUserRepository;
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
public class UserDetailsServiceImpl implements UserDetailsService {
    AppUserRepository appUserRepository;
    @Value("${spring.security.user.name}")
    private String adminUserName;

    @Value("${spring.security.user.password}")
    private String adminPassword;

    @Value("${spring.security.user.roles}")
    private String adminRole;


    @Autowired
    public UserDetailsServiceImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByUsername(username);
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        if (username.equals("admin")) {
            return User.builder().username(adminUserName).password(adminPassword).roles(adminRole).build();
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



