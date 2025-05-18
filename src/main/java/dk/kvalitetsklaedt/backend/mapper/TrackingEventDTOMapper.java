package dk.kvalitetsklaedt.backend.mapper;

import dk.kvalitetsklaedt.backend.entity.DTO.TrackingEventDTO;
import dk.kvalitetsklaedt.backend.entity.TrackingEvent;
import org.springframework.stereotype.Component;

@Component
public class TrackingEventDTOMapper {

    public TrackingEvent toEntity(TrackingEventDTO dto) {
        TrackingEvent entity = new TrackingEvent();
        entity.setSessionId(dto.sessionId());
        entity.setEventType(dto.eventType());
        entity.setTimestamp(dto.timestamp());
        entity.setData(dto.eventData() == null ? null : dto.eventData().toString());
        return entity;
    }
}
