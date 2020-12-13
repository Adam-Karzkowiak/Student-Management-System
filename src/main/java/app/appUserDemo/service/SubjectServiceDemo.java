package app.appUserDemo.service;

import app.appUserDemo.model.AppUser;
import app.appUserDemo.model.SubjectDemo;
import app.appUserDemo.repository.AppUserRepository;
import app.appUserDemo.repository.SubjectRepositoryDemo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class SubjectServiceDemo {
    private SubjectRepositoryDemo subjectRepositoryDemo;
    private AppUserRepository appUserRepository;

    @Autowired
    public SubjectServiceDemo(SubjectRepositoryDemo subjectRepositoryDemo, AppUserRepository appUserRepository) {
        this.subjectRepositoryDemo = subjectRepositoryDemo;
        this.appUserRepository = appUserRepository;
    }

    public SubjectDemo createSubject(String subjectName) {
        HashMap<AppUser, ArrayList<Integer>> grades = new HashMap<>();
        SubjectDemo subject = new SubjectDemo(subjectName, grades);
        addToSubjectDatabase(subject);
        return subject;
    }

    public List<SubjectDemo> removeSubject(String subjectName) {
        subjectRepositoryDemo.deleteSubject(subjectName);
        return subjectRepositoryDemo.subjectDatabaseDemo;
    }

    public List<SubjectDemo> addToSubjectDatabase(SubjectDemo subject) {
        subjectRepositoryDemo.addSubjectToRepository(subject);
        return subjectRepositoryDemo.subjectDatabaseDemo;
    }

    public List<String> showSubjectList() {
        List<String> subNames = new ArrayList<>();
        for (SubjectDemo o : subjectRepositoryDemo.subjectDatabaseDemo) {
            subNames.add(o.getSubjectName());
        }
        return subNames;
    }

    public void registerToSubject(long id, String subjectName) {
        SubjectDemo subject = getSubject(subjectName);
        AppUser student = getStudent(id);
        subjectRepositoryDemo.addStudentToSubject(subject, student);
    }

    public AppUser getStudent(long id) {
        return appUserRepository.getOne(id);
    }

    public SubjectDemo getSubject(String subjectName) {
        for (SubjectDemo obj : subjectRepositoryDemo.subjectDatabaseDemo) {
            if (obj.getSubjectName().equalsIgnoreCase(subjectName)) {
                return obj;
            }
        }
        return null;
    }

    public Set<AppUser> showRegisteredToSubject(String subjectName) {
        for (SubjectDemo obj : subjectRepositoryDemo.subjectDatabaseDemo) {
            if (obj.getSubjectName().equalsIgnoreCase(subjectName)) {
                return obj.grades.keySet();
            }
        }
        return null;
    }

    public void showAllStudentGrades(long id) {
        AppUser student = getStudent(id);
        for (SubjectDemo obj : subjectRepositoryDemo.subjectDatabaseDemo) {
            if (obj.grades.containsKey(student)) {
                System.out.println(obj.getSubjectName() + " : " + obj.grades.get(student));

            }
        }

    }

    public void giveAGrade(String subjectName, long id, int grade) {
        SubjectDemo subjectDemo = getSubject(subjectName);
        AppUser appUser = getStudent(id);
        subjectRepositoryDemo.addAGrade(subjectDemo, appUser, grade);
    }

    public double calculateAvgForStudent(String subjectName, long id) {
        SubjectDemo subject = getSubject(subjectName);
        AppUser student = getStudent(id);
        ArrayList<Integer> calculatedAvg = subject.grades.get(student);
        return calculatedAvg.stream().mapToInt(a -> a).average().orElse(0.0);


    }

    public Map<String, Double> calculateAverageForWholeClass(String subjectName) {
        SubjectDemo subject = getSubject(subjectName);
        Map<String, Double> avgForClass = new HashMap<>();
        for (Map.Entry<AppUser, ArrayList<Integer>> entry : subject.grades.entrySet()) {
            ArrayList<Integer> studentGrades = entry.getValue();
            double average = studentGrades.stream().mapToInt(a -> a).average().orElse(0.0);
            avgForClass.put(entry.getKey().getSurname(), average);
        }
        return avgForClass;
    }

}
