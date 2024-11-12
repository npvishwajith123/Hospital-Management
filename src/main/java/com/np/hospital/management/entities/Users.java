package com.np.hospital.management.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String userName;
    private String password;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="roleId")
    private Roles role;
    private Integer associateDoctorId;
    private Integer associatePatientId;

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", associateDoctorId=" + associateDoctorId +
                ", associatePatientId=" + associatePatientId +
                '}';
    }
}
