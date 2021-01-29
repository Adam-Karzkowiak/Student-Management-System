package app.data;

import app.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SqlSubjectRepository extends JpaRepository<Subject, Integer> {
}
