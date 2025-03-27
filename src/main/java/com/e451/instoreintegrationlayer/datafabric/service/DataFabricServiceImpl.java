package com.e451.instoreintegrationlayer.datafabric.service;

import com.e451.instoreintegrationlayer.webhook.dto.EventPayloadDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class DataFabricServiceImpl implements DataFabricService {
    @Override
    public Mono<Void> syncCampaign(EventPayloadDto eventPayload) {
        log.info("Syncing Campaign {} to Data Fabric", eventPayload.getEventId());
        //TODO: Call Data Fabric or publish message to stream
        return Mono.empty();
    }
}
