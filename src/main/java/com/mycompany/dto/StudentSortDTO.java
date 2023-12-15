package com.mycompany.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
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
public class StudentSortDTO {

    private Integer idStudent;

    @NotNull @NotEmpty
    @Length (min = 3 , max = 50)
    private String nameStudent;

    @NotNull
    @Min(value = 16)
    private Integer ageStudent;


}
