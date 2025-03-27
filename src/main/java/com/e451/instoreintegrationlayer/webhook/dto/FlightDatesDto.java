package com.e451.instoreintegrationlayer.webhook.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.Instant;

@Data
public class FlightDatesDto {

    @NotNull(message = "Start date is required")
    private Instant startDate;
    private Instant endDate;
}
