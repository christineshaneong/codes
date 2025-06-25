import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Admin admin = new Admin();

        admin.addProduct("P001", "Cake", 6.90);
        admin.addProduct("P002", "Facewash", 13.80);
        admin.addProduct("P003", "Notebook", 2.50);

        System.out.println("Welcome to Online Shopping System!");
        System.out.print("Are you 'admin' or 'customer'? : ");
        String role = sc.nextLine();

        if (role.equalsIgnoreCase("admin")) {
            adminMenu(sc, admin);
        } else if (role.equalsIgnoreCase("customer")) {
            customerMenu(sc, admin);
        } else {
            System.out.println("Invalid role.");
        }

        sc.close();
    }

    public static void adminMenu(Scanner sc, Admin admin) {
        boolean running = true;
        while (running) {
            System.out.println("\n=== ADMIN MENU ===");
            System.out.println("1. Add Product");
            System.out.println("2. View Products & Sales");
            System.out.println("0. Logout");
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
                    System.out.print("Enter Product ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();
                    admin.addProduct(id, name, price);
                    break;

                case 2:
                    admin.viewProductsWithSales();
                    break;

                case 0:
                    running = false;
                    System.out.println("Logged out.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void customerMenu(Scanner sc, Admin admin) {
        System.out.print("Enter your name: ");
        String username = sc.nextLine();
        User user = new User(username);

        boolean running = true;
        while (running) {
            System.out.println("\n=== CUSTOMER MENU ===");
            System.out.println("1. View Products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. Remove Product from Cart");
            System.out.println("4. View Cart");
            System.out.println("5. Checkout");
            System.out.println("0. Logout");
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
                    admin.viewProducts();
                    break;

                case 2:
                    System.out.print("Enter product ID to add: ");
                    String addId = sc.nextLine();
                    Product addProduct = admin.findProductById(addId);
                    if (addProduct != null) {
                        user.getCart().addProduct(addProduct);
                    } else {
                        System.out.println("Invalid Product ID.");
                    }
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
                    System.out.println("Logged out.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
