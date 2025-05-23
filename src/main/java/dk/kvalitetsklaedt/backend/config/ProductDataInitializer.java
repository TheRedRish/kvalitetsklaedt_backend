package dk.kvalitetsklaedt.backend.config;

import dk.kvalitetsklaedt.backend.entity.Enum.ProductSize;
import dk.kvalitetsklaedt.backend.entity.Enum.ProductTag;
import dk.kvalitetsklaedt.backend.entity.Enum.ProductType;
import dk.kvalitetsklaedt.backend.entity.Product;
import dk.kvalitetsklaedt.backend.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProductDataInitializer {

    @Bean
    public CommandLineRunner initProducts(ProductRepository productRepository) {
        return args -> {
            if (productRepository.count() == 0) {
                Product product1 = new Product();
                product1.setProductName("Classic White T-Shirt");
                product1.setProductCostPrice(50);
                product1.setProductSalePrice(100);
                product1.setColor("White");
                product1.setProductMaterial("Cotton");
                product1.setProductSize(ProductSize.M);
                product1.setProductType(ProductType.T_SHIRT);
                product1.setProductTag(List.of(ProductTag.SUMMER, ProductTag.ALL_YEAR));
                product1.setSKU("TSHIRT-WHT-001");

                Product product2 = new Product();
                product2.setProductName("Warm Winter Hoodie");
                product2.setProductCostPrice(150);
                product2.setProductSalePrice(300);
                product2.setColor("Navy Blue");
                product2.setProductMaterial("Fleece");
                product2.setProductSize(ProductSize.Xl); // corrected casing
                product2.setProductType(ProductType.HOODIE);
                product2.setProductTag(List.of(ProductTag.WINTER));
                product2.setSKU("HOODIE-NVY-002");

                Product product3 = new Product();
                product3.setProductName("Formal Skjorte");
                product3.setProductCostPrice(120);
                product3.setProductSalePrice(240);
                product3.setColor("Light Blue");
                product3.setProductMaterial("Linen");
                product3.setProductSize(ProductSize.L);
                product3.setProductType(ProductType.SKJORTE);
                product3.setProductTag(List.of(ProductTag.SPRING, ProductTag.AUTUMN));
                product3.setSKU("SKJORTE-BLU-003");

                productRepository.saveAll(List.of(product1, product2, product3));
                System.out.println("Sample products inserted.");
            } else {
                System.out.println("Products already exist. Skipping initialization.");
            }
        };
    }
}
