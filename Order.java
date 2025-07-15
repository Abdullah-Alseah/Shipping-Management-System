public class Order implements Comparable<Order> {
    int id;
    String productName;
    int quantity;
    int priority; // كلما زادت القيمة زادت الأولوية

    public Order(int id, String productName, int quantity, int priority) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
        this.priority = priority;
    }

    @Override
    public int compareTo(Order o) {
        // ترتيب تنازلي حسب الأولوية (max-heap)
        return Integer.compare(o.priority, this.priority);
    }

    public void print() {
        System.out.println("Order ID: " + id + ", Product: " + productName +
                ", Quantity: " + quantity + ", Priority: " + priority);
    }
}

