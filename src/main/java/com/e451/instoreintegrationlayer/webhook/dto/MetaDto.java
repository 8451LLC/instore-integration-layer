package com.e451.instoreintegrationlayer.webhook.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.Instant;

@Data
public class MetaDto {

    @NotNull
    private Instant createdAt;

    @NotBlank
    private String createdBy;

    @NotNull
    private Instant updatedAt;

    @NotBlank
    private String updatedBy;
}
