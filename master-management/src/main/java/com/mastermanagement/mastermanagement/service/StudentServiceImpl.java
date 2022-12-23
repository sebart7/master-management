package com.mastermanagement.mastermanagement.service;

import com.mastermanagement.mastermanagement.dto.StudentDTO;
import com.mastermanagement.mastermanagement.exception.exceptions.BusinessRuleException;
import com.mastermanagement.mastermanagement.exception.exceptions.EntityExistsException;
import com.mastermanagement.mastermanagement.exception.exceptions.EntityNotExistsException;
import com.mastermanagement.mastermanagement.model.Student;
import com.mastermanagement.mastermanagement.model.Telephone;
import com.mastermanagement.mastermanagement.repository.IStudentRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentRepository studentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public StudentDTO saveStudent(StudentDTO save) {
        if(studentRepository.findStudentByIdentificationNumberAndIdentificationType
                (save.getIdentificationNumber(),save.getIdentificationType()).isPresent()){
            throw new EntityExistsException("Student with id " + save.getIdentificationNumber() + " already exists");
        }

        if(studentRepository.findStudentByEmail(save.getEmail()).isPresent())
            throw new BusinessRuleException("Student with email " + save.getEmail() + " already exists");

        if(save.getAddress() == null || save.getTelephones().size() < 2)
            throw new BusinessRuleException("Student must have one address and minimum two telephones");

        Student toSaveStudent = modelMapper.map(save, Student.class);
        toSaveStudent.getAddress().setStudent(toSaveStudent);
        toSaveStudent.getTelephones().forEach(x->x.setStudent(toSaveStudent));
        Student savedStudent = this.studentRepository.save(toSaveStudent);
        return modelMapper.map(savedStudent, StudentDTO.class);
    }

    @Override
    public List<StudentDTO> findAllStudent() {
        Iterable<Student> students = this.studentRepository.findAll();
        return this.modelMapper.map(students, new TypeToken<List<StudentDTO>>() {
        }.getType());
    }

    @Override
    public StudentDTO getStudentById(Integer code) {
        StudentDTO studentDTO = null;
        if(studentRepository.existsById(code)){
            studentDTO = modelMapper.map(studentRepository.findById(code).get(),StudentDTO.class);
        }
        return studentDTO;
    }

    @Override
    public StudentDTO updateStudent(Integer code, StudentDTO update) {
        if(update.getAddress() == null || update.getTelephones().size() < 2)
            throw new BusinessRuleException("Student must have one address and minimum two telephones");

        StudentDTO studentDTO = null;
        if(this.studentRepository.existsById(code)){
            Student student = this.studentRepository.findById(code).get();
            student = modelMapper.map(update,Student.class);
            student.getAddress().setIdStudent(code);

            for (Telephone t:student.getTelephones()){
                t.setStudent(student);
            }


            studentDTO = modelMapper.map(this.studentRepository.save(student),StudentDTO.class);
        }
        return studentDTO;
    }

    @Override
    public Boolean deleteStudent(Integer code) {
        if(!studentRepository.existsById(code))
            throw new EntityNotExistsException("Student with id " + code + " does not exists");
        studentRepository.deleteById(code);

        return !studentRepository.existsById(code);
    }

    @Override
    public List<StudentDTO> findByNameOrLastNameOrEmail(String name, String lastName, String email) {
        List<Student> students = this.studentRepository.findByNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCase(name, lastName, email);
        return students.stream().map(x -> this.modelMapper.map(x, StudentDTO.class)).collect(Collectors.toList());
    }
}
