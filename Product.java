// Abstract base class to enforce structure and allow polymorphism
public abstract class Product {
    private String name;
    private double price;
    private String id;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    // Abstract method forces subclasses to implement their own display
    public abstract void displayProduct();
}

// Subclass of Product for general use
class StandardProduct extends Product {
    public StandardProduct(String id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public void displayProduct() {
        System.out.println("ID: " + getId() + " | " + getName() + " - RM " + getPrice());
    }
}
