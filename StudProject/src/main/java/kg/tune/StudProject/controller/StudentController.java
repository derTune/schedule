package kg.tune.StudProject.controller;

import kg.tune.StudProject.entity.Student;
import kg.tune.StudProject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public Student getByIf(@PathVariable("id") Long id) {
        return studentService.getById(id);
    }

    @PostMapping("/add")
    public Student save(@RequestBody Student student) {
        return studentService.save(student);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable("id") Long id) {
        studentService.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
