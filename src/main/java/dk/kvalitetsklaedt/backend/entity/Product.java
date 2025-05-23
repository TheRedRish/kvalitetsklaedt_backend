package dk.kvalitetsklaedt.backend.entity;

import dk.kvalitetsklaedt.backend.entity.Enum.ProductSize;
import dk.kvalitetsklaedt.backend.entity.Enum.ProductTag;
import dk.kvalitetsklaedt.backend.entity.Enum.ProductType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_cost_price")
    private int productCostPrice;

    @Column(name = "product_sale_price")
    private int productSalePrice;

    @Column(name = "color")
    private String color;

    @Column(name = "product_material")
    private String productMaterial;

    @Column(name = "product_size")
    private ProductSize productSize;

    @Column(name = "product_type")
    private ProductType productType;

    @ElementCollection(targetClass = ProductTag.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "product_tags", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "product_tag")
    private List<ProductTag> productTag;

    @Column(name = "sku")
    private String SKU;

    @Column(name = "image_url")
    private String imageUrl;
}
