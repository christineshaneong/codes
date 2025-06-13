public class Product{
    private String name;
    private double price;
    private String id; /*encapsulation to protect the data */

public Product (String id, String name, double price){
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

public void displayProduct() {
    System.out.println("ID: " + id + " | " + name + " - RM " + price);
}

}