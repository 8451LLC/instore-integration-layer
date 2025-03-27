package com.e451.instoreintegrationlayer.webhook.mapper;

import com.e451.instoreintegrationlayer.webhook.dto.EventPayloadDto;
import com.e451.instoreintegrationlayer.workfront.model.WorkfrontTask;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EventMapper {
    WorkfrontTask toWorkfrontTask(EventPayloadDto eventPayloadDto);
}
