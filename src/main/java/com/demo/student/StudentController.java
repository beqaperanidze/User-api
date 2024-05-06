package com.demo.student;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getStudents")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/getStudentById/{id}")
    public Student getStudent(@PathVariable("id") Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping("/registerStudent")
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @PutMapping("/updateStudent/{id}")
    public void updateStudent(@PathVariable("id") Long id,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email) {
        studentService.updateStudent(id, name, email);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public void deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
    }


}
