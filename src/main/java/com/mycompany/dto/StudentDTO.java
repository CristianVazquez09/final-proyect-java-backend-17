package com.mycompany.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentDTO {

    private Integer idStudent;

    @NotNull @NotEmpty
    @Length (min = 3 , max = 50)
    private String nameStudent;

    @NotNull @NotEmpty
    @Length (min = 3 , max = 70)
    private String lastNameStudent;

    @NotNull
    @Min(value = 16)
    private Integer ageStudent;

    @NotNull
    @Length(min = 9, max = 9)
    private String dniStudent;

    public StudentDTO(String nameStudent, Integer ageStudent) {
        this.nameStudent = nameStudent;
        this.ageStudent = ageStudent;
    }
}
