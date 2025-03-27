package com.e451.instoreintegrationlayer.webhook.service;

import com.e451.instoreintegrationlayer.datafabric.service.DataFabricService;
import com.e451.instoreintegrationlayer.docusign.service.DocusignService;
import com.e451.instoreintegrationlayer.webhook.dto.EventPayloadDto;
import com.e451.instoreintegrationlayer.workfront.service.WorkfrontService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class WebhookServiceImpl implements WebhookService {

    private final WorkfrontService workfrontService;
    private final DocusignService docusignService;
    private final DataFabricService datafabricService;

    @Override
    public Mono<Void> handleEvent(EventPayloadDto payload) {
        return switch (payload.getType()) {
            case CAMPAIGN_CREATED -> Mono.when(
                    workfrontService.createTask(payload),
                    datafabricService.syncCampaign(payload)
            );
            case CAMPAIGN_UPDATED -> Mono.when(
                    workfrontService.updateTask(payload),
                    datafabricService.syncCampaign(payload)
            );
            case CAMPAIGN_SUBMITTED -> Mono.when(
                    docusignService.prepareForSignature(payload)
            );
            case CAMPAIGN_APPROVED -> Mono.when(
                    docusignService.sendForSignature(payload),
                    workfrontService.updateTask(payload)
            );
        };
    }
}
