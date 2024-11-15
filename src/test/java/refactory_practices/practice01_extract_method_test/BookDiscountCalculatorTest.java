package refactory_practices.practice01_extract_method_test;






import org.junit.jupiter.api.Test;
import refactory_practices.practice01_extract_method.book_discount.BookDiscountCalculatorAfter;
import refactory_practices.practice01_extract_method.book_discount.BookDiscountCalculatorBefore;

import static org.junit.jupiter.api.Assertions.*;

public class BookDiscountCalculatorTest {

    private BookDiscountCalculatorBefore calculatorBefore = new BookDiscountCalculatorBefore();
    private BookDiscountCalculatorAfter calculatorAfter = new BookDiscountCalculatorAfter();

    @Test
    void shouldCalculateSameDiscounts() {
        // Datos de prueba
        double bookPrice = 100.0;

        // Caso 1: Estudiante joven y premium
        assertEquals(
                calculatorBefore.calculateDiscount(bookPrice, 20, true, true),
                calculatorAfter.calculateDiscount(bookPrice, 20, true, true),
                "Deben calcular el mismo precio para estudiante joven premium"
        );

        // Caso 2: Senior sin beneficios adicionales
        assertEquals(
                calculatorBefore.calculateDiscount(bookPrice, 65, false, false),
                calculatorAfter.calculateDiscount(bookPrice, 65, false, false),
                "Deben calcular el mismo precio para senior sin beneficios"
        );
    }

    @Test
    void shouldCalculateCorrectDiscounts() {
        BookDiscountCalculatorAfter calculator = new BookDiscountCalculatorAfter();
        double bookPrice = 100.0;

        // Probar descuento joven (10%)
        double priceWithYoungDiscount = calculator.calculateDiscount(bookPrice, 20, false, false);
        assertEquals(90.0, priceWithYoungDiscount,
                "Descuento joven debe ser 10%");

        // Probar descuento estudiante filosofía (20%)
        double priceWithStudentDiscount = calculator.calculateDiscount(bookPrice, 30, true, false);
        assertEquals(80.0, priceWithStudentDiscount,
                "Descuento estudiante debe ser 20%");

        // Probar descuento premium (5%)
        double priceWithPremiumDiscount = calculator.calculateDiscount(bookPrice, 30, false, true);
        assertEquals(95.0, priceWithPremiumDiscount,
                "Descuento premium debe ser 5%");
    }
}
