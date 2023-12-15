package com.mycompany.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnrollmentDTO {

    private Integer idEnrollment;


    @NotNull
    private LocalDateTime enrollmentDate;

    @NotNull
    private StudentDTO student;


    @NotNull
    private boolean enabled;

    @JsonManagedReference
    @NotNull
    private List<EnrollmentDetailDTO> details;
}
