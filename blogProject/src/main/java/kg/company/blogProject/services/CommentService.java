package kg.company.blogProject.services;

import kg.company.blogProject.entities.Comment;

import java.util.List;

public interface CommentService {
    Comment getCommentById(Long id);
    List<Comment> getAllComments();
    Comment updateComment(Long id, Comment comment);
    String deleteCommentById(Long id);
    List<Comment> getCommentByCommentText(String commentText);
    List<Comment> getCommentByUserId(Long userId);
    List<Comment> getCommentByPostId(Long postId);
}
