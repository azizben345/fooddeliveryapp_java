package RestaurantManagement;

import java.util.ArrayList;

public class Menu {
    private int menuID;
    private String menuName;
    private ArrayList<Item> items;

    public Menu (int id, String name) {
        menuID = id;
        menuName = name;
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }
    public void removeItem(Item item) {
        items.remove(item);
    }
    public void updateItem(Item updatedItem) {
        for (int i = 0; i < items.size(); i++) {
            Item currentItem = items.get(i);
            if (currentItem.getItemID() == updatedItem.getItemID()) {
                // Update the item's attributes
                currentItem.setItemName(updatedItem.getItemName());
                currentItem.setItemPrice(updatedItem.getItemPrice());
                return; // Exit the method once the item is found and updated
            }
        }
    }
    public void displayItemList() {
        for (int i = 0; i < items.size(); i++) {
            System.out.print((i+1) +". ");
            items.get(i).displayItemInfo();
        }
    }

    public int getMenuID() { return menuID; }
    public void setMenuID(int menuID) { this.menuID = menuID; }
    public String getMenuName() { return menuName; }
    public void setMenuName(String menuName) { this.menuName = menuName; }
    public ArrayList<Item> getItems() { return items; }
    public void setItems(ArrayList<Item> items) { this.items = items; }
}
