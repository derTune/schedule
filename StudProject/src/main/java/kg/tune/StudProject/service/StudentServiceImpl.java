package kg.tune.StudProject.service;

import kg.tune.StudProject.entity.Student;
import kg.tune.StudProject.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepo studentRepo;

    @Override
    public List<Student> getAll() {
        return studentRepo.findAll();
    }

    @Override
    public Student getById(Long id) {
        Optional<Student> student = studentRepo.findById(id);
        return student.get();
    }

    @Override
    public Student updateById(Long id) {
        return null;
    }

    @Override
    public String deleteById(Long id) {
        String result = "deleted " + studentRepo.findById(id);
        studentRepo.deleteById(id);
        return result;
    }

    @Override
    public Student save(Student student) {
        return studentRepo.save(student);
    }
}
