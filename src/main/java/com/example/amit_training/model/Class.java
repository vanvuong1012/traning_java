package com.example.amit_training.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name ="class")
@Data
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToMany(mappedBy = "classes")
    Set<Student> students;

}
