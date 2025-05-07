package dk.kvalitetsklaedt.backend.repository;

import dk.kvalitetsklaedt.backend.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
}
