package com.mastermanagement.mastermanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {

    @NotBlank(message = "{standard.string.constrain}")
    private String courseId;

    @Size(min = 5, max = 25, message = "{course.name.size}")
    private String name;

    @Range(min = 1, max = 2, message = "{course.constrain}")
    private int period;

    private SubjectDTO subject;
}
