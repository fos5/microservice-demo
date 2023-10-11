package dev.festus.school;

import dev.festus.school.client.StudentClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {
    private final SchoolRepository repository;
    private final StudentClient client;
    public School getSchoolById(Integer id) {
       return repository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Could not find school with id :"));
    }

    public List<School> getAllSchools(){
        return repository.findAll();
    }
    public School saveSchool(School School){
        return repository.save(School);
    }

    public FullSchoolResponse getAllSchoolsWithStudents(int schoolId) {
        School school = repository
                .findById(schoolId)
                .orElseThrow(
                        () -> new RuntimeException("Could not find school with id :")
                );
        List<Student> students = client.findAllStudentsBySchool(schoolId);
        return FullSchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();

    }
}
