package com.example.demo.repository;
import com.example.demo.entity.Admission;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.data.repository.query.Param;
import java.util.Collection;

@CrossOrigin(origins = "http://localhost:8080")
@RepositoryRestResource
public
interface AdmissionRepository extends JpaRepository<Admission, Long> {
    
    @Query( value = "SELECT * FROM ADMISSION as a INNER JOIN  PATIENT   as  p on a.ADMISSION_ID  = p.ADMISSION_ID where p.FIRST_NAME  = :firstName",
            nativeQuery = true)
    Admission  findPatientByFirstName(@Param("firstName") String firstName);
}