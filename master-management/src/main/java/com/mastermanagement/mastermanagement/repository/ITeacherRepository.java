package com.mastermanagement.mastermanagement.repository;

import com.mastermanagement.mastermanagement.model.Teacher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ITeacherRepository {

    @Query("SELECT t FROM Teacher t WHERE t.identificationType = :identificationType and t.identificationNumber = :identificationNumber")
    Optional<Teacher> findTeacherByIdentificationNumberAndIdentificationType(
            @Param("identificationType") String identificationType,
            @Param("identificationNumber") String identificationNumber);
}
