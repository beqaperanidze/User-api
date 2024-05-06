package com.demo.student;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private long id;
    private String name;
    private String email;
    private LocalDate dob;
    @Transient
    private int age;

    public Student(String name, String email, LocalDate dob) {
        this.name=name;
        this.email=email;
        this.dob=dob;
    }

    public Integer getAge(){
        return Period.between(this.dob, LocalDate.now()).getYears();
    }


}
