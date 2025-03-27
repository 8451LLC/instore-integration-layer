package com.e451.instoreintegrationlayer.docusign.service;

import com.e451.instoreintegrationlayer.webhook.dto.EventPayloadDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class DocusignServiceImpl implements DocusignService {
    @Override
    public Mono<Void> prepareForSignature(EventPayloadDto eventPayload) {
        log.info("Preparing DocuSign envelope for campaign {}", eventPayload.getEventId());
        //TODO: Generate documents, create envelope
        return Mono.empty();
    }

    @Override
    public Mono<Void> sendForSignature(EventPayloadDto eventPayload) {
        log.info("Sending DocuSign envelope for campaign {}", eventPayload.getEventId());
        //TODO: Send email for signing
        return Mono.empty();
    }
}
