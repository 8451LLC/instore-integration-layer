package com.e451.instoreintegrationlayer.webhook.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TouchpointDto {

    @NotBlank
    private String id;

    @NotBlank
    private String name;

    @NotBlank
    private String status;

    private String image;
}
