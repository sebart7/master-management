package com.mastermanagement.mastermanagement.service;

import com.mastermanagement.mastermanagement.dto.SubjectDTO;
import com.mastermanagement.mastermanagement.exception.exceptions.BusinessRuleException;
import com.mastermanagement.mastermanagement.exception.exceptions.EntityExistsException;
import com.mastermanagement.mastermanagement.model.Subject;
import com.mastermanagement.mastermanagement.repository.ISubjectRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements ISubjectService {

    @Autowired
    private ISubjectRepository subjectRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public SubjectDTO saveSubject(SubjectDTO subject) {
        if(subject.getSubjectId() != null)
            if(this.subjectRepository.existsById(subject.getSubjectId()))
                throw new EntityExistsException("Subject with id " + subject.getSubjectId() + " already exists");

        if (subject.getTeachers().size() < 2 || subject.getCourses().isEmpty())
            throw new BusinessRuleException("Subject must be associated with one course and 2 teachers");

        Subject requestSubject = this.modelMapper.map(subject, Subject.class);
        requestSubject.getCourses().forEach(course -> {
            course.setSubject(requestSubject);
        });

        Subject savedSubject = this.subjectRepository.save(requestSubject);
        return this.modelMapper.map(savedSubject, SubjectDTO.class);
    }

    @Override
    public List<SubjectDTO> findAllSubject() {
        Iterable<Subject> subjects = this.subjectRepository.findAll();
        List<SubjectDTO> subjectsDTO = this.modelMapper.map(subjects, new TypeToken<List<SubjectDTO>>() {
        }.getType());

        return subjectsDTO;
    }

    @Override
    public Optional<SubjectDTO> getSubjectById(int subjectId) {
        if (this.subjectRepository.existsById(subjectId)){
            return Optional.of(this.modelMapper.map(this.subjectRepository.findById(subjectId).get(), SubjectDTO.class));
        }

        return Optional.empty();
    }

}
