package dk.kvalitetsklaedt.backend.entity;

import dk.kvalitetsklaedt.backend.entity.Enum.ProductSize;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;

    @Column(unique = true)
    private String email;

    @Column(name = "product_size")
    private ProductSize productSize;
}
