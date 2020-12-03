package app.configuration;

import app.data.ProfessorRepository;
import app.data.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    StudentRepository studentRepository;
    ProfessorRepository professorRepository;

    @Autowired
    public UserDetailsServiceImpl(StudentRepository studentRepository, ProfessorRepository professorRepository) {
        this.studentRepository = studentRepository;
        this.professorRepository = professorRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String pesel) throws UsernameNotFoundException {
        UserDetails professor = User.; //metoda retrieve student/professor w repozytoriach
    }
}
