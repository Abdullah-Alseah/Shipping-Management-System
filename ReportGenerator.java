import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReportGenerator {

    public static Product findMostExpensiveProduct(ProductBST bst) {
        return findMostExpensive(bst.getRoot());
    }

    private static Product findMostExpensive(ProductNode node) {
        if (node == null) return null;
        Product leftMax = findMostExpensive(node.left);
        Product rightMax = findMostExpensive(node.right);
        Product current = node.product;

        Product max = current;
        if (leftMax != null && leftMax.price > max.price) max = leftMax;
        if (rightMax != null && rightMax.price > max.price) max = rightMax;

        return max;
    }

    public static Product findMostRequestedProduct(OrderManager orderManager) {
        Map<String, Integer> demandMap = new HashMap<>();
        PriorityQueue<Order> temp = orderManager.getOrderQueue();

        while (!temp.isEmpty()) {
            Order o = temp.poll();
            demandMap.put(o.productName, demandMap.getOrDefault(o.productName, 0) + o.quantity);
        }

        String mostRequested = null;
        int maxQty = -1;
        for (Map.Entry<String, Integer> entry : demandMap.entrySet()) {
            if (entry.getValue() > maxQty) {
                maxQty = entry.getValue();
                mostRequested = entry.getKey();
            }
        }

        if (mostRequested != null) {
            System.out.println("Most requested product is: " + mostRequested + " with total quantity = " + maxQty);
        }

        return null;
    }

    public static void countShipmentsToDestination(ShipmentBST bst, String destination) {
        int count = countDestRec(bst.getRoot(), destination);
        System.out.println("Number of shipments to " + destination + ": " + count);
    }

    private static int countDestRec(ShipmentNode node, String dest) {
        if (node == null) return 0;
        int count = node.shipment.destination.equalsIgnoreCase(dest) ? 1 : 0;
        return count + countDestRec(node.left, dest) + countDestRec(node.right, dest);
    }
}