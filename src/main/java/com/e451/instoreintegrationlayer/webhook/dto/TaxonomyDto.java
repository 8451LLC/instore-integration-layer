package com.e451.instoreintegrationlayer.webhook.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TaxonomyDto {

    @Valid
    @NotNull
    private EntityDto department;

    @Valid
    @NotNull
    private EntityDto commodity;

    @Valid
    @NotNull
    private EntityDto subCommodity;
}
