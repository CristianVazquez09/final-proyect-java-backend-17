package com.mycompany.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode (onlyExplicitlyIncluded = true)
@Entity
public class Course {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idCourse;

    @Column (nullable = false, length = 200)
    private String name;

    @Column(nullable = false, length = 50, unique = true)
    private String acronym;

    @Column (nullable = false)
    private boolean enabled;

}
