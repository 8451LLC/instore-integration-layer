package com.e451.instoreintegrationlayer.webhook.dto;

import com.e451.instoreintegrationlayer.webhook.dto.enums.EventSource;
import com.e451.instoreintegrationlayer.webhook.dto.enums.EventType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EventPayloadDto {
    @NotNull(message = "Type is required")
    private EventType type;

    @NotBlank
    // It is barrows_campaign_id. If we expand the event types to user action, event_id can be user_id, etc.,
    private String eventId;


    @NotNull(message = "Source is required")
    private EventSource source;

    @Valid
    @NotNull(message = "Data is required")
    private CampaignDataDto data;

    @Valid
    @NotNull(message = "Meta is required")
    private MetaDto meta;
}
