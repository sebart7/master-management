package com.mastermanagement.mastermanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class TelephoneDTO {

    private Integer telephoneId;

    @NotBlank(message = "{standard.string.constrain}")
    private String type;

    @Pattern( regexp = "[8][0-9]{5,20}", message = "{telephone.number}")
    private String number;

}
