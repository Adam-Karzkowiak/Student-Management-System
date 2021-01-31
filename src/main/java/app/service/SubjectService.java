package app.service;

import app.data.AppUserRepository;
import app.data.SubjectRepository;
import app.model.AppUser;
import app.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;
    private AppUserRepository appUserRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository, AppUserRepository appUserRepository) {
        this.subjectRepository = subjectRepository;
        this.appUserRepository = appUserRepository;
    }

    public Subject createSubject(String subjectName) {
        HashMap<AppUser, ArrayList<Integer>> grades = new HashMap<>();
        Subject subject = new Subject(subjectName, grades);
        addToSubjectDatabase(subject);
        return subject;
    }

    public List<Subject> removeSubject(int id) {
        subjectRepository.deleteById(id);
        return subjectRepository.findAll();
    }

    public List<Subject> addSubject(Subject subject) {
        subjectRepository.save(subject);
        return subjectRepository.findAll();
    }

    public List<String> showSubjectList() {
        List<String> subNames = new ArrayList<>();
        for (Subject o : subjectRepository.subjectDatabaseDemo) {
            subNames.add(o.getSubjectName());
        }
        return subNames;
    }

    public void registerToSubject(int id, String subjectName) {
        Subject subject = getSubject(subjectName);
        AppUser student = getStudent(id);
        subjectRepository.addStudentToSubject(subject, student);
    }

    public AppUser getStudent(int id) {
        return appUserRepository.getOne(id);
    }

    public Subject getSubject(String subjectName) {
        for (Subject obj : subjectRepository.subjectDatabaseDemo) {
            if (obj.getSubjectName().equalsIgnoreCase(subjectName)) {
                return obj;
            }
        }
        return null;
    }

    public Set<AppUser> showRegisteredToSubject(String subjectName) {
        for (Subject obj : subjectRepository.subjectDatabaseDemo) {
            if (obj.getSubjectName().equalsIgnoreCase(subjectName)) {
                return obj.grades.keySet();
            }
        }
        return null;
    }

    public void showAllStudentGrades(int id) {
        AppUser student = getStudent(id);
        for (Subject obj : subjectRepository.subjectDatabaseDemo) {
            if (obj.grades.containsKey(student)) {
                System.out.println(obj.getSubjectName() + " : " + obj.grades.get(student));

            }
        }

    }

    public void giveAGrade(String subjectName, int id, int grade) {
        Subject subject = getSubject(subjectName);
        AppUser appUser = getStudent(id);
        subjectRepository.addAGrade(subject, appUser, grade);
    }

    public double calculateAvgForStudent(String subjectName, int id) {
        Subject subject = getSubject(subjectName);
        AppUser student = getStudent(id);
        ArrayList<Integer> calculatedAvg = subject.grades.get(student);
        return calculatedAvg.stream().mapToInt(a -> a).average().orElse(0.0);


    }

    public Map<String, Double> calculateAverageForWholeClass(String subjectName) {
        Subject subject = getSubject(subjectName);
        Map<String, Double> avgForClass = new HashMap<>();
        for (Map.Entry<AppUser, ArrayList<Integer>> entry : subject.grades.entrySet()) {
            ArrayList<Integer> studentGrades = entry.getValue();
            double average = studentGrades.stream().mapToInt(a -> a).average().orElse(0.0);
            avgForClass.put(entry.getKey().getSurname(), average);
        }
        return avgForClass;
    }

}
