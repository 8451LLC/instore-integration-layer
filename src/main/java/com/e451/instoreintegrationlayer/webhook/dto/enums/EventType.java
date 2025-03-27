package com.e451.instoreintegrationlayer.webhook.dto.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum EventType {
    CAMPAIGN_CREATED("campaign.created"),
    CAMPAIGN_UPDATED("campaign.updated"),
    CAMPAIGN_SUBMITTED("campaign.submitted"),
    CAMPAIGN_APPROVED("campaign.approved");

    private final String value;

    EventType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static EventType fromValue(String value) {
        for (EventType eventType : EventType.values()) {
            if (eventType.value.equals(value)) {
                return eventType;
            }
        }
        throw new IllegalArgumentException("Unknown event type: " + value);
    }
}
