package com.e451.instoreintegrationlayer.webhook.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class StoreDto {

    @NotBlank
    private String id;

    @NotBlank
    private String name;
}
