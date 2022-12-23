package com.mastermanagement.mastermanagement.service;

import com.mastermanagement.mastermanagement.dto.CourseDTO;
import com.mastermanagement.mastermanagement.exception.exceptions.EntityExistsException;
import com.mastermanagement.mastermanagement.exception.exceptions.EntityNotExistsException;
import com.mastermanagement.mastermanagement.model.Course;
import com.mastermanagement.mastermanagement.repository.ICourseRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private ICourseRepository courseRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CourseDTO saveCourse(CourseDTO course) {

        if(this.courseRepository.existsById(course.getCourseId()))
            throw new EntityExistsException("Course with id " + course.getCourseId() + "already exists");

        Course courseEntity = this.modelMapper.map(course,Course.class);

        Course newCourse = this.courseRepository.save(courseEntity);

        return this.modelMapper.map(newCourse,CourseDTO.class);
    }

    @Override
    public List<CourseDTO> findAllCourse() {
        Iterable<Course> courses = this.courseRepository.findAll();
        List<CourseDTO> coursesDTO = this.modelMapper.map(courses, new TypeToken<List<CourseDTO>>() {
        }.getType());

        return coursesDTO;
    }

    @Override
    public Optional<CourseDTO> getCourseById(String courseId) {
        if (this.courseRepository.existsById(courseId)){
            return Optional.of(this.modelMapper.map(this.courseRepository.findById(courseId).get(),CourseDTO.class));
        }

        return Optional.empty();
    }


    @Override
    public boolean deleteCourse(String courseId) {
        if(!courseRepository.existsById(courseId))
            throw new EntityNotExistsException("Course with id " + courseId + " does not exists");
        courseRepository.deleteById(courseId);

        return !courseRepository.existsById(courseId);
    }
}
