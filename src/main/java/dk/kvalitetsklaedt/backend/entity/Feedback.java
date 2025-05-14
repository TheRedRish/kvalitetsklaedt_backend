package dk.kvalitetsklaedt.backend.entity;

import dk.kvalitetsklaedt.backend.entity.Enum.TypeOfFeedback;
import jakarta.persistence.*;
import lombok.*;

import javax.lang.model.element.TypeElement;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedback_id")
    private int feedbackId;

    @Column(name = "type_of_feedback")
    private TypeOfFeedback typeOfFeedback;

    @Column(name = "feedback")
    private String feedback;
}
