package kg.tune.StudProject.controller;

import kg.tune.StudProject.entity.Course;
import kg.tune.StudProject.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @GetMapping
    public List<Course> getAll() {
        return courseService.getAll();
    }

    @GetMapping("/{id}")
    public Course getById(@PathVariable("id") Long id) {
        return courseService.getById(id);
    }

    @PostMapping("/add")
    public Course save(@RequestBody Course course) {
        return courseService.save(course);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable("id") Long id) {
        courseService.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
