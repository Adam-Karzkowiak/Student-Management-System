package app.data;

import app.model.AppUser;
import app.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
interface SqlSubjectRepository extends JpaRepository<Subject, Integer>, SubjectRepository {


    @Override
    void addStudentToSubject(Subject subject, AppUser appUser) {
        if (!subject.grades.containsKey(appUser)) {
            subject.grades.put(appUser, new ArrayList<>());
        }
    }

    public void addAGrade(Subject subject, AppUser appUser, int grade) {
        subject.grades.get(appUser).add(grade);
    }
}
