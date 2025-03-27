package com.e451.instoreintegrationlayer.datafabric.service;

import com.e451.instoreintegrationlayer.webhook.dto.EventPayloadDto;
import reactor.core.publisher.Mono;

public interface DataFabricService {
    Mono<Void> syncCampaign(EventPayloadDto eventPayload);
}
