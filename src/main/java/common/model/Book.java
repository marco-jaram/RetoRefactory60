package common.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Book extends Product {
    private String author;
    private String isbn;
    private String publisher;
    private PhilosophyCategory category; // Ej: ETHICS, METAPHYSICS, LOGIC, etc.
}

