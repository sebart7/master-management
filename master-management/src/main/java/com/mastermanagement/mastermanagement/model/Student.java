package com.mastermanagement.mastermanagement.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Set;

@Entity
public class Student extends Person{

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date entryDate;

    @Column(nullable = false,unique = true)
    private String email;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false, mappedBy = "student")
    private Address address;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "student")
    private Set<Telephone> telephones;
}
