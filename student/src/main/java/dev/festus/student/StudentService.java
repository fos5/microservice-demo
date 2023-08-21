package dev.festus.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository repository;

    public Student getStudentById(Integer id) {
       return repository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Could not find student with id :"));
    }

    public List<Student> getAllStudents(){
        return repository.findAll();
    }
    public Student saveStudent(Student student){
        return repository.save(student);
    }
}
