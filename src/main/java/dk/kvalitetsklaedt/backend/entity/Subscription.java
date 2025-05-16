package dk.kvalitetsklaedt.backend.entity;

import dk.kvalitetsklaedt.backend.entity.Enum.DeliveryInterval;
import dk.kvalitetsklaedt.backend.entity.Enum.ProductType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscription_id")
    private int subscriptionId;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "delivery_interval")
    private DeliveryInterval deliveryInterval;

    @Column(name = "active")
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ElementCollection(targetClass = ProductType.class)
    @Enumerated(EnumType.STRING) //
    @CollectionTable(name = "product_types", joinColumns = @JoinColumn(name = "subscription_id"))
    @Column(name = "product_type")
    private List<ProductType> productType;
}
