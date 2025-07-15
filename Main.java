public class Main {
    public static void main(String[] args) {
        // منتجات
        //الطلب الاول
        ProductBST productBST = new ProductBST();
        productBST.insert(new Product(10, "Laptop", 1500.0, 50));
        productBST.insert(new Product(5, "Mouse", 20.0, 300));
        productBST.insert(new Product(15, "Monitor", 700.0, 30));

        //الطلب الثاني
        productBST.updatePrice(15,100.75);
        productBST.updateQuantity(15,300);
        productBST.delete(5);
        // الطلب 2 بالمسألة الأولى
        productBST.search(15).print(); //Print Product By ID.

        // شحنات
        //الطلب الثالث
        ShipmentBST shipmentBST = new ShipmentBST();
        shipmentBST.insert(new Shipment(1, "Damascus", 120.0, "2025-06-10"));
        shipmentBST.insert(new Shipment(2, "Daraa", 90.0, "2025-06-09"));
        shipmentBST.insert(new Shipment(3, "Aleppo", 110.0, "2025-06-08"));

        // طلبات
        //الطلب الرابع
        OrderManager orderManager = new OrderManager();
        orderManager.addOrder(new Order(1, "Laptop", 2, 8));
        orderManager.addOrder(new Order(2, "Mouse", 10, 9));
        orderManager.addOrder(new Order(3, "Monitor", 1, 4));

        // طباعة البيانات
        System.out.println("=== Products ===");
        productBST.inorderPrint();

        System.out.println("\n=== Shipments ===");
        shipmentBST.inorderPrint();

        System.out.println("\n=== Orders ===");
        orderManager.printAllOrders();

        // تقارير
        //الطلبات الاضافية
        System.out.println("\n=== Report: Most Expensive Product ===");
        Product expensive = ReportGenerator.findMostExpensiveProduct(productBST);
        if (expensive != null) expensive.print();

        System.out.println("\n=== Report: Most Requested Product ===");
        ReportGenerator.findMostRequestedProduct(orderManager);

        System.out.println("\n=== Report: Shipments to Daraa ===");
        ReportGenerator.countShipmentsToDestination(shipmentBST, "Daraa");
    }
}
