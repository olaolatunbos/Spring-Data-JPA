package com.example.Hospital_Management_System;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AppointmentId implements Serializable {

    @Column(name = "patient_id")
    private Long patientId;

    @Column(name = "doctor_id")
    private Long doctorId;

    public AppointmentId(Long patientId, Long doctorId) {
        this.patientId = patientId;
        this.doctorId = doctorId;
    }

    public AppointmentId() {
    }

    public Long getStudentId() {
        return patientId;
    }

    public void setStudentId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getCourseId() {
        return doctorId;
    }

    public void setCourseId(Long doctorId) {
        this.doctorId = doctorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppointmentId that = (AppointmentId) o;
        return Objects.equals(patientId, that.patientId) && Objects.equals(doctorId, that.doctorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientId, doctorId);
    }
}
