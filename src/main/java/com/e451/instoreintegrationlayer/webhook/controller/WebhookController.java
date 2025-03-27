package com.e451.instoreintegrationlayer.webhook.controller;

import com.e451.instoreintegrationlayer.webhook.dto.EventPayloadDto;
import com.e451.instoreintegrationlayer.webhook.service.WebhookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/webhook")
@RequiredArgsConstructor
public class WebhookController {

    private final WebhookService webhookService;

    @PostMapping
    public Mono<Void> receiveEvent(@Valid @RequestBody Mono<EventPayloadDto> payload) {
        return payload.flatMap(webhookService::handleEvent);
    }
}
