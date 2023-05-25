package ro.mycode.controller;

import ro.mycode.models.Mechanic;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MechanicController {

    private ArrayList<Mechanic> mechanics;
    public MechanicController(ArrayList<Mechanic>mechanics){
        this.mechanics=mechanics;
    }

    public MechanicController(){
        this.mechanics=new ArrayList();
        this.load();
    }

    public void load(){
        try{
            File file=new File("C:\\mycode\\OOP\\car-service-management\\src\\ro\\mycode\\data\\mechanic.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                Mechanic mechanic=new Mechanic(scanner.nextLine());
                this.mechanics.add(mechanic);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }



    public void afisareMechanic(){
        for(int i=0; i< mechanics.size(); i++){
            System.out.println(this.mechanics.get(i).descriereMechanic());
            System.out.println("\n");
        }
    }


    public void addMechanic(Mechanic mechanic){
        this.mechanics.add(mechanic);
    }

    public void removeMechanic(Mechanic mechanic){
        this.mechanics.remove(mechanic);
    }


    public Mechanic findMechanicById(int id){
        for(int i=0; i<mechanics.size();i++){
            if(mechanics.get(i).getId()==id){
                return mechanics.get(i);
            }
        }
        return null;
    }

    public String toSave(){
        String text="";
        int i=0;
        for (i=0; i< mechanics.size()-1; i++){
            text+=mechanics.get(i).toSaveMechanic()+"\n";
        }
        text+=mechanics.get(i).toSaveMechanic();
        return text;
    }

    public void save(){
        try{
            File file=new File("C:\\mycode\\OOP\\car-service-management\\src\\ro\\mycode\\data\\mechanic.txt");
            FileWriter fileWriter=new FileWriter(file);
            PrintWriter printWriter=new PrintWriter(fileWriter);
            printWriter.print(toSave());
            printWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }




    public void editareMechanic(Mechanic mechanic){
        Mechanic deEdiatat=findMechanicById(mechanic.getId());
        if(mechanic.getEmail()!=null){
            deEdiatat.setEmail(mechanic.getEmail());
        }
        if(mechanic.getName()!=null){
            deEdiatat.setName(mechanic.getName());
        }
    }


    public Mechanic findMechanicConectare(String email, String password){
        for(int i=0; i<mechanics.size();i++){
            Mechanic mechanic=mechanics.get(i);
            if(mechanic.getEmail().equals(email)&&mechanic.getPassword().equals(password)){
                return mechanic;
            }
        }
        return null;
    }

}
