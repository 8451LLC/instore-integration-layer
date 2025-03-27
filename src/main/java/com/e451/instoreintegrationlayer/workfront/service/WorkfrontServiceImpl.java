package com.e451.instoreintegrationlayer.workfront.service;

import com.e451.instoreintegrationlayer.webhook.dto.EventPayloadDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class WorkfrontServiceImpl implements WorkfrontService {

    @Override
    public Mono<Void> createTask(EventPayloadDto eventPayload) {
        log.info("Creating workfront task for campaign {}", eventPayload.getEventId());
        // TODO: Call Workfront API
        return Mono.empty();
    }

    @Override
    public Mono<Void> updateTask(EventPayloadDto eventPayload) {
        log.info("Updating workfront task for campaign {}", eventPayload.getEventId());
        //TODO: Call Workfront API to update tasks
        return Mono.empty();
    }
}
