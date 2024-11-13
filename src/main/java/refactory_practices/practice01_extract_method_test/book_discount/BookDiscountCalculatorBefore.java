package refactory_practices.practice01_extract_method_test.book_discount;

public class BookDiscountCalculatorBefore {
    public double calculateDiscount(double bookPrice, int customerAge, boolean isPhilosophyStudent, boolean isPremiumMember) {
        double finalPrice = bookPrice;

        // Aplicar descuento por edad
        if (customerAge < 25) {
            finalPrice = finalPrice * 0.9;
            System.out.println("Descuento joven aplicado: 10%");
        } else if (customerAge >= 65) {
            finalPrice = finalPrice * 0.85;
            System.out.println("Descuento senior aplicado: 15%");
        }

        // Aplicar descuento estudiante
        if (isPhilosophyStudent) {
            finalPrice = finalPrice * 0.8;
            System.out.println("Descuento estudiante filosofía aplicado: 20%");
        }

        // Aplicar descuento miembro premium
        if (isPremiumMember) {
            finalPrice = finalPrice * 0.95;
            System.out.println("Descuento premium aplicado: 5%");
        }

        System.out.println("Precio original: " + bookPrice);
        System.out.println("Precio final con descuentos: " + finalPrice);

        return finalPrice;
    }
}