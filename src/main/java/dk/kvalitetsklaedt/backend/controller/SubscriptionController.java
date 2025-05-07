package dk.kvalitetsklaedt.backend.controller;

import dk.kvalitetsklaedt.backend.entity.Subscription;
import dk.kvalitetsklaedt.backend.repository.SubscriptionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subscriptions")
@CrossOrigin // allow frontend dev from localhost
public class SubscriptionController {

    private final SubscriptionRepository repo;

    public SubscriptionController(SubscriptionRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Subscription s) {
        return ResponseEntity.ok(repo.save(s));
    }
}
