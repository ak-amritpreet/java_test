import java.util.Scanner;

public class burger {
    public static void main(String[] args) {
        String restaurantName = "Brampton Hamburgers";
        System.out.println("Welcome to " + restaurantName + "!\n");

        String[] BURGERtypes = {
            "Veggie Burger",
            "Deluxe Veggie Burger",
            "Chicken Burger",
            "Cheese Chicken Burger",
            "Cheese Bacon Burger",
            "Deluxe Bacon Burger",
            "Healthy Organic Burger"
        };

        double[] BURGERprices = {
            5.95,
            7.95,
            6.45,
            8.50,
            9.25,
            10.95,
            12.45
        };

        int TOTALcustomer = 5;
        double TOTALbillingAMOUNT = 0;

        for (int customer = 1; customer <= TOTALcustomer; customer++) {
            System.out.println("Customer " + customer + ":");

            double subTotal = 0;
            int[] quantities = new int[BURGERtypes.length];

            Scanner boltzz= new Scanner(System.in);

            System.out.println("Menu for " + restaurantName + ":\n");
            System.out.println("Type of Burger\t\tPrice");

            for (int i = 0; i < BURGERtypes.length; i++) {
                System.out.printf("%d. %s\t$%.2f\n", (i + 1), BURGERtypes[i], BURGERprices[i]);
            }

            while (true) {
                System.out.print("\nEnter an option (1-8): ");
                int option = boltzz.nextInt();

                if (option < 1 || option > 8) {
                    boltzz.close();
                    throw new IllegalArgumentException("Invalid option selected!");
                }

                if (option == 8) {
                    break;
                }

                System.out.print("Enter quantity: ");
                int quantity = boltzz.nextInt();
                quantities[option - 1] += quantity;
            }

            for (int i = 0; i < BURGERtypes.length; i++) {
                if (quantities[i] > 0) {
                    double price = BURGERprices[i];
                    double itemTotal = price * quantities[i];
                    subTotal += itemTotal;
                }
            }

            double tax = subTotal * 0.13;
            double totalAmount = subTotal + tax;

            if (totalAmount > 50 && totalAmount <= 100) {
                totalAmount *= 0.95; // Apply 5% discount
            } else if (totalAmount > 100) {
                totalAmount *= 0.9; // Apply 10% discount
            }

            TOTALbillingAMOUNT += totalAmount;

            System.out.println("\nOrder Summary:");
            System.out.printf("Subtotal: $%.2f\n", subTotal);
            System.out.printf("Tax (13%%): $%.2f\n", tax);
            System.out.printf("Total amount: $%.2f\n", totalAmount);
        }

        System.out.printf("\nTotal billing amount for all customers: $%.2f\n", TOTALbillingAMOUNT);
    }
}
