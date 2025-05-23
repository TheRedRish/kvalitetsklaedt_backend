package dk.kvalitetsklaedt.backend.controller;

import dk.kvalitetsklaedt.backend.entity.Customer;
import dk.kvalitetsklaedt.backend.entity.DTO.CustomerAndFeedbackDTO;
import dk.kvalitetsklaedt.backend.entity.Feedback;
import dk.kvalitetsklaedt.backend.repository.CustomerRepository;
import dk.kvalitetsklaedt.backend.repository.FeedbackRepository;
import dk.kvalitetsklaedt.backend.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static dk.kvalitetsklaedt.backend.entity.Enum.TypeOfFeedback.ACCESSORY_FEEDBACK;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepo;
    @Autowired
    FeedbackRepository feedbackRepo;
    @Autowired
    EmailService emailService;

    @PostMapping("/subscribe-feedback")
    public ResponseEntity<String> createSubscription(@RequestBody CustomerAndFeedbackDTO request) {

        Customer customer = new Customer();
        customer.setEmail(request.getEmail());
        customer.setProductSize(request.getProductSize());
        customerRepo.save(customer);

        Feedback feedback = new Feedback();
        feedback.setFeedback(request.getFeedback());
        feedback.setTypeOfFeedback(request.getTypeOfFeedback());
        feedbackRepo.save(feedback);

        emailService.sendConfirmationEmail(customer.getEmail());

        return ResponseEntity.ok("Tilmelding oprettet");
    }

        @PostMapping("/accessories-feedback")
    public ResponseEntity<String> saveAccessoriesFeedback(@RequestBody Feedback feedback) {
        feedback.setTypeOfFeedback(ACCESSORY_FEEDBACK);
        feedbackRepo.save(feedback);

        return ResponseEntity.ok("Feedback gemt");
    }
}
