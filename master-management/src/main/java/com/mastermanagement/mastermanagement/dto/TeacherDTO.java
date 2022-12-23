package com.mastermanagement.mastermanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class TeacherDTO extends PersonDTO{

    @NotBlank(message = "{standard.string.constrain}")
    private String university;

    @NotBlank(message = "{standard.string.constrain}")
    private String teacherType;

    @Positive(message = "{teacher.salary.min}")
    private float salary;
}
