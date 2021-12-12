package com.getarrays.studentmanager.service;

import com.getarrays.studentmanager.exception.UserNotFoundException;
import com.getarrays.studentmanager.model.Student;
import com.getarrays.studentmanager.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Student addStudent(Student student) {
        return studentRepo.save(student);
    }

    public List<Student> findAllStudents() {
        return studentRepo.findAll();
    }

    public Student updateStudent(Student student) {
        return studentRepo.save(student);
    }

    public Student findStudentById(Long id) {
        return studentRepo.findStudentById(id)
                .orElseThrow(() -> new UserNotFoundException("Student by id" + id + " was not found"));
    }

    public void deleteStudent(Long id) {
        studentRepo.deleteStudentById(id);
    }
}
