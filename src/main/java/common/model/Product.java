package common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class Product {
    private Long id;
    private String name;
    private String description;
    private double price;
    private int stock;
    private ProductType type;
}