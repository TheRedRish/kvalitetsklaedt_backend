package dk.kvalitetsklaedt.backend.controller;


import dk.kvalitetsklaedt.backend.entity.Customer;
import dk.kvalitetsklaedt.backend.entity.Feedback;
import dk.kvalitetsklaedt.backend.repository.CustomerRepository;
import dk.kvalitetsklaedt.backend.repository.FeedbackRepository;
import dk.kvalitetsklaedt.backend.service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CustomerRepository customerRepo;

    @MockitoBean
    private FeedbackRepository feedbackRepo;

    @MockitoBean
    private EmailService emailService;

    @Test
    public void testCreateSubscription() throws Exception {
        String jsonRequest = """
                {
                  "email": "kvalitetsklaedt@gmail.com",
                  "productSize": "M",
                  "feedback": "Super produkt!",
                  "typeOfFeedback": "GENERAL_FEEDBACK"
                }
                """;

        mockMvc.perform(post("/api/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isOk())
                .andExpect(content().string("Tilmelding oprettet"));

        verify(customerRepo).save(any(Customer.class));
        verify(feedbackRepo).save(any(Feedback.class));
        verify(emailService).sendConfirmationEmail("kvalitetsklaedt@gmail.com");
    }
}
