package com.mastermanagement.mastermanagement.service;

import com.mastermanagement.mastermanagement.dto.CourseDTO;

import java.util.List;
import java.util.Optional;

public interface ICourseService {

    CourseDTO saveCourse(CourseDTO course);

    List<CourseDTO> findAllCourse();

    Optional<CourseDTO> getCourseById(String courseId);

    boolean deleteCourse(String courseId);

}
