import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Product> items;

    public ShoppingCart(){
        items = new ArrayList<>();
    }

    public void addProduct (Product product){
        items.add(product);
        System.out.println(product.getName() + " added to cart. ");
    }

    public void removeProduct (String id){
        boolean found = false;
        for (Product p : items){
            if (p.getId().equals(id)) {
                items.remove(p);
                System.out.println(p.getName() + " removed from cart.");
                found = true;
                break;
            }
        }

    if (!found){
        System.out.println("Product with id: " + id + " not found in cart.");
    }
}

public void viewCart() {
    if (items.isEmpty()){
        System.out.println("Cart is empty.");
    } else {
        System.out.println("Items in cart: ");
        for (Product p : items) {
        p.displayProduct();
        }
    }
}

    public double getTotal(){
        double total = 0;
        for (Product p : items) {
            total += p.getPrice();
        }
        return total;
    }
}

