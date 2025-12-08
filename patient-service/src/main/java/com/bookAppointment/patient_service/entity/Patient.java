package com.bookAppointment.patient_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;

    @Column(nullable = false)
    private String patientName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender patientGender;

    @Column(nullable = false)
    private String patientDisease;

    @Column(nullable = false,unique = true,length = 10)
    private String contactNumber;


}
