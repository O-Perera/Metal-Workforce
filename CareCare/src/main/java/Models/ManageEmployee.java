package Models;

public class ManageEmployee {
    private int employeeID;
    private String name;

    private String address;

    private String email;

    private String position;

    // Constructors


    public ManageEmployee(int employeeID, String name, String address, String email, String position) {
        this.employeeID = employeeID;
        this.name = name;
        this.address = address;
        this.email = email;
        this.position = position;
    }
    public ManageEmployee(){
        this.employeeID = 0;

    }

    // Getter and Setter methods for employeeID


    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    // Getter and Setter methods for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter methods for position
    public String getPosition() {
        return position;
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

    public void setPosition(String position) {
        this.position = position;
    }

    // Additional methods or logic can be added based on your requirements
}
