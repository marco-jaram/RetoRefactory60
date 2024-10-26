package common.repository;


import common.model.Order;
import common.model.OrderItem;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.List;

@Slf4j
public class OrderRepository {
    private final Connection connection;

    public OrderRepository() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    public Order save(Order order) {
        String sql = "INSERT INTO orders (order_date, total_amount, status, customer_name, customer_email) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            connection.setAutoCommit(false);

            stmt.setTimestamp(1, Timestamp.valueOf(order.getOrderDate()));
            stmt.setDouble(2, order.getTotalAmount());
            stmt.setString(3, order.getStatus().name());
            stmt.setString(4, order.getCustomerName());
            stmt.setString(5, order.getCustomerEmail());

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    order.setId(rs.getLong(1));
                    saveOrderItems(order.getId(), order.getItems());
                }
            }

            connection.commit();
            return order;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                log.error("Error rolling back transaction", ex);
            }
            log.error("Error saving order", e);
            throw new RuntimeException("Error saving order", e);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                log.error("Error resetting auto-commit", e);
            }
        }
    }

    private void saveOrderItems(Long orderId, List<OrderItem> items) {
        String sql = "INSERT INTO order_items (order_id, product_id, quantity, price_at_purchase) " +
                "VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            for (OrderItem item : items) {
                stmt.setLong(1, orderId);
                stmt.setLong(2, item.getProduct().getId());
                stmt.setInt(3, item.getQuantity());
                stmt.setDouble(4, item.getPriceAtPurchase());
                stmt.addBatch();
            }
            stmt.executeBatch();
        } catch (SQLException e) {
            log.error("Error saving order items", e);
            throw new RuntimeException("Error saving order items", e);
        }
    }

    // Implementar el resto de métodos...
}