import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User user = new User("Christine");

        Product p1 = new StandardProduct("P001", "Cake", 6.90);
        Product p2 = new StandardProduct("P002", "Facewash", 13.80);
        Product p3 = new StandardProduct("P003", "Notebook", 2.50);

        boolean running = true;
        while (running) {
            System.out.println("\n=== ONLINE SHOPPING CART ===");
            System.out.println("1. View Products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. Remove Product from Cart");
            System.out.println("4. View Cart");
            System.out.println("5. Checkout");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            int choice = -1;
            try {
                choice = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    p1.displayProduct();
                    p2.displayProduct();
                    p3.displayProduct();
                    break;

                case 2:
                    System.out.print("Enter product ID to add: ");
                    String addId = sc.nextLine();
                    if (addId.equals("P001")) user.getCart().addProduct(p1);
                    else if (addId.equals("P002")) user.getCart().addProduct(p2);
                    else if (addId.equals("P003")) user.getCart().addProduct(p3);
                    else System.out.println("Invalid ID.");
                    break;

                case 3:
                    System.out.print("Enter product ID to remove: ");
                    String removeId = sc.nextLine();
                    user.getCart().removeProduct(removeId);
                    break;

                case 4:
                    user.getCart().viewCart();
                    break;

                case 5:
                    System.out.printf("Total: RM%.2f\n", user.getCart().getTotal());
                    System.out.println("Thank you for shopping!");
                    running = false;
                    break;

                case 0:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}
