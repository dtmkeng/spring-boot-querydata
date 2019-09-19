package com.example.demo.entity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.FetchType;

import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import com.fasterxml.jackson.annotation.*;
@Data
@Entity
@NoArgsConstructor
@Table(name="Admission")
public class Admission {
	@Id
	@SequenceGenerator(name="Admission_seq",sequenceName="Admission_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Admission_seq")
	@Column(name="Admission_ID",unique = true, nullable = true)
	private @NotNull Long id;
    private @NotNull String ward;
    private @NotNull int floor;

    // @OneToMany(fetch = FetchType.EAGER ,mappedBy="admission")
    // @JsonManagedReference
    // private Collection<Patient> patientId;
}