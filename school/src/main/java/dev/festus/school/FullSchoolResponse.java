package dev.festus.school;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.List;

@Builder @AllArgsConstructor
@NoArgsConstructor @Getter @Setter
public class FullSchoolResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String email;
    private List<Student> students;
}
