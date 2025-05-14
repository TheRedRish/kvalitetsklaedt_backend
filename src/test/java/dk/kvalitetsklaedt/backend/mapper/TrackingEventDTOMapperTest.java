package dk.kvalitetsklaedt.backend.mapper;

import dk.kvalitetsklaedt.backend.entity.DTO.TrackingEventDTO;
import dk.kvalitetsklaedt.backend.entity.TrackingEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TrackingEventDTOMapperTest {

    private TrackingEventDTOMapper mapper = new TrackingEventDTOMapper();

    @Test
    void toEntity_shouldMapAllFieldsCorrectly() {
        Map<String, Object> data = Map.of("key", "value");
        TrackingEventDTO dto = new TrackingEventDTO("session123", "click", "2025-05-14T10:00:00", data);

        TrackingEvent entity = mapper.toEntity(dto);

        assertEquals("session123", entity.getSessionId());
        assertEquals("click", entity.getEventType());
        assertEquals("2025-05-14T10:00:00", entity.getTimestamp());
        assertEquals("{key=value}", entity.getData());
    }

    @Test
    void toEntity_shouldHandleNullData() {
        TrackingEventDTO dto = new TrackingEventDTO("session123", "view", "2025-05-14T10:05:00", null);

        TrackingEvent entity = mapper.toEntity(dto);

        assertEquals("session123", entity.getSessionId());
        assertEquals("view", entity.getEventType());
        assertEquals("2025-05-14T10:05:00", entity.getTimestamp());
        assertNull(entity.getData());
    }
}