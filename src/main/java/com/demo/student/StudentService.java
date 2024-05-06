package com.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        if (studentRepository.findById(id).isEmpty())
            throw new IllegalStateException("Student does not exist");
        else return studentRepository.findById(id).get();
    }

    public void addNewStudent(Student student) {
        if (studentRepository.findByEmail(student.getEmail()).isEmpty()) studentRepository.save(student);
        else throw new IllegalStateException("Student already exists");
    }

    public void deleteStudent(Long id) {
        if (studentRepository.findById(id).isEmpty())
            throw new IllegalStateException("Student does not exist");
        else studentRepository.delete(studentRepository.findById(id).get());
    }

    @Transactional
    public void updateStudent(Long id, String name, String email) {
        if (studentRepository.findById(id).isEmpty())
            throw new IllegalStateException("Student does not exist");
        else {
            Student student = studentRepository.findById(id).get();
            if (name != null && !name.isEmpty()) student.setName(name);
            if (email != null && !email.isEmpty()) student.setEmail(email);
        }
    }
}
