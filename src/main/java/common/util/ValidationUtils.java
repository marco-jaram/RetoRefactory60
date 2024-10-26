package common.util;

import common.model.Order;

public class ValidationUtils {
    // Data Clumps - candidato para refactoring
    public static boolean validateProduct(String name, String description, double price, int stock) {
        if (name == null || name.trim().isEmpty()) {
            return false;
        }
        if (description == null || description.trim().isEmpty()) {
            return false;
        }
        if (price <= 0) {
            return false;
        }
        if (stock < 0) {
            return false;
        }
        return true;
    }

    // Large Class y God Class - candidato para refactoring
    public static boolean validateOrder(Order order) {
        if (order == null) {
            return false;
        }
        if (order.getItems() == null || order.getItems().isEmpty()) {
            return false;
        }
        if (order.getCustomerEmail() == null || !order.getCustomerEmail().contains("@")) {
            return false;
        }
        if (order.getTotalAmount() <= 0) {
            return false;
        }
        if (order.getStatus() == null) {
            return false;
        }
        return true;
    }
}
