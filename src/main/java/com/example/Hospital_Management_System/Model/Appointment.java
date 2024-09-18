package com.example.Hospital_Management_System.Model;

import com.example.Hospital_Management_System.AppointmentId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "Appointment")
@Table(name = "Appointment")
@Getter
@Setter
public class Appointment {

    @EmbeddedId
    private AppointmentId id;

    @ManyToOne
    @MapsId("patientId")
    @JoinColumn(
            name = "patient_id",
            foreignKey = @ForeignKey(
                    name = "appoinment_patient_id_fk"
            )
    )
    private Patient patient;

    @ManyToOne
    @MapsId("doctorId")
    @JoinColumn(
            name = "doctor_id",
            foreignKey = @ForeignKey(
                    name = "appointment_doctor_id_fk"
            )
    )
    private Doctor doctor;

    @Column(
            name = "appointment_date",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime appointmentDate;

    public Appointment(AppointmentId appointmentId, Patient patient, Doctor doctor, LocalDateTime appointmentDate) {
        this.id = appointmentId;
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDate = appointmentDate;

    }

    public Appointment() {
    }
}
