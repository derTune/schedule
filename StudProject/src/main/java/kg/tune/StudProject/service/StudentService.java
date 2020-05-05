package kg.tune.StudProject.service;

import kg.tune.StudProject.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAll();
    Student getById(Long id);
    Student updateById(Long id);
    String deleteById(Long id);
    Student save(Student student);
}
