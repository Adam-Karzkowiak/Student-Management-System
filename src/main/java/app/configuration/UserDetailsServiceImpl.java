package app.configuration;

import app.data.ProfessorRepository;
import app.data.StudentRepository;
import app.model.Professor;
import app.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        for (Professor obj : ProfessorRepository.professorDatabase) {
            if (obj.getLogin().equals(username)) {
                return new User(obj.getLogin(), obj.getPassword(), Collections.emptyList());
            }
        }
        for (Student obj : StudentRepository.studentDatabase) {
            if (obj.getLogin().equals(username)) {
                return new User(obj.getLogin(), obj.getPassword(), Collections.emptyList());
            }
        }
        throw new UsernameNotFoundException(username);
    }
}
