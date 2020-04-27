package kg.company.blogProject.services;

import kg.company.blogProject.entities.Post;

import java.util.Date;
import java.util.List;

public interface PostService {
    List<Post> getAllPosts();
    Post getPostById(Long id);
    Post updatePost(Long id, Post post);
    String deletePostById(Long id);
    List<Post> getPostByCategoryName(String categoryName);
    List<Post> getPostByTitle(String title);
    List<Post> getPostByUserId(Long userId);
    List<Post> getPostByPublicationTime(Date publicationTime);
    List<Post> getPostByPublicationTimeBetween(Date intiPublicationTime, Date finalPublicationTime);
    List<Post> getPostByPublicationTimeGreaterThan(Date initPublicationTime);
    List<Post> getPostByRatingGrade(Integer ratingGrade);
}
