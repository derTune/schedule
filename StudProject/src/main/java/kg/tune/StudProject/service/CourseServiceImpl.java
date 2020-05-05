package kg.tune.StudProject.service;

import kg.tune.StudProject.entity.Course;
import kg.tune.StudProject.repo.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseRepo courseRepo;

    @Override
    public List<Course> getAll() {
        return courseRepo.findAll();
    }

    @Override
    public Course getById(Long id) {
        Optional<Course> course = courseRepo.findById(id);
        return course.get();
    }

    @Override
    public String deleteById(Long id) {
        String result = "deleted " + courseRepo.findById(id);
        courseRepo.deleteById(id);
        return result;
    }

    @Override
    public Course updateById(Long id) {
        return null;
    }

    @Override
    public Course save(Course course) {
        return courseRepo.save(course);
    }
}
