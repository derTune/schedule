package kg.tune.StudProject.repo;

import kg.tune.StudProject.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, Long> {
}
