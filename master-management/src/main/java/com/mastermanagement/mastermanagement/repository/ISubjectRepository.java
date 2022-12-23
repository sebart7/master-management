package com.mastermanagement.mastermanagement.repository;

import com.mastermanagement.mastermanagement.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ISubjectRepository extends JpaRepository<Subject,Integer> {

    Set<Subject> findAllByNameContainingIgnoreCaseOrderByNameAsc(String name);

}
