package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.repository.*;
import com.example.demo.entity.*;
// import com.example.demo.model.*;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class PatientController {

    @Autowired
    private final PatientRepository  patientRepository;

    @Autowired
    private final AdmissionRepository  admissionRepository;


    public PatientController(PatientRepository  patientRepository, AdmissionRepository  admissionRepository) {
            this.patientRepository = patientRepository;
            this.admissionRepository = admissionRepository;
    }
    @GetMapping("/patient/firstname/{firstName}")
    public Collection<Patient> getPatientByFirstName(@PathVariable("firstName") String firstName) {
        return patientRepository.findPatientByFirstName(firstName);
    }
    @GetMapping("/admission/patient/{firstName}")
    public Admission getPatient(@PathVariable("firstName") String firstNamePatient) {
        return admissionRepository.findPatientByFirstName(firstNamePatient);
    }

}
// SELECT * FROM ADMISSION a where a.ID in (SELECT *  FROM PATIENT p where p.first_name ="Tanjiro") ;
// SELECT * FROM ADMISSION a where a.ADMISSION_ID in (SELECT *  FROM PATIENT p where p.first_name = 'Tanjiro')