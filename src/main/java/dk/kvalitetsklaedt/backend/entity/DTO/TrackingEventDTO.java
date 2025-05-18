package dk.kvalitetsklaedt.backend.entity.DTO;

import java.util.Map;

public record TrackingEventDTO(
    String sessionId,
    String eventType,
    String timestamp,
    Map<String, Object> eventData
) {
}
