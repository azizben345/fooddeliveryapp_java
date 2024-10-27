package RestaurantManagement;

import java.util.ArrayList;

public class Restaurant {
    private int restaurantID;
    private String name, location;
    private ArrayList<Menu> menus;

    public Restaurant(int id, String name, String location) {
        restaurantID = id;
        this.name = name;
        menus = new ArrayList<>();
    }
    public void addMenu(Menu menu) {
        menus.add(menu);
    }
    public void removeMenu(Menu menu) {
        menus.remove(menu);
    }
    public void displayMenuList() {
        for (int i = 0; i < menus.size(); i++) {
            System.out.println("("+(i+1)+") "+ menus.get(i).getMenuName() +":");
            menus.get(i).displayItemList();
        }
    }

    public int getRestaurantID() { return restaurantID; }
    public void setRestaurantID(int restaurantID) { this.restaurantID = restaurantID; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public ArrayList<Menu> getMenus() { return menus; }
    public void setMenus(ArrayList<Menu> menus) { this.menus = menus; }
}
