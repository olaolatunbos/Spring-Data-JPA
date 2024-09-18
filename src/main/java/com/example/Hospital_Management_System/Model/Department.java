package com.example.Hospital_Management_System.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@Entity(name = "Department")
@Table(
        name = "department"
)
public class Department {
    @Id
    @SequenceGenerator(
            name = "department_sequence",
            sequenceName = "department_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "department_sequence"
    )
    private Long id;
    @Column(
            name = "department_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String departmentName;
    @OneToMany(
            mappedBy = "departmentId",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<Doctor> doctors = new ArrayList<>();

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public Department() {
    }

    public void addDoctor(Doctor doctor) {
        if (!this.doctors.contains(doctor)) {
            this.doctors.add(doctor);
            doctor.setDepartmentId(this);
        }
    }
}
