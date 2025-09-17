package com.java360.pmanager.infrastructure.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Data
public class SaveProjectDataDTO {

    //No pom deve acrescentar o spring-boot-starter-validation para ter acesso as anotações abaixo
    //Validam campos antes de enviá-los ao BD
    @NotNull(message = "Name cannot be empty")
    @Size(min = 1, max = 80)
    private final String name;

    @NotNull(message = "Description cannot be empty")
    @Size(min = 1, max = 150)
    private final String description;

    @NotNull(message = "inicialDate cannot be empty")
    private final LocalDate inicialDate;

    @NotNull
    private final LocalDate finalDate;

    private final String status;

    @AssertTrue(message = "Dates are not consistent")
    @SuppressWarnings("unused")
    private boolean isInitialDateBeforeFinalDate(){

        return inicialDate.isBefore(finalDate);
    }

}
