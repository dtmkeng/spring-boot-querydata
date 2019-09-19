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
@Table(name="Patient")
public class Patient {
	@Id
	@SequenceGenerator(name="Patient_seq",sequenceName="Patient_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Patient_seq")
	@Column(name="Patient_ID",unique = true, nullable = true)
	private @NotNull Long id;
    private @NotNull String firstName;
    private @NotNull String lastName;
    private @NotNull int age;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Admission.class)
    @JoinColumn(name = "admissionId", insertable = true)
    @JsonIgnore
    private Admission admission;
}