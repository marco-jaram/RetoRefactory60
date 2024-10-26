package common.util;

import common.model.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProductUtils {
    // Long Method y muchos parámetros - candidato para refactoring
    public static double calculateTotalPrice(int quantity, double price, String customerType,
                                             boolean hasDiscount, double discountPercent,
                                             boolean isHoliday, boolean isMember) {
        double total = quantity * price;
        double discount = 0;

        if (hasDiscount) {
            if (customerType.equals("PREMIUM")) {
                discount = total * 0.20;
            } else if (customerType.equals("REGULAR")) {
                discount = total * 0.10;
            }
            if (isHoliday) {
                discount += total * 0.05;
            }
            if (isMember) {
                discount += total * 0.03;
            }
            discount += total * (discountPercent / 100);
        }

        return total - discount;
    }

    // Método con Switch Statements - candidato para refactoring
    public static String getProductCategory(Product product) {
        switch (product.getType()) {
            case BOOK:
                return ((Book) product).getCategory().toString();
            case BOARD_GAME:
                return ((BoardGame) product).getCategory().toString();
            case EREADER:
                return "ELECTRONIC";
            default:
                return "UNKNOWN";
        }
    }

    // Feature Envy - candidato para refactoring
    public static double calculateOrderTotal(Order order) {
        double total = 0;
        if (order.getItems() != null) {
            for (OrderItem item : order.getItems()) {
                total += item.getPriceAtPurchase() * item.getQuantity();
            }
        }
        return total;
    }

    // Primitive Obsession - candidato para refactoring
    public static String formatProductInfo(String name, double price, int stock, String category) {
        StringBuilder builder = new StringBuilder();
        builder.append("Product: ").append(name).append("\n");
        builder.append("Price: $").append(String.format("%.2f", price)).append("\n");
        builder.append("Stock: ").append(stock).append("\n");
        builder.append("Category: ").append(category);
        return builder.toString();
    }
}
