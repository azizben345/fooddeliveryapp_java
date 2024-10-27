package UserManagement;
//import java.util.Scanner;

public class Customer extends User {
    private String address;
    private String phoneNumber;

    public Customer(String id, String name, String email, String password, String address, String phoneNumber) {
        super(id, name, email, password);
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public void displayInfo() {
        System.out.println("ID: "+id);
        System.out.println("Name: "+name);
        System.out.println("Email: "+email);
        System.out.println("Address: "+address);
        System.out.println("Phone No.: "+phoneNumber);
    }
    
    //public String trackOrder(Order order) {}
}
