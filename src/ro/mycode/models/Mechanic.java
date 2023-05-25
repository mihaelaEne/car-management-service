package ro.mycode.models;

public class Mechanic {
    private int id;
    private String name;
    private String email;
    private String password;

    public Mechanic(){}

    public Mechanic(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
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

    public String descriereMechanic() {
        String text="";
        text+="Mechanic properties:"+"\n";
        text+="Id:"+this.id+"\n";
        text+="Name:"+this.name+"\n";
        text+="Email:"+this.email+"\n";
        text+="Password:"+this.password;
        return text;
    }

    public Mechanic(String prop) {
        String[] split = prop.split(",");
        this.id = Integer.parseInt(split[0]);
        this.name = split[1];
        this.email = split[2];
        this.password = split[3];

    }


    public String toSaveMechanic() {
        return id + "," + name + "," +  email+","+password;
    }
}
