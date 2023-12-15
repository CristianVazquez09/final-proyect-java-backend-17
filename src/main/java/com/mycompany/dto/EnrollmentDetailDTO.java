package com.mycompany.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnrollmentDetailDTO {


    @JsonBackReference
    @NotNull
    private EnrollmentDTO enrollment;


    @NotNull
    private CourseDTO course;


    @NotNull @NotEmpty
    @Size (min = 6, max = 6)
    private String classroom;
}
