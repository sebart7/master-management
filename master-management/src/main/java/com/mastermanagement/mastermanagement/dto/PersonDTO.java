package com.mastermanagement.mastermanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {

    private Integer idPerson;

    @NotNull(message = "{user.identificationNumber.null}")
    @NotBlank(message = "{user.identificationNumber.empty}")
    private String identificationNumber;

    @NotNull(message = "{user.identificationType.null}")
    @NotBlank(message = "{user.identificationType.empty}")
    private String identificationType;

    @NotNull(message = "{user.name.null}")
    @Size(min = 3, max = 50, message = "{user.name.size}")
    private String name;

    @NotNull(message = "{user.lastName.null}")
    @Size(min = 3, max = 50, message = "{user.lastName.size}")
    private String lastName;
}
