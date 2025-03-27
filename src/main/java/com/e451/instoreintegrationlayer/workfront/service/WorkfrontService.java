package com.e451.instoreintegrationlayer.workfront.service;

import com.e451.instoreintegrationlayer.webhook.dto.EventPayloadDto;
import reactor.core.publisher.Mono;

public interface WorkfrontService {
    Mono<Void> createTask(EventPayloadDto eventPayload);

    Mono<Void> updateTask(EventPayloadDto eventPayload);
}
