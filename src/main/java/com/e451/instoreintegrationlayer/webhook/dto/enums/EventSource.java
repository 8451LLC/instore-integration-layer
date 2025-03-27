package com.e451.instoreintegrationlayer.webhook.dto.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum EventSource {
    BARROWS("barrows")
    ;

    private final String value;

    EventSource(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static EventSource fromValue(String value) {
        for (EventSource eventType : EventSource.values()) {
            if (eventType.value.equals(value)) {
                return eventType;
            }
        }
        throw new IllegalArgumentException("Unknown event type: " + value);
    }
}
