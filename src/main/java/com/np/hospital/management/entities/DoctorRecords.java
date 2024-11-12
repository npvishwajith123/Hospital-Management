package com.np.hospital.management.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorRecords {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int doctorId;
    private String name;
    private String specialization;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="departmentId")
    private DoctorDepartment department;
    private int yearsOfExperience;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "treatingDoctor",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<PatientRecords> patientsList;

    @Override
    public String toString() {
        return "DoctorRecords{" +
                "doctorId=" + doctorId +
                ", name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", department=" + department +
                ", yearsOfExperience=" + yearsOfExperience +
                '}';
    }
}
