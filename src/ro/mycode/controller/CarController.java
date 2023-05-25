package ro.mycode.controller;
import ro.mycode.models.Car;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
public class CarController {
    private ArrayList<Car> cars;

    public CarController(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public CarController() {
        this.cars = new ArrayList();
        this.load();
    }

    public void load() {
        try {
            File file = new File("C:\\mycode\\OOP\\car-service-management\\src\\ro\\mycode\\data\\car.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                Car car = new Car(scanner.nextLine());
                this.cars.add(car);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void afisareCar() {
        for (int i = 0; i < cars.size(); i++) {
            System.out.println(this.cars.get(i).descriereCar());
            System.out.println("\n");
        }
    }


    public void addCar(Car car) {
        this.cars.add(car);
    }

    public void removeCar(Car car) {
        this.cars.remove(car);
    }


    public Car findCarById(int id) {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getId() == id) {
                return cars.get(i);
            }
        }
        return null;
    }

    public String toSave() {
        String text = "";
        int i = 0;
        for (i = 0; i < cars.size() - 1; i++) {
            text += cars.get(i).toSaveCar() + "\n";
        }
        text += cars.get(i).toSaveCar();
        return text;
    }

    public void save() {
        try {
            File file = new File("C:\\mycode\\OOP\\car-service-management\\src\\ro\\mycode\\data\\car.txt");
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(toSave());
            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void editareCar(Car car) {
        Car deEdiatat = findCarById(car.getId());
        if (car.getDescription() != null) {
            deEdiatat.setDescription(car.getDescription());
        }
        if (car.getCustomerID() == 0) {
            deEdiatat.setCustomerID(car.getCustomerID());
        }
    }

    //functie care sa imi ret mas cu ac defectiune
    public Car findCarSameDescription(int id, String description) {
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            if (car.getId() == id && car.getDescription().equals(description)) {
                return car;
            }
        }
        return null;
    }
}
