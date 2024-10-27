package UserManagement;

public class DeliveryPerson extends User {
    private String vehicleType;

    public DeliveryPerson(String id, String name, String email, String password, String vehicleType) {
        super(id, name, email, password);
        this.vehicleType = vehicleType;
    }

    public String getVehicleType() { return vehicleType; }
    public void setVehicleType(String vehicleType) { this.vehicleType = vehicleType; }

    public void displayInfo() {
        System.out.println("ID: "+id);
        System.out.println("Name: "+name);
        System.out.println("Email: "+email);
        System.out.println("Vehicle Type: "+vehicleType);
    }
}
