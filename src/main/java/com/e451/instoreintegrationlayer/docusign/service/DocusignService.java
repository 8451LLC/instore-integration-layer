package com.e451.instoreintegrationlayer.docusign.service;

import com.e451.instoreintegrationlayer.webhook.dto.EventPayloadDto;
import reactor.core.publisher.Mono;

public interface DocusignService {
    Mono<Void> prepareForSignature(EventPayloadDto eventPayload);
    Mono<Void> sendForSignature(EventPayloadDto eventPayload);
}
