package com.mastermanagement.mastermanagement.repository;

import com.mastermanagement.mastermanagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface IStudentRepository extends JpaRepository<Student,Integer> {

    List<Student> findByNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCase(String name, String lastName, String email);

    @Query("SELECT e From Student e WHERE e.email = :email")
    Optional<Student> findStudentByEmail(@Param("email") String email);


    @Query("SELECT e From Student e WHERE e.identificationNumber = :identificationNumber and e.identificationType = :identificationType")
    Optional<Student> findStudentByIdentificationNumberAndIdentificationType(@Param("identificationNumber") String identificationNumber,
                                                                   @Param("identificationType") String identificationType);


    Set<Student> findAllByIdentificationNumberIn(List<String> identificationNumbers);
}
