package com.mastermanagement.mastermanagement.service;

import com.mastermanagement.mastermanagement.dto.SubjectDTO;

import java.util.List;
import java.util.Optional;

public interface ISubjectService {

    SubjectDTO saveSubject(SubjectDTO subject);

    List<SubjectDTO> findAllSubject();

    Optional<SubjectDTO> getSubjectById(int subjectId);


}
