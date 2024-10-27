package OrderManagement;
import RestaurantManagement.*;
import java.util.ArrayList;
import java.util.Date;

public class Order
{
	private int orderId;
	private Date orderDate;
	private double totalAmount;
	private Payment payment;
	private ArrayList<Item> items;
	
	public Order(int orderId, Date order)
	{
		this.orderId = orderId;
		this.orderDate = order;
		this.items = new ArrayList<>();
		this.totalAmount = 0.0;
	}
	
	public void addItem(Item item)
	{
		items.add(item);
        System.out.println("Item " +item.getItemName()+ " successfully added.");
		calculateTotal();
	}
	
	public void removeItem(Item item)
	{
		items.remove(item);
        System.out.println("Item " +item.getItemName()+ " successfully removed.");
		calculateTotal();
	}
	
	public double calculateTotal()
	{
		totalAmount = 0.0;
		for(Item item: items)
		{
			totalAmount += item.getItemPrice();
		}
		return totalAmount;
	}

	public int getOrderId() { return orderId; }
	public void setOrderId(int orderId) { this.orderId = orderId; }
	public Date getOrderDate() { return orderDate; } 
	public void setOrderDate(Date order) { this.orderDate = order; }
	public double getTotalAmount() { return totalAmount; }
	public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
    public Payment getPayment() { return payment; }
    public void setPayment(Payment payment) { this.payment = payment; }
	public ArrayList<Item> getItems() { return items; }	
	public void setItems(ArrayList<Item> items) { this.items = items; }
}




