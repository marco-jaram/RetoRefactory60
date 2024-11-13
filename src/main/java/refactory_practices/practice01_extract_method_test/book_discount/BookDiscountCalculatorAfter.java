package refactory_practices.practice01_extract_method_test.book_discount;

public class BookDiscountCalculatorAfter {
    public double calculateDiscount(double bookPrice, int customerAge, boolean isPhilosophyStudent, boolean isPremiumMember) {
        double finalPrice = bookPrice;

        finalPrice = applyAgeDiscount(finalPrice, customerAge);
        finalPrice = applyStudentDiscount(finalPrice, isPhilosophyStudent);
        finalPrice = applyPremiumDiscount(finalPrice, isPremiumMember);

        printPriceInfo(bookPrice, finalPrice);

        return finalPrice;
    }

    private double applyAgeDiscount(double price, int customerAge) {
        if (customerAge < 25) {
            System.out.println("Descuento joven aplicado: 10%");
            return price * 0.9;
        } else if (customerAge >= 65) {
            System.out.println("Descuento senior aplicado: 15%");
            return price * 0.85;
        }
        return price;
    }

    private double applyStudentDiscount(double price, boolean isPhilosophyStudent) {
        if (isPhilosophyStudent) {
            System.out.println("Descuento estudiante filosofía aplicado: 20%");
            return price * 0.80;
        }
        return price;
    }

    private double applyPremiumDiscount(double price, boolean isPremiumMember) {
        if (isPremiumMember) {
            System.out.println("Descuento premium aplicado: 5%");
            return price * 0.95;
        }
        return price;
    }

    private void printPriceInfo(double originalPrice, double finalPrice) {
        System.out.println("Precio original: " + originalPrice);
        System.out.println("Precio final con descuentos: " + finalPrice);
    }
}