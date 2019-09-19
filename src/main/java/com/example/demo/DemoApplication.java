package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;

import com.example.demo.repository.*;
import com.example.demo.entity.*;

import java.util.stream.Stream;
import java.lang.Math; 
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	ApplicationRunner init(PatientRepository patientRepository,AdmissionRepository admissionRepository) {
		int max = 5; 
        int min = 1; 
        int range = max - min + 1; 
		return args -> {
			Stream.of("Inpatient","Intensive Care Unit","Surgical","Pediatrics","Obstretic").forEach(name ->{ 
				Admission adm = new  Admission();
				int floor = (int)(Math.random() * range) + min; 
				adm.setWard(name);
				adm.setFloor(floor);
				admissionRepository.save(adm);
					
			});
			// Tanjiro Kamado
			Patient p1 = new  Patient();
			p1.setFirstName("Tanjiro");
			p1.setLastName("Kamado");
			p1.setAge(13);
			p1.setAdmission(admissionRepository.findById(1L).get());
			patientRepository.save(p1);
			
			// Zenitsu Agatsuma
			Patient p3 = new  Patient();
			p3.setFirstName("Zenitsu");
			p3.setLastName("Agatsuma");
			p3.setAge(16);
			p3.setAdmission(admissionRepository.findById(1L).get());
			patientRepository.save(p3);

			// Inosuke Hashibira
			Patient p4 = new  Patient();
			p4.setFirstName("Inosuke");
			p4.setLastName("Inosuke");
			p4.setAge(15);
			p4.setAdmission(admissionRepository.findById(1L).get());
			patientRepository.save(p4);

			// Kanao Tsuyuri
			Patient p2 = new  Patient();
			p2.setFirstName("Kanao");
			p2.setLastName("Tsuyuri");
			p2.setAge(16);
			patientRepository.save(p2);
		
		};
	}

}
