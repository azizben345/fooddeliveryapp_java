package testRun;
import java.util.*;

import DeliveryManagement.*;
import OrderManagement.*;
import RestaurantManagement.*;
import UserManagement.*;

class InputMismatch extends Exception
{
    private String message;
    public InputMismatch(String msg) { this.message = msg; }
    public String getMessage() { return message; }
}

public class TestMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<Restaurant> restaurantList = new ArrayList<>();

        User loggedInUser = null;
        Customer customer2 = new Customer("aziz03", "Aziz", "example1@yahoo.com", 
        "qwerty", "No 20 Taman Megah", "01163644423");
        DeliveryPerson deliveryPerson = new DeliveryPerson("2", "Aiman", "aiman@yahoo.com", 
        "password456", "Motorcycle");
        Order order = new Order(100, new Date());

        Restaurant restaurant1 = new Restaurant(1, "Kedai Makan 1", "Lot 5 Taman Jaya");
        Restaurant restaurant2 = new Restaurant(2, "Kedai Makan 2", "No 20 Jalan Tanah Merah");

        Menu menu1 = new Menu(11, "Rahmah Set KM1");
        Menu menu2 = new Menu(12, "Normal Set KM1");
        Menu menu3 = new Menu(22, "Normal Set KM2");

        Item item1 = new Item(111, "Rahmah Chicken Rice", 5.0);
        Item item2 = new Item(121, "Fried Rice", 6.5);
        Item item3 = new Item(122, "Chicken Rice", 6.0);
        Item item4 = new Item(221, "Spaghetti", 7.0);
        Item item5 = new Item(222, "Chicken Chop", 7.0);

        // Create Restaurant Menus
        menu1.addItem(item1);
        menu2.addItem(item2);
        menu2.addItem(item3);
        menu3.addItem(item4);
        menu3.addItem(item5);

        restaurant1.addMenu(menu1);
        restaurant1.addMenu(menu2);
        restaurant2.addMenu(menu3);

        restaurantList.add(restaurant1);
        restaurantList.add(restaurant2);

        try {
            displayLine();
            System.out.println("FOOD DELIVERY APP");
            displayLine();
            System.out.println("Choose Action:");
            displayThinLine();
            System.out.println("1. Login\n2. Register\n3. Exit");
            System.out.print("=> ");
            int actChoice = input.nextInt();
            input.nextLine();
            //displayLine();
            
            if (actChoice == 1) {
                System.out.println("Login Account");
                displayThinLine();
                System.out.println("ID: ");
                String accId = input.nextLine();
                System.out.println("Password:");
                String accPass = input.nextLine();

                while (!accId.equals(customer2.getId()) || !accPass.equals(customer2.getPassword())) {
                System.out.println("ID or password wrong. Please input the correct ID and password.");
                System.out.println("ID: ");
                accId = input.nextLine();
                System.out.println("Password:");
                accPass = input.nextLine();
                }

                displayLine();
                System.out.println("Login Successful. Welcome, " + customer2.getName());
                loggedInUser = customer2;
            } else if (actChoice == 2) {
                displayLine();
                System.out.println("Register New Account");
                displayThinLine();
                System.out.println("ID:");
                String id = input.nextLine();
                System.out.println("Name:");
                String name = input.nextLine();
                System.out.println("Email:");
                String email = input.nextLine();
                System.out.println("Password:");
                String pass = input.nextLine();
                
                System.out.println("Choose your role by inputting number:");
                System.out.println("1. Customer\n2. Delivery Person");
                int accType = input.nextInt();
                input.nextLine();

                if (accType == 1) {
                    System.out.println("Current address:");
                    String address = input.nextLine();
                    System.out.println("Phone number (without -):");
                    String phoneNo = input.nextLine();
                    
                    Customer customer = new Customer(id, name, email, pass, address, phoneNo);
                    loggedInUser = customer;
                } else if (accType == 2) {
                    System.out.println("Vehicle Type:");
                    String vehicleType = input.nextLine();
                    
                    DeliveryPerson deliveryPerson2 = new DeliveryPerson(id, name, email, pass, vehicleType);
                    loggedInUser = deliveryPerson2;
                }
            } else if (actChoice == 3) {
                System.out.println("Exiting...");
                System.exit(0);
            } else throw new InputMismatch("Invalid Login/Register input.");

            // Start Main Menu
            Boolean loopMainMenu = true;
            do {
                displayLine();
                System.out.println("Main Menu");
                displayThinLine();
                System.out.print("1. Order\n2. Manage Account\n3. Check Order\n4. Exit\n=> ");
                actChoice = input.nextInt();
                input.nextLine();

                if (actChoice == 2) {
                    manageAccount(loggedInUser);
                }
                else if (actChoice == 3) {
                    displayLine();
                    System.out.println("Order List:");
                    displayThinLine();
                    for (int i=0; i<order.getItems().size(); i++) {
                        System.out.print((i+1) +". ");
                        order.getItems().get(i).displayItemInfo();
                    }
                    displayThinLine();
                    System.out.println( "Total Amount: RM" +String.format("%.2f", order.getTotalAmount()) );
                    displayThinLine();
                    System.out.println("1. Remove Item\n2. Check Out\n3. Back");
                    System.out.print("=> ");
                    int checkOutChoice = input.nextInt();
                    input.nextLine();
                    displayThinLine();

                    if (checkOutChoice == 1) {
                        System.out.print("Choose item number to remove => ");
                        int removeItemNo = input.nextInt();
                        input.nextLine();
                        order.removeItem(order.getItems().get(removeItemNo-1));
                    } else if (checkOutChoice == 2) {
                        System.out.println("Choose Paying Method: ");
                        displayThinLine();
                        System.out.print("1. Online Banking (FPX)\n2. COD\n=> ");
                        int payTypeChoice = input.nextInt();
                        input.nextLine();
                        String payType = "";
                        if (payTypeChoice == 1) payType = "Online Banking (FPX)";
                        else if (payTypeChoice == 2) payType = "COD";
                        else throw new InputMismatch("Invalid payment type.");

                        Payment pm1 = new Payment(1, payType, order.getTotalAmount());
                        order.setPayment(pm1);
                        loopMainMenu = false;
                    } else if (checkOutChoice == 3) {
                        // Back to Main Menu
                    } else {
                        throw new InputMismatch("Invalid Order/CheckOut input.");
                    }
                }
                else if (actChoice == 4) {
                    System.out.println("Exiting...");
                    System.exit(1);
                }
                else if (actChoice == 1) {
                    // Display Restaurant List
                    displayLine();
                    System.out.println("Available Restaurant:");
                    displayThinLine();
                    for (int i = 0; i < restaurantList.size(); i++) {
                        System.out.println((i+1)+ ". " +restaurantList.get(i).getName());    
                    }
                    System.out.print("Choose restaurant => ");
                    int restChoice = input.nextInt();
                    input.nextLine();
                    --restChoice;
                    displayLine();

                    System.out.println(restaurantList.get(restChoice).getName() +" Menu List:");
                    displayThinLine();
                    restaurantList.get(restChoice).displayMenuList();
                    displayThinLine();
                    System.out.print("Add order (<Menu Number><space><Item Number>) => ");
                    String orderChoice = input.nextLine();
                    String[] ocParts = orderChoice.split(" ");
                    int menuChoice = (Integer.parseInt(ocParts[0]))-1;
                    int itemChoice = (Integer.parseInt(ocParts[1]))-1;
                    //input.nextLine();
                    order.addItem(restaurantList.get(restChoice).getMenus().get(menuChoice).getItems().get(itemChoice));
                    displayLine();
                } else throw new InputMismatch("Invalid Main Menu input.");
            } while (loopMainMenu);
                
            // Initialize delivery with order
            Delivery delivery = new Delivery("1", new Date(), order);           
            // Assign delivery person to the delivery
            delivery.assignDeliveryPerson(deliveryPerson);
            // Simulate the delivery process
            simulateDeliveryProcess(delivery);
                
            // Print final status
            displayLine();
            System.out.println("Order Receipt:");
            displayThinLine();
            System.out.println("Customer: " + loggedInUser.getName());
            delivery.displayDelivery();
            displayLine();
        }
        // Start catch blocks
        catch (InputMismatch e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: Invalid selection input.");
        } catch (Exception e) {
            System.out.println("An unexpected error occured: " + e.getMessage());
        }
        finally {
            input.close();
        }
    }
    
    // Method to simulate the delivery process
    public static void simulateDeliveryProcess(Delivery delivery) {
        delivery.updateStatus("Out for Delivery");
        // Simulate time passing, delivery person actions, etc.
        delivery.updateStatus("Delivered");
    }
    // Method to manage account information
    public static void manageAccount(User userAcc) {
        Scanner input2 = new Scanner(System.in);
        int choice = 0;

        displayLine();
        do {
            System.out.println("Account Info:");
            displayThinLine();
            if (userAcc instanceof Customer) {
                ((Customer)userAcc).displayInfo();
            } else if (userAcc instanceof DeliveryPerson) {
                ((DeliveryPerson)userAcc).displayInfo();
            }
            displayThinLine();
            System.out.print("1. Change Information\n2. Back\n=> ");
            choice = input2.nextInt();
            input2.nextLine();
            displayThinLine();

            if (choice == 1) {
                System.out.println("Choose information to change:");
                System.out.println("1. ID\n2. Name\n3. Email\n4. Password");
                if (userAcc instanceof Customer) {
                    System.out.print("5. Address\n6. Phone No.\n=> ");
                } else if (userAcc instanceof DeliveryPerson) {
                    System.out.print("5. Vehicle Type\n=> ");
                }
                int choice2 = input2.nextInt();
                input2.nextLine();
                displayThinLine();
                System.out.println("Enter new info:");
                String newInfo = input2.nextLine();

                switch (choice2) {
                    case 1:
                        userAcc.setId(newInfo);
                        System.out.println("ID successfully changed.");
                        break;
                    case 2:
                        userAcc.setName(newInfo);
                        System.out.println("Name successfully changed.");
                        break;
                    case 3:
                        userAcc.setEmail(newInfo);
                        System.out.println("Email successfully changed.");
                        break;
                    case 4:
                        userAcc.setPassword(newInfo);
                        System.out.println("Password successfully changed.");
                        break;
                    case 5:
                        if (userAcc instanceof Customer) {
                            ((Customer)userAcc).setAddress(newInfo);
                            System.out.println("Address successfully changed.");
                        } else if (userAcc instanceof DeliveryPerson) {
                            ((DeliveryPerson)userAcc).setVehicleType(newInfo);
                            System.out.println("Vehicle type successfully changed.");
                        }
                        break;
                    case 6:
                        ((Customer)userAcc).setPhoneNumber(newInfo);
                        System.out.println("Phone number successfully changed.");
                        break;
                    default:
                    System.out.println("Invalid input.");
                        break;
                }
            } else {
                System.out.println("Invalid input.");
            }
            displayThinLine();
        } while (choice != 2);
    }
    // Methods to print a line
    public static void displayLine() {
        System.out.println("==================================");
    }
    public static void displayThinLine() {
        System.out.println("----------------------------------");
    }
}