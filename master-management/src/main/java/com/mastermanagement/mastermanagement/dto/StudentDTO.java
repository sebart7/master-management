package com.mastermanagement.mastermanagement.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO extends PersonDTO{

    @PastOrPresent(message = "{user.date.past}")
    private Date entryDate;

    @Email(message = "{email.constrain}")
    private String email;

    @Valid
    private AddressDTO address;

    @Valid
    private Set<TelephoneDTO> telephones;
}
