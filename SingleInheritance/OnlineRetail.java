package SingleInheritance;



import java.time.LocalDate;

class Order {
    private String orderId;
    private LocalDate orderDate;

    public Order(String orderId, LocalDate orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return "Order Placed";
    }

    public void displayOrderInfo() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Order Status: " + getOrderStatus());
    }

    public String getOrderId() {
        return orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }
}

class ShippedOrder extends Order {
    private String trackingNumber;

    public ShippedOrder(String orderId, LocalDate orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    public String getOrderStatus() {
        return "Order Shipped";
    }

    @Override
    public void displayOrderInfo() {
        super.displayOrderInfo();
        System.out.println("Tracking Number: " + trackingNumber);
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }
}

class DeliveredOrder extends ShippedOrder {
    private LocalDate deliveryDate;

    public DeliveredOrder(String orderId, LocalDate orderDate, String trackingNumber, LocalDate deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String getOrderStatus() {
        return "Order Delivered";
    }

    @Override
    public void displayOrderInfo() {
        super.displayOrderInfo();
        System.out.println("Delivery Date: " + deliveryDate);
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }
}

public class OnlineRetail {
    public static void main(String[] args) {
        Order order1 = new Order("ORD1001", LocalDate.of(2025, 9, 22));
        ShippedOrder order2 = new ShippedOrder("ORD1002", LocalDate.of(2025, 9, 21), "TRK12345");
        DeliveredOrder order3 = new DeliveredOrder("ORD1003", LocalDate.of(2025, 9, 20), "TRK67890", LocalDate.of(2025, 9, 22));

        order1.displayOrderInfo();
        System.out.println();
        order2.displayOrderInfo();
        System.out.println();
        order3.displayOrderInfo();
    }
}
