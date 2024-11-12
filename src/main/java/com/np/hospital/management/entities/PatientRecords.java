package com.np.hospital.management.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientRecords {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patientId;
    private String name;
    private int age;
    private String address;
    private String diagnosis;
    private Date appointmentDate;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctorId")
    private DoctorRecords treatingDoctor;

    @Override
    public String toString() {
        return "PatientRecords{" +
                "patientId=" + patientId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", diagnosis=" + diagnosis +
                ", address='" + address + '\'' +
                ", appointmentDate=" + appointmentDate +
                ", treatingDoctor=" + treatingDoctor +
                '}';
    }
}
