package com.mastermanagement.mastermanagement.service;

import com.mastermanagement.mastermanagement.dto.TeacherDTO;

import java.util.List;

public interface ITeacherService {

    TeacherDTO save(TeacherDTO teacherDTO);

    List<TeacherDTO> findAll();


}
