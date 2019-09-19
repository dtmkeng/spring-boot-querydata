package com.example.demo.repository;
import com.example.demo.entity.Patient;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.data.repository.query.Param;
import java.util.Collection;
@CrossOrigin(origins = "http://localhost:8080")
@RepositoryRestResource
public
interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query( value = "SELECT * FROM Patient p where p.first_Name = :firstName",
            nativeQuery = true)
    Collection<Patient> findPatientByFirstName(@Param("firstName") String firstName);
}