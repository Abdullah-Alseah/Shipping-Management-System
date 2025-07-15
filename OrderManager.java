import java.util.PriorityQueue;

public class OrderManager {
    private PriorityQueue<Order> orderQueue;

    public PriorityQueue<Order> getOrderQueue() {
        return new PriorityQueue<>(orderQueue);
    }

    public OrderManager() {
        orderQueue = new PriorityQueue<>();
    }

    public void addOrder(Order order) {
        if (order.quantity <= 0 || order.priority < 0) {
            System.out.println("Invalid order data!");
            return;
        }
        orderQueue.add(order);
    }

    public Order processNextOrder() {
        if (orderQueue.isEmpty()) {
            System.out.println("No orders to process.");
            return null;
        }
        return orderQueue.poll();
    }

    public void printAllOrders() {
        PriorityQueue<Order> copy = new PriorityQueue<>(orderQueue);
        while (!copy.isEmpty()) {
            copy.poll().print();
        }
    }
}
