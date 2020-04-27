package kg.company.blogProject.services.impls;

import kg.company.blogProject.entities.Tag;
import kg.company.blogProject.repos.TagRepo;
import kg.company.blogProject.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    TagRepo tagRepo;

    @Override
    public Tag getTagById(Long id) {
        Optional<Tag> tag = tagRepo.findById(id);
        return tag.get();
    }

    @Override
    public List<Tag> getAllTags() {
        return tagRepo.findAll();
    }

    @Override
    public Tag updateTag(Long id, Tag tag) {
        if(tagRepo.findById(id).isPresent()) {
            Tag existingTag = tagRepo.findById(id).get();
            existingTag.setTagText(tag.getTagText());
            existingTag.setPosts(tag.getPosts());
            Tag updatedTag = tagRepo.save(existingTag);
            return updatedTag;
        }
        else return null;
    }

    @Override
    public String deleteTagById(Long id) {
        String result = "deleted " + tagRepo.findById(id);
        tagRepo.deleteById(id);
        return result;
    }

    @Override
    public List<Tag> getTagByTagText(String tagText) {
        return tagRepo.getAllByTagText(tagText);
    }
}
