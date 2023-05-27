package ro.mycode.models;

public class Customer {
    private int id;
    private String name;
    private String mobile;
    private String address;
    private String email;
    private String password;
    private String username;

    public Customer() {
    }

    public Customer(int id, String name, String mobile, String address, String email, String password, String username) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.address = address;
        this.email = email;
        this.password = password;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
@Override
    public String toString() {
        String text="";
        text+="Customer properties:"+"\n";
        text+="Id:"+this.id+"\n";
        text+="Name:"+this.name+"\n";
        text+="Mobile:"+this.mobile+"\n";
        text+="Adress:"+this.address+"\n";
        text+="Email:"+this.email+"\n";
        text+="Password:"+this.password+"\n";
        text+="Username:"+this.username;
        return text;
    }

    public Customer(String prop) {
        String[] split = prop.split(",");
        this.id = Integer.parseInt(split[0]);
        this.name = split[1];
        this.mobile = split[2];
        this.address = split[3];
        this.email = split[4];
        this.password = split[5];
        this.username = split[6];

    }


    public String toSaveCustomer() {
        return id + "," + name + "," + mobile + "," + address + "," + email+","+password+","+username;
    }
}
