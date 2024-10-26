package common.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderItem {
    private Long id;
    private Long orderId;
    private Product product;
    private int quantity;
    private double priceAtPurchase;
}