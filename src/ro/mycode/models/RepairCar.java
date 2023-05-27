package ro.mycode.models;

public class RepairCar extends Car{
    private boolean isRepaired;
    private int bill;

    public RepairCar(boolean isRepaired, int bill) {
        this.isRepaired = isRepaired;
        this.bill = bill;
    }

    public RepairCar(int id, String carNumber, String carType, String description, int customerID, boolean isRepaired, int bill) {
        super(id, carNumber, carType, description, customerID);
        this.isRepaired = isRepaired;
        this.bill = bill;
    }

    public RepairCar(int id, String carNumber, String carType, String description, boolean isRepaired, int bill) {
        super(id, carNumber, carType, description);
        this.isRepaired = isRepaired;
        this.bill = bill;
    }

    public boolean isRepaired() {
        return isRepaired;
    }

    public void setRepaired(boolean repaired) {
        isRepaired = repaired;
    }

    public int getBill() {
        return bill;
    }

    public void setBill(int bill) {
        this.bill = bill;
    }

@Override
    public String toString(){
        String text="";
        text+="Car-repaired:"+"\n";
        text+="Id:"+super.getId()+"\n";
        text+="Car Number:"+super.getCarNumber()+"\n";
        text+="Car Type:"+super.getCarType()+"\n";
        text+="Description:"+super.getDescription()+"\n";
        text+="Customer ID:"+super.getCustomerID()+"\n";
        text+="Is repaired? -> "+this.isRepaired+"\n";
        text+="Bill:"+this.bill;

        return text;
    }

@Override
    public String toSave(){
        return super.toSave()+","+isRepaired+","+bill;
    }
}
