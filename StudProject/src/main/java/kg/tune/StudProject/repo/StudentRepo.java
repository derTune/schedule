package kg.tune.StudProject.repo;

import kg.tune.StudProject.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long> {
}
