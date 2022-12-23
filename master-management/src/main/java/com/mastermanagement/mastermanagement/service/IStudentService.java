package com.mastermanagement.mastermanagement.service;

import com.mastermanagement.mastermanagement.dto.StudentDTO;

import java.util.List;

public interface IStudentService {

    StudentDTO saveStudent(StudentDTO save);

    List<StudentDTO> findAllStudent();

    StudentDTO getStudentById(Integer code);

    StudentDTO updateStudent(Integer code, StudentDTO update);

    Boolean deleteStudent(Integer code);

    List<StudentDTO> findByNameOrLastNameOrEmail(String name, String lastName, String email);

}
