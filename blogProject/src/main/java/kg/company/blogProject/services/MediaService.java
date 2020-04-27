package kg.company.blogProject.services;

import kg.company.blogProject.entities.Media;
import kg.company.blogProject.enums.MediaType;

import java.util.List;

public interface MediaService {
    Media getMediaById(Long id);
    List<Media> getAllMedia();
    Media updateMedia(Long id, Media media);
    String deleteMediaById(Long id);
    List<Media> getMediaByType(MediaType type);
    List<Media> getMediaByPostId(Long postId);
}
