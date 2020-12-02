package app.configuration;

import app.data.ProfessorRepository;
import app.data.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    StudentRepository studentRepository;
    ProfessorRepository professorRepository;

    @Override
    public UserDetails loadUserByUsername(String pesel) throws UsernameNotFoundException {
        User user = professorRepository.returnProfessor(pesel); //metoda retrieve student/professor w repozytoriach
    }
}
