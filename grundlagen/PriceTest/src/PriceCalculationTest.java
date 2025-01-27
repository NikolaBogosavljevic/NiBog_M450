public class PriceCalculationTest {

    static boolean test_calculate_price() {
        boolean test_ok = true;

        double price = calculatePrice(1000, 200, 300, 3, 10);
        if (Math.abs(price - 1450.0) > 0.01) {
            System.out.println("Test 1 failed. Expected: 1450.0, Got: " + price);
            test_ok = false;
        }

        price = calculatePrice(1000, 200, 300, 5, 15);
        if (Math.abs(price - 1375.0) > 0.01) {
            System.out.println("Test 2 failed. Expected: 1375.0, Got: " + price);
            test_ok = false;
        }

        price = calculatePrice(1000, 200, 300, 1, 5);
        if (Math.abs(price - 1475.0) > 0.01) {
            System.out.println("Test 3 failed. Expected: 1475.0, Got: " + price);
            test_ok = false;
        }

        return test_ok;
    }

    static double calculatePrice(double baseprice, double specialprice, double extraprice, int extras, double discount) {
        double addon_discount;
        double result;

        if (extras >= 5)
            addon_discount = 15;
        else if (extras >= 3)
            addon_discount = 10;
        else
            addon_discount = 0;

        if (discount > addon_discount)
            addon_discount = discount;

        result = baseprice / 100.0 * (100 - discount) + specialprice
                + extraprice / 100.0 * (100 - addon_discount);

        return result;
    }
}