package com.example.Hospital_Management_System;

import com.example.Hospital_Management_System.Model.*;
import com.example.Hospital_Management_System.Repository.DoctorRepository;
import com.example.Hospital_Management_System.Repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class HospitalManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalManagementSystemApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(PatientRepository patientRepository, DoctorRepository doctorRepository) {
		return args -> {
			Patient patient = new Patient(
					"Ola",
					"Olatunbosun",
					"MALE",
					"olaolat@hotmail.com",
					LocalDateTime.now()

			);
			MedicalRecord medicalRecord = new MedicalRecord("Cancer", "Radiotheraphy"
			);
			patient.setMedicalRecord(medicalRecord);
			medicalRecord.setPatient(patient);


			Department oncology = new Department("Oncology");
			Doctor doctor1 = new Doctor(
					"John", "Smith", "Oncology", "MALE", LocalDateTime.now()
			);
			doctor1.setDepartmentId(oncology);
			doctorRepository.save(doctor1);
			patient.addAppointment(new Appointment(
					new AppointmentId(1L, 1L),patient, doctor1, LocalDateTime.now()
			));
			oncology.addDoctor(doctor1);

			patientRepository.save(patient);

		};
	}

}
