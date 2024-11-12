package com.np.hospital.management.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class HospitalDatabase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hospitalId;
    private String hospitalName;
    private String location;
    private int numberOfDepartments;
    private String contactInfo;

    @Override
    public String toString() {
        return "HospitalDatabase{" +
                "hospitalId=" + hospitalId +
                ", hospitalName='" + hospitalName + '\'' +
                ", location='" + location + '\'' +
                ", numberOfDepartments=" + numberOfDepartments +
                ", contactInfo='" + contactInfo + '\'' +
                '}';
    }
}
