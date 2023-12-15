package com.mycompany.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class CourseDTO {


    private Integer idCourse;

    @NotNull @NotEmpty
    @Size (min = 3 , max = 100)
    @Pattern(regexp = "^[a-zA-Z ]+$")
    private String nameCourse;

    @NotNull @NotEmpty
    @Size (min = 7 , max = 7)
    @Pattern(regexp = "^[A-Z0-9]+$")
    private String acronymCourse;

    @NotNull
    private boolean enabledCourse;
}
