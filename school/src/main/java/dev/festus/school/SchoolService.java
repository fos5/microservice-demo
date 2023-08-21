package dev.festus.school;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {
    private final SchoolRepository repository;

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
}
