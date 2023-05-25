package ro.mycode.view;

import ro.mycode.controller.CarController;
import ro.mycode.controller.CustomerController;
import ro.mycode.controller.MechanicController;
import ro.mycode.models.Car;
import ro.mycode.models.Customer;
import ro.mycode.models.Mechanic;

import java.util.Scanner;

public class ViewLogin {
    private MechanicController mechanicController;
    private CustomerController customerController;
    private Scanner scanner;


    public ViewLogin() {
        customerController = new CustomerController();
        mechanicController = new MechanicController();
        scanner = new Scanner(System.in);
        play();
    }

    public void meniu() {
        System.out.println("Press 1 to log in");
            System.out.println("Press 2 to register");

    }

    public void meniu2() {
        System.out.println("Press 1 if you are a customer");
        System.out.println("Press 2 if you are a mechanic");
    }

    public void play() {
        int alegere = 0;
        boolean running = true;
        while (running) {
            meniu();
            alegere = Integer.parseInt(scanner.nextLine());
            switch (alegere) {

                case 1:
                    logIn();
                    break;
                case 2:
                    register();
                    customerController.save();
                    break;
                default:
                    System.out.println("Error");
                    break;
            }
        }
    }

    public void logIn() {

        int alegere = 0;
        boolean running = true;
        while (running) {
            meniu2();
            alegere = Integer.parseInt(scanner.nextLine());

            System.out.println("Enter the email: ");
            String email = scanner.nextLine();
            System.out.println("Enter the password:");
            String password = scanner.nextLine();
            switch (alegere) {
                case 1:

                    Customer customer = customerController.findCustomer(email, password);
                    if (customer != null) {
                        ViewCustomer viewCustomer = new ViewCustomer(customer);
                    } else {
                        System.out.println("Error");
                    }
                    break;
                case 2:

                    Mechanic mechanic = mechanicController.findMechanicConectare(email, password);
                    if (mechanic != null) {
                        ViewMechanic viewMechanic = new ViewMechanic(mechanic);
                    } else {
                        System.out.println("Error at mechanic");
                    }
                    break;
                default:
                    System.out.println("Error.switch");
                    break;
            }
        }
    }


    public void register() {
        int alegere = 0;
        boolean running = true;
        while (running) {
            meniu2();
            alegere = Integer.parseInt(scanner.nextLine());
            switch (alegere) {
                case 1:

                    System.out.println("Enter: id,name,mobile,address,email,password,username");
                    System.out.println("id:");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.println("nume:");
                    String name = scanner.nextLine();
                    System.out.println("mobile:");
                    String mobile = scanner.nextLine();
                    System.out.println("address:");
                    String address = scanner.nextLine();
                    System.out.println("email:");
                    String email = scanner.nextLine();
                    System.out.println("password:");
                    String password = scanner.nextLine();
                    System.out.println("username:");
                    String username = scanner.nextLine();

                    Customer customer = customerController.findByName(name);
                    if (customer == null) {
                        Customer cNou = new Customer(id,name,mobile,address,email,password,username);
                        customerController.addCustomer(cNou);
                        System.out.println("The client has been added!");

                    } else {
                        System.out.println("The customer is already registered");
                    }
                    break;
                case 2:
                    System.out.println("Enter: id,name,email,password");
                    System.out.println("id:");
                    int idMechanic = Integer.parseInt(scanner.nextLine());
                    System.out.println("name:");
                    String nameMechanic = scanner.nextLine();
                    System.out.println("email:");
                    String emailMechanic = scanner.nextLine();
                    System.out.println("password:");
                    String passwordMechanic = scanner.nextLine();


                    Mechanic mechanic = mechanicController.findMechanicById(idMechanic);
                    if (mechanic == null) {
                        Mechanic mNou = new Mechanic(idMechanic,nameMechanic,emailMechanic,passwordMechanic);
                        mechanicController.addMechanic(mNou);
                        System.out.println("The mechanic has been added!");
                    } else {
                        System.out.println("The mechanic is already registered");
                    }
                    break;
                default:
                    System.out.println("Error");
                    break;

            }
        }
    }

}
