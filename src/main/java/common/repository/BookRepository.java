package common.repository;

import common.model.Book;
import common.model.PhilosophyCategory;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.List;
import java.util.Optional;

@Slf4j
public class BookRepository implements ProductRepository<Book> {
    private final Connection connection;

    public BookRepository() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    @Override
    public Book save(Book book) {
        String sql = "INSERT INTO books (name, description, price, stock, author, isbn, publisher, category) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, book.getName());
            stmt.setString(2, book.getDescription());
            stmt.setDouble(3, book.getPrice());
            stmt.setInt(4, book.getStock());
            stmt.setString(5, book.getAuthor());
            stmt.setString(6, book.getIsbn());
            stmt.setString(7, book.getPublisher());
            stmt.setString(8, book.getCategory().name());

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    book.setId(rs.getLong(1));
                }
            }
            return book;
        } catch (SQLException e) {
            log.error("Error saving book", e);
            throw new RuntimeException("Error saving book", e);
        }
    }

    @Override
    public Optional<Book> findById(Long id) {
        String sql = "SELECT * FROM books WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapResultSetToBook(rs));
                }
            }
        } catch (SQLException e) {
            log.error("Error finding book by id", e);
            throw new RuntimeException("Error finding book", e);
        }
        return Optional.empty();
    }

    @Override
    public List<Book> findAll() {
        return List.of();
    }

    @Override
    public void update(Book product) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void updateStock(Long id, int quantity) {

    }

    private Book mapResultSetToBook(ResultSet rs) throws SQLException {
        return Book.builder()
                .id(rs.getLong("id"))
                .name(rs.getString("name"))
                .description(rs.getString("description"))
                .price(rs.getDouble("price"))
                .stock(rs.getInt("stock"))
                .author(rs.getString("author"))
                .isbn(rs.getString("isbn"))
                .publisher(rs.getString("publisher"))
                .category(PhilosophyCategory.valueOf(rs.getString("category")))
                .build();
    }

    // Implementar el resto de métodos...
}