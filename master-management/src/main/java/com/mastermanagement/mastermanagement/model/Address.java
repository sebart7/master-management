package com.mastermanagement.mastermanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    private Integer idStudent;

    private String ubication;

    @OneToOne
    @MapsId
    @JoinColumn(name = "studentId")
    private Student student;
}
