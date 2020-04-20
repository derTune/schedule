package kg.tune.AppStudent.service.impls;

import kg.tune.AppStudent.entity.Student;
import kg.tune.AppStudent.repository.StudentRepo;
import kg.tune.AppStudent.service.StudentService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepo studentRepo;

    @Override
    public Student addStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepo.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        Optional<Student> student = studentRepo.findById(id);
        return student.get();
    }

    @Override
    public Student updateStudentById(Long id, Student student) {
        if(studentRepo.findById(id).isPresent()) {
            Student existingStudent = studentRepo.findById(id).get();
            existingStudent.setFullname(student.getFullname());
            existingStudent.setInn(student.getInn());
            existingStudent.setMobilePhone(student.getMobilePhone());
            Student updatedStudent = studentRepo.save(existingStudent);
            return updatedStudent;
        }
        else return null;
    }

    @Override
    public String deleteStudentById(Long id) {
        String result = "deleted " + studentRepo.findById(id);
        studentRepo.deleteById(id);
        return result;
    }

    @Override
    public List<Student> getStudentByName(String name) {
        return studentRepo.findByName(name);
    }
}
