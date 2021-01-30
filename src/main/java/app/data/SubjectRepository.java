package app.data;

import app.model.AppUser;
import app.model.Subject;

import java.util.List;


public interface SubjectRepository {

    Subject save(Subject subject);

    void deleteById(Integer id);

    void addStudentToSubject(Subject subject, AppUser appUser);

    void giveAGrade(Subject subject, AppUser appUser, int grade);

    List<Subject> findAll();


}
