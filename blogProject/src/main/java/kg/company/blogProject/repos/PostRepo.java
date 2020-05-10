package kg.company.blogProject.repos;

import kg.company.blogProject.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post, Long> {
    List<Post> getAllByCategory_Name(String category);
    List<Post> getAllByTitle(String title);
    List<Post> getAllByUserId(Long user_id);
    List<Post> getAllByPublicationTime(Date publicationTime);
    List<Post> getAllByPublicationTimeBetween(Date initPublicationTime, Date finalPublicationTime);
    List<Post> getAllByPublicationTimeGreaterThan(Date initRegistrationDate);
    @Query(value = "SELECT p FROM Post p left join Tag t where t.tagText = :tagText")
    List<Post> getAllByTag(String tagText);
    @Query(value = "SELECT COUNT(p.id) FROM Post p left join User u where u.id = :userId")
    Integer getPostCountByUserId(Long userId);
}
