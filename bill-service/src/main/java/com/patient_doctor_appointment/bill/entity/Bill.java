package com.patient_doctor_appointment.bill.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billId;
    private Long patientId;
    private Long doctorId;
    private Long appointmentId;
//    @Column(nullable = false)
//    private Double doctorFee;
    private LocalDateTime createdAt;
}
