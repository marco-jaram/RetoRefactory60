package common;

import common.model.*;
import common.repository.BookRepository;
import common.repository.OrderRepository;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;




public class IntegrationTest {

    private final BookRepository bookRepository = new BookRepository();
    private final OrderRepository orderRepository = new OrderRepository();

    @Test
    void testDatabaseIntegration() {
        // Test Book CRUD
        Book newBook = Book.builder()
                .name("Test Book")
                .description("Test Description")
                .price(19.99)
                .stock(10)
                .author("Test Author")
                .isbn("1234567890")
                .publisher("Test Publisher")
                .category(PhilosophyCategory.ETHICS)
                .type(ProductType.BOOK)
                .build();

        // Save Book
        Book savedBook = bookRepository.save(newBook);
        assertNotNull(savedBook.getId());

        // Find Book
        Optional<Book> foundBook = bookRepository.findById(savedBook.getId());
        assertTrue(foundBook.isPresent());
        assertEquals(newBook.getName(), foundBook.get().getName());
        assertEquals(ProductType.BOOK, foundBook.get().getType());

        // Test Order Creation
        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(savedBook);
        orderItem.setQuantity(2);
        orderItem.setPriceAtPurchase(savedBook.getPrice());

        Order order = Order.builder()
                .orderDate(LocalDateTime.now()) // Agregamos la fecha
                .customerName("Test Customer")
                .customerEmail("test@example.com")
                .status(OrderStatus.PENDING)
                .totalAmount(orderItem.getPriceAtPurchase() * orderItem.getQuantity())
                .items(List.of(orderItem))
                .build();

        Order savedOrder = orderRepository.save(order);
        assertNotNull(savedOrder.getId());
        assertNotNull(savedOrder.getOrderDate());
    }
}