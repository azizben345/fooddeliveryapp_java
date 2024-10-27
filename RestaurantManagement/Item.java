package RestaurantManagement;

public class Item {
    private int itemID;
    private String itemName;
    private double itemPrice;

    public Item(int itemID, String itemName, double itemPrice) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public void displayItemInfo() {
        System.out.println(itemName + " (RM"+ String.format("%.2f", itemPrice)+")");
    }

    // Getters and setters
    public int getItemID() { return itemID; }
    public void setItemID(int itemID) { this.itemID = itemID; }
    public String getItemName() { return itemName; } 
    public void setItemName(String itemName) { this.itemName = itemName; }
    public double getItemPrice() { return itemPrice; }
    public void setItemPrice(double itemPrice) { this.itemPrice = itemPrice; }
}
