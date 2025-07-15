public class Product {
    int id;
    String name;
    double price;
    int quantity;

    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void print() {
        System.out.println("ID: " + id + ", Name: '" + name + "', Price: < " + price + " >, Quantity: < " + quantity+" >");
    }
}
