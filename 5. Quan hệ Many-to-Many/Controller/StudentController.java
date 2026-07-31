package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    // POST /students → thêm student[cite: 2]
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    // POST /students/{id}/courses/{courseId} → đăng ký khóa học cho student[cite: 2]
    @PostMapping("/{id}/courses/{courseId}")
    public Student enrollCourse(@PathVariable Long id, @PathVariable Long courseId) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        student.getCourses().add(course);
        return studentRepository.save(student);
    }

    // GET /students/{id}/courses → lấy danh sách khóa học của 1 student[cite: 2]
    @GetMapping("/{id}/courses")
    public List<Course> getStudentCourses(@PathVariable Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        return student.getCourses();
    }
}
