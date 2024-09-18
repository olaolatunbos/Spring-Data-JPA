package com.example.Hospital_Management_System.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@Entity(name = "MedicalRecord")
@Table(name = "medicalRecord")
public class MedicalRecord {
    @Id
    @SequenceGenerator(
            name = "medical_record_sequence",
            sequenceName = "medical_record_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "medical_record_sequence"
    )
    private Long id;
    @OneToOne
    @JoinColumn(
            name = "patient_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "patient_id_fk"
            )
    )
    private Patient patient;
    @Column(
            name = "diagnosis",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String diagnosis;
    @Column(
            name = "treatment",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String treatment;

    public MedicalRecord(String diagnosis, String treatment) {
        this.diagnosis = diagnosis;
        this.treatment = treatment;
    }

    public MedicalRecord() {
    }


}
