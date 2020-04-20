package kg.tune.AppStudent.controller;

import kg.tune.AppStudent.entity.Student;
import kg.tune.AppStudent.service.StudentService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public Student create(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @GetMapping
    public List<Student> getAll() {
        return studentService.getAllStudent();
    }

    @GetMapping("/{id}")
    public Student get(@PathVariable("id") Long id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/modify/{id}")
    public Student update(@PathVariable("id") Long id, Student student) {
        return studentService.updateStudentById(id, student);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id) {
        studentService.deleteStudentById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping("/byName/{name}")
    public List<Student> getByName(@PathVariable("name") String name) {
        return studentService.getStudentByName(name);
    }
}
