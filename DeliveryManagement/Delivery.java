package DeliveryManagement;

import java.util.Date;
import OrderManagement.Order;
import UserManagement.*;

public class Delivery {
    private String deliveryID, deliveryStatus;
    private Date deliveryDate;
    private Order order;
    private DeliveryPerson deliveryPerson;

    public Delivery(String deliveryID, Date deliveryDate, Order order) {
        this.deliveryID = deliveryID;
        this.deliveryDate = deliveryDate;
        this.order = order;
        this.deliveryStatus = "Pending"; // Initial status
    }
    public void assignDeliveryPerson(DeliveryPerson deliveryPerson) {
        this.deliveryPerson = deliveryPerson;
    }
    public void updateStatus(String status) {
        this.deliveryStatus = status;
    }
    public void displayDelivery() {
        System.out.println("Order ID: " + order.getOrderId());
        //System.out.println("Customer: " + loggedInUser.getName());
        System.out.println("Total Price: RM" + String.format("%.2f", order.getPayment().calcTotal()) );
        System.out.println("Payment Type: " + order.getPayment().getPaymentType());
        System.out.println("Delivery Person: " + deliveryPerson.getName());
        System.out.println("Delivery Status: " + deliveryStatus);
    }

    // Getters and setters
    public String getDeliveryID() { return deliveryID; }
    public void setDeliveryID(String deliveryID) { this.deliveryID = deliveryID; }
    public Date getDeliveryDate() { return deliveryDate; }
    public void setDeliveryDate(Date deliveryDate) { this.deliveryDate = deliveryDate; }
    public String getDeliveryStatus() { return deliveryStatus; }
    public void setDeliveryStatus(String deliveryStatus) { this.deliveryStatus = deliveryStatus; }
    public Order getOrder() { return order; }
    public void setOrder(Order order) { this.order = order; }
    public DeliveryPerson getDeliveryPerson() { return deliveryPerson; }
    public void setDeliveryPerson(DeliveryPerson deliveryPerson) { this.deliveryPerson = deliveryPerson; }
} 