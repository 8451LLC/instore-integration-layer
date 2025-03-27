package com.e451.instoreintegrationlayer.webhook.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data
public class DimensionsDto {

    @NotEmpty(message = "At least one division is required")
    private List<@Valid DivisionDto> divisions;

    @NotEmpty(message = "at least one upc is required")
    private List<@Valid FeaturedUpcDto> featuredUpcs;
}
