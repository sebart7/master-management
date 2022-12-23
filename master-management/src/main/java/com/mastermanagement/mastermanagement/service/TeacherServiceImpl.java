package com.mastermanagement.mastermanagement.service;

import com.mastermanagement.mastermanagement.dto.TeacherDTO;
import com.mastermanagement.mastermanagement.exception.exceptions.EntityExistsException;
import com.mastermanagement.mastermanagement.model.Teacher;
import com.mastermanagement.mastermanagement.repository.ITeacherRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements ITeacherService {

    @Autowired
    private ITeacherRepository teacherRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TeacherDTO save(TeacherDTO teacherDTO) {
        if(teacherRepository.findTeacherByIdentificationNumberAndIdentificationType(teacherDTO.getIdentificationType(), teacherDTO.getIdentificationNumber()).isPresent())
            throw new EntityExistsException("Teacher with id " + teacherDTO.getIdentificationNumber() + " already exists");


        Teacher teacherEntity = this.modelMapper.map(teacherDTO,Teacher.class);

        Teacher newTeacher = this.teacherRepository.save(teacherEntity);

        return this.modelMapper.map(newTeacher, TeacherDTO.class);
    }

    @Override
    public List<TeacherDTO> findAll() {
        Iterable<Teacher> students = this.teacherRepository.findAll();
        return this.modelMapper.map(students, new TypeToken<List<TeacherDTO>>() {
        }.getType());
    }

}
