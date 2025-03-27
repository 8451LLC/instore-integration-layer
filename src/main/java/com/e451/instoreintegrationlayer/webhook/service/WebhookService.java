package com.e451.instoreintegrationlayer.webhook.service;

import com.e451.instoreintegrationlayer.webhook.dto.EventPayloadDto;
import reactor.core.publisher.Mono;

public interface WebhookService {
    Mono<Void> handleEvent(EventPayloadDto payload);
}
