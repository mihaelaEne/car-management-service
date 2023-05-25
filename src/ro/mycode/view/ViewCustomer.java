package ro.mycode.view;

import ro.mycode.controller.CarController;
import ro.mycode.controller.CustomerController;
import ro.mycode.controller.MechanicController;
import ro.mycode.models.Car;
import ro.mycode.models.Customer;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewCustomer {

    private Customer customer;
    private CustomerController customerController;
    private CarController carController;
    private MechanicController mechanicController;

    private Scanner scanner;



    public ViewCustomer(Customer customer) {

        this.customer = customer;
        carController = new CarController();
        mechanicController=new MechanicController();
        scanner = new Scanner(System.in);
        play();
    }

    public void meniu() {
        System.out.println("Hello " + this.customer.getName() + " !");
        System.out.println("Press 1 to see all customers");
        System.out.println("Press 2 to add a customer");
        System.out.println("Press 3 to delete a customer");
        System.out.println("Press 4 to edit a customer");
        System.out.println("Press 6 to save the customer and exit");
        System.out.println("Press 7 to exit without to customer the car");
        System.out.println("Press 8 to see all the mechanics");
    }


    public void play() {

        int alegere = 0;
        boolean running = true;
        while (running) {
            meniu();
            alegere = Integer.parseInt(scanner.nextLine());
            switch (alegere) {
                case 1:
                    customerController.afisareCustomer();
                    break;
                case 2:
                    addCustomer();
                    break;
                case 3:
                    delegteCustomer();
                    break;
                case 6:
                    running = false;
                    customerController.save();
                    System.out.println("You have logged out ");
                    break;
                case 7:
                    running = false;
                    System.out.println("You have logged out");
                    break;
                case 8:
                    mechanicController.afisareMechanic();
                    break;

                default:
                    System.out.println("Wrong choice");
                    break;
            }
        }
    }

    private void addCustomer() {

        System.out.println("Id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Name:");
        String name = scanner.nextLine();
        System.out.println("mobile:");
        String mobile = scanner.nextLine();
        System.out.println("address:");
        String address = scanner.nextLine();
        System.out.println("Email:");
        String email=scanner.nextLine();
        System.out.println("Password:");
        String password=scanner.nextLine();
        System.out.println("Username:");
        String username=scanner.nextLine();

        Customer customer1=customerController.findByName(name);
        if(customer1==null){
            Customer cNou=new Customer(name);
        }else{
            System.out.println("The customer already exists");
        }

    }

    private void delegteCustomer() {

        System.out.println("Enter the name:");
        String name=scanner.nextLine();

        Customer customer1 = customerController.findByName(name);

        if (customer1 == null) {
            System.out.println("The customer is not on the list");
        } else {
            customerController.removeCustomer(customer1);
            System.out.println("The customer has been deleted from the list");
        }

    }




}
