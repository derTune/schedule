package kg.tune.AppStudent.service;

import kg.tune.AppStudent.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    Student addStudent(Student student);
    List<Student> getAllStudent();
    Student getStudentById(Long id);
    Student updateStudentById(Long id, Student student);
    String deleteStudentById(Long id);
    List<Student> getStudentByName(String name);
}
