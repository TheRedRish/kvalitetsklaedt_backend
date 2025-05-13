package dk.kvalitetsklaedt.backend.controller;

import dk.kvalitetsklaedt.backend.entity.DTO.TrackingEventDTO;
import dk.kvalitetsklaedt.backend.entity.TrackingEvent;
import dk.kvalitetsklaedt.backend.mapper.TrackingEventDTOMapper;
import dk.kvalitetsklaedt.backend.repository.TrackingEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tracking")
public class TrackingController {

    private final TrackingEventRepository trackingEventRepository;
    private final TrackingEventDTOMapper mapper;

    public TrackingController(TrackingEventRepository trackingEventRepository, TrackingEventDTOMapper mapper) {
        this.trackingEventRepository = trackingEventRepository;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<Void> trackEvent(@RequestBody TrackingEventDTO event) {
        TrackingEvent trackingEvent = mapper.toEntity(event);

        trackingEventRepository.save(trackingEvent);
        return ResponseEntity.ok().build();
    }
}

