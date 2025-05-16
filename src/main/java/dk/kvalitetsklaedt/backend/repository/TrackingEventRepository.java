package dk.kvalitetsklaedt.backend.repository;

import dk.kvalitetsklaedt.backend.entity.TrackingEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackingEventRepository extends JpaRepository<TrackingEvent, Long> {
}
