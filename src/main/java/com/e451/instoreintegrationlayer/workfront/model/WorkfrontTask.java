package com.e451.instoreintegrationlayer.workfront.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WorkfrontTask {
    private String campaignId;
    private String title;
    private String description;
}
