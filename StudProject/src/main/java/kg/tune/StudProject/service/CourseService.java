package kg.tune.StudProject.service;

import kg.tune.StudProject.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAll();
    Course getById(Long id);
    String deleteById(Long id);
    Course updateById(Long id);
    Course save(Course course);
}
