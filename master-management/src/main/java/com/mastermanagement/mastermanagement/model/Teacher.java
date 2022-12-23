package com.mastermanagement.mastermanagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Teacher extends Person{

    @Column(length = 50, nullable = false)
    private String university;

    @Column(length = 50, nullable = false)
    private String teacherType;

    @Column(length = 50, nullable = false)
    private float salary;

    @ManyToMany(mappedBy = "teachers", fetch = FetchType.LAZY)
    private Set<Subject> subjects;
}
