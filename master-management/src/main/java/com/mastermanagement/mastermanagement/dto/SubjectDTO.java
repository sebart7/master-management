package com.mastermanagement.mastermanagement.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDTO {
    private Integer subjectId;

    @Size(min = 5, max = 25, message = "{subject.name.size}")
    private String name;

    @JsonBackReference
    private Set<CourseDTO> courses;

    private Set<TeacherDTO> teachers;
}
