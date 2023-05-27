package ro.mycode.controller;

import ro.mycode.models.Customer;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerController {

    private ArrayList<Customer> customers = new ArrayList();




    public CustomerController(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public CustomerController() {
        this.customers = new ArrayList();
        this.load();
    }


    public void load() {
        try {
            File file = new File("C:\\mycode\\OOP\\car-service-management\\src\\ro\\mycode\\data\\customer.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                Customer customer= new Customer(scanner.nextLine());
                this.customers.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void afisareCustomer() {
        for (int i = 0; i < customers.size(); i++) {
            System.out.println(this.customers.get(i).toString());
            System.out.println("\n");
        }
    }

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    public void removeCustomer(Customer customer) {
        this.customers.remove(customer);
    }


    public Customer findByName(String name) {
        for (int i = 0; i < this.customers.size(); i++) {
            if (customers.get(i).getName().equals(name)) {
                if (customers.get(i).getName().equals(name)) {
                    return customers.get(i);
                }
            }
        }
        return null;
    }

    public String toSave(){

        String text="";
        int i=0;
        for(i=0;i<customers.size()-1; i++){

            text+=customers.get(i).toSaveCustomer()+"\n";
        }

        text+=customers.get(i).toSaveCustomer();
        return text;
    }


    public void save(){
        try {
            File file = new File("C:\\mycode\\OOP\\car-service-management\\src\\ro\\mycode\\data\\customer.txt");

            FileWriter fileWriter= new FileWriter(file);

            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.print(toSave());

            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Customer findCustomer(String email, String password){
        for(int i=0; i<customers.size();i++){
            Customer customer=customers.get(i);
            if(customer.getEmail().equals(email)&&customer.getPassword().equals(password)){
                return customer;
            }
        }
        return null;
    }

    public boolean customerHavingCar(int id) {
        for (int i = 0; i < this.customers.size(); i++) {
            if (customers.get(i).getId() == id) {
                return true;
            }
        }
        return false;
    }


}
