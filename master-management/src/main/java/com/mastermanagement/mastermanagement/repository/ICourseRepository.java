package com.mastermanagement.mastermanagement.repository;

import com.mastermanagement.mastermanagement.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseRepository extends JpaRepository<Course,String> {
}
