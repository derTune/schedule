package kg.company.blogProject.repos;

import kg.company.blogProject.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepo extends JpaRepository<Rating, Long> {
    List<Rating> findAllByValue(Integer value);
    List<Rating> findAllByUser_Id(Long id);
    List<Rating> findAllByPost_Id(Long id);
}
