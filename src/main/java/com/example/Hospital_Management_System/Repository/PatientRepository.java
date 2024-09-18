package com.example.Hospital_Management_System.Repository;

import com.example.Hospital_Management_System.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
