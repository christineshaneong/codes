import java.util.ArrayList;

public class Admin {
    private ArrayList<Product> productList; //encapsulation

    public Admin() {
        productList = new ArrayList<>();
    }

    public void addProduct(String id, String name, double price) {
        Product newProduct = new StandardProduct(id, name, price);
        productList.add(newProduct);
        System.out.println("Product added: " + name + " (ID: " + id + ")");
    }

    public void viewProducts() {
        if (productList.isEmpty()) {
            System.out.println("No products available.");
        } else {
            System.out.println("=== Available Products ===");
            for (Product p : productList) {
                p.displayProduct();
            }
        }
    }

    public void viewProductsWithSales() {
        if (productList.isEmpty()) {
            System.out.println("No products available.");
        } else {
            System.out.println("=== Products & Sales ===");
            for (Product p : productList) {
                System.out.printf("ID: %s | %s - RM %.2f | Sold: %d\n",
                        p.getId(), p.getName(), p.getPrice(), p.getSoldCount());
            }
        }
    }

    public Product findProductById(String id) {
        for (Product p : productList) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }
}
