package com.VedantCS.spring_data_jpa_practise.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name="tbl_student",
        uniqueConstraints = @UniqueConstraint(
                name="emailid_unique",
                columnNames = "email_address"
        )
)
public class Student {
@Id
@GeneratedValue(
        strategy = GenerationType.IDENTITY
)
    private long StudentId;

    private String firstName;
    private String lastName;

    @Column(name="email_address", nullable=false)
    private String emailId;
    @Embedded
    private Guardian guardian;
}
