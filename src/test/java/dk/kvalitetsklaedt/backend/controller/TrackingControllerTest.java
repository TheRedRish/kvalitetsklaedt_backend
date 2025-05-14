package dk.kvalitetsklaedt.backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dk.kvalitetsklaedt.backend.entity.DTO.TrackingEventDTO;
import dk.kvalitetsklaedt.backend.entity.TrackingEvent;
import dk.kvalitetsklaedt.backend.mapper.TrackingEventDTOMapper;
import dk.kvalitetsklaedt.backend.repository.TrackingEventRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TrackingController.class)
class TrackingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private TrackingEventRepository trackingEventRepository;

    @MockitoBean
    private TrackingEventDTOMapper mapper;

    @Test
    void trackEvent_shouldSaveAndReturnOk() throws Exception {
        TrackingEventDTO dto = new TrackingEventDTO("someSessionId", "event", "timestamp", null);
        TrackingEvent entity = new TrackingEvent();

        when(mapper.toEntity(any())).thenReturn(entity);

        mockMvc.perform(post("/api/tracking")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk());

        verify(mapper).toEntity(any());
        verify(trackingEventRepository).save(entity);
    }
}
