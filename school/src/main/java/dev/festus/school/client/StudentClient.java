package dev.festus.school.client;

import dev.festus.school.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
@FeignClient(
        name = "student-service",
        url = "http://localhost:8090/api/v1/students"
        // "${spring.application.config.students.url}"
            )
public interface StudentClient {
    @GetMapping("/school/{school-id}")
    List<Student> findAllStudentsBySchool(@PathVariable("school-id") int schoolId);
}


