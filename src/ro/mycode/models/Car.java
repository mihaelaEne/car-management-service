package ro.mycode.models;

public class Car {
    private int id;
    private String carNumber;
    private String carType;
    private String description;
    private int customerID;

    public Car (){}
    public Car(int id, String carNumber, String carType, String description, int customerID) {
        this.id = id;
        this.carNumber = carNumber;
        this.carType = carType;
        this.description = description;
        this.customerID = customerID;
    }

    public Car(int id, String carNumber, String carType, String description) {
        this.id = id;
        this.carNumber = carNumber;
        this.carType = carType;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }


    public String descriereCar() {
        String text="";
        text+="Car properties:"+"\n";
        text+="Id:"+this.id+"\n";
        text+="Car Number:"+this.carNumber+"\n";
        text+="Car Type:"+this.carType+"\n";
        text+="Description:"+this.description+"\n";
        text+="Customer ID:"+this.customerID;
        return text;
    }

    public Car(String prop) {
        String[] split = prop.split(",");
        this.id = Integer.parseInt(split[0]);
        this.carNumber = split[1];
        this.carType = split[2];
        this.description = split[3];
        this.customerID = Integer.parseInt(split[4]);
    }


    public String toSaveCar() {
        return id + "," + carNumber + "," + carType + "," + description + "," + customerID;
    }

}
