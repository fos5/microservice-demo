package dev.festus.school;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/school")
@RequiredArgsConstructor
public class SchoolController {
    private final SchoolService schoolService;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<School>> getAllSchool(){
        return ResponseEntity.ok(schoolService.getAllSchools());
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public School getSchoolById(@PathVariable int id){
        return schoolService.getSchoolById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public School saveSchool(@RequestBody School school){
        return schoolService.saveSchool(school);
    }

}
