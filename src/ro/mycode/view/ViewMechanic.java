package ro.mycode.view;

import ro.mycode.controller.CarController;
import ro.mycode.controller.CustomerController;
import ro.mycode.controller.MechanicController;
import ro.mycode.models.Car;
import ro.mycode.models.Mechanic;

import java.util.Scanner;

public class ViewMechanic {

    private CarController carController;
    private Scanner scanner;
    private Mechanic mechanic;
    private CustomerController customerController;
    private MechanicController mechanicController;

    public ViewMechanic(Mechanic mechanic) {
        mechanicController = new MechanicController();
        carController = new CarController();
        customerController=new CustomerController();
        scanner = new Scanner(System.in);
        play();
    }


    public void meniu() {
        System.out.println("Hello, mechanic!");
        System.out.println("Press 1 to see all mechanics");
        System.out.println("Press 2 to add a mechanic");
        System.out.println("Press 3 to delete a mechanic");
        System.out.println("Press 4 to edit a mechanic");
        System.out.println("Press 5 to save the mechanic and exit");
        System.out.println("Press 6 to show the most damage car");
        System.out.println("Press 8 to see all the cars");
        System.out.println("Press 9 to add a car");
        System.out.println("Press 10 to delete a car");
        System.out.println("Press 11 to edit a car");
        System.out.println("Press 12 to save the car and exis");
        System.out.println("Press 13- to exit without to save the car ");
    }

    public void play() {
        int alegere = 0;
        boolean running = true;
        while (running) {
            meniu();
            alegere = Integer.parseInt(scanner.nextLine());
            switch (alegere) {
                case 1:
                    mechanicController.afisareMechanic();
                    break;
                case 2:
                    addMechanic();
                    break;
                case 3:
                    removeMechanic();
                    break;
                case 4:
                    editMechanic();
                    break;
                case 5:
                    running = false;
                    mechanicController.save();
                    System.out.println("You have logged out");
                    break;
                case 8:
                    carController.afisareCar();
                    break;
                case 9:
                    addCar();
                    break;
                case 10:
                    removeCar();
                    break;
                case 11:
                    editCar();
                    break;
                case 12:
                    running = false;
                    carController.save();
                    System.out.println("You have logged out");
                    break;
                case 13:
                    running = false;
                    System.out.println("You have logged out");
                default:
                    System.out.println("Incorrect choice!");
                    break;
            }
        }
    }


    private void addMechanic() {
        System.out.println("Id:");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Name");
        String name = scanner.nextLine();
        System.out.println("Email:");
        String email = scanner.nextLine();
        System.out.println("Password:");
        String password = scanner.nextLine();
       Mechanic mechanic = mechanicController.findMechanicById(id);
        if (mechanic == null) {
            Mechanic mNew = new Mechanic(id, name, email, password);
            mechanicController.addMechanic(mNew);

        } else {
            System.out.println("The mechanic already exist");
        }

    }

    private void removeMechanic() {
        System.out.println("Enter the id:");
        int id = Integer.parseInt(scanner.nextLine());
       Mechanic mechanic = mechanicController.findMechanicById(id);
        if (mechanic == null) {
            System.out.println(" There is no mechanic!");
        } else {
            mechanicController.removeMechanic(mechanic);
            System.out.println("The mechanic has been deleted from the list!");
        }
    }


    private void editMechanic() {
        System.out.println("Enter the id:");
        int id = Integer.parseInt(scanner.nextLine());
        Mechanic mechanic = mechanicController.findMechanicById(id);
        if (mechanic == null) {
            System.out.println("There is no mechanic with the entered id");
        } else {
            System.out.println("Enter with a comma what you want to change (email, name):");
            String[] upd = scanner.nextLine().split(",");
            Mechanic nou = new Mechanic();

            nou.setId(mechanic.getId());
            for (int i = 0; i < upd.length; i++) {
                switch (upd[i]) {
                    case "email":
                        System.out.println("Enter the email:");
                        String email = scanner.nextLine();
                        nou.setEmail(email);
                        break;
                    case "name":
                        System.out.println("Enter the name:");
                        String name = scanner.nextLine();
                        nou.setName(name);
                        break;
                    default:
                        System.out.println("Error");
                }
            }
            mechanicController.editareMechanic(nou);
        }


    }


    private void addCar() {
        System.out.println("Id:");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Car Number:");
        String carNumber = scanner.nextLine();
        System.out.println("Car Type:");
        String carType = scanner.nextLine();
        System.out.println("Description:");
        String description = scanner.nextLine();
        System.out.println("Customer ID:");
        int customerID = Integer.parseInt(scanner.nextLine());


       Car car = carController.findCarById(id);
        if (car == null) {
            Car cNou = new Car(id, carNumber, carType,description,customerID);
            carController.addCar(cNou);
        } else {
            System.out.println("The car already exists");
        }
    }

    private void removeCar() {
        System.out.println("Enter the id:");
        int id = Integer.parseInt(scanner.nextLine());

        Car car = carController.findCarById(id);
        if (car == null) {
            System.out.println("There is no car!");
        } else {
            carController.removeCar(car);
            System.out.println("The car was deleted");
        }
    }

    private void editCar() {
        System.out.println("Enter the id:");
        int id = Integer.parseInt(scanner.nextLine());

        Car car = carController.findCarById(id);
        if (car == null) {
            System.out.println("There is no car with the entered id");
        } else {
            System.out.println("Enter with a comma what you want to change (description, customerID):");
            String[] upd = scanner.nextLine().split(",");
            Car nou = new Car();
            for (int i = 0; i < upd.length; i++) {
                switch (upd[i]) {
                    case "description":
                        System.out.println("Enter the description");
                        String description = scanner.nextLine();
                        break;
                    case "customerID":
                        System.out.println("Enter the customer id:");
                        String customerID = scanner.nextLine();
                        break;

                    default:
                        System.out.println("Error");
                        break;
                }
            }
            carController.editareCar(nou);
        }
    }
}
