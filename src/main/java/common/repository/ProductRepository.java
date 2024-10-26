package common.repository;

import common.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository<T extends Product> {
    T save(T product);
    Optional<T> findById(Long id);
    List<T> findAll();
    void update(T product);
    void delete(Long id);
    void updateStock(Long id, int quantity);
}