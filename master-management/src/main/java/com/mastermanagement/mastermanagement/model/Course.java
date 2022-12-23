package com.mastermanagement.mastermanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Course {

    @Id
    @Column(length = 40)
    private String courseId;

    private String name;

    private int period;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_subject",nullable = false)
    private Subject subject;
}
