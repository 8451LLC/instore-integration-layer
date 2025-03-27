package com.e451.instoreintegrationlayer.webhook.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data
public class FeaturedUpcDto {

    @NotBlank
    private String id;

    @NotBlank
    private String name;

    @NotEmpty
    private List<@Valid TaxonomyDto> taxonomies;
}
