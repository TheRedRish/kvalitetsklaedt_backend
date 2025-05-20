package dk.kvalitetsklaedt.backend.entity.DTO;

import dk.kvalitetsklaedt.backend.entity.Enum.ProductSize;
import dk.kvalitetsklaedt.backend.entity.Enum.TypeOfFeedback;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAndFeedbackDTO {
    private String email;
    private ProductSize productSize;
    private String feedback;
    private TypeOfFeedback typeOfFeedback;
}
