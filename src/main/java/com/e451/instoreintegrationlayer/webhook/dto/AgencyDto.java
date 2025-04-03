package com.e451.instoreintegrationlayer.webhook.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.UUID;


@Data
public class AgencyDto {

    @NotNull
    @UUID
    private String id;

    @NotNull(message = "Is Agency billed cannot be null")
    private Boolean isBilled;
}
