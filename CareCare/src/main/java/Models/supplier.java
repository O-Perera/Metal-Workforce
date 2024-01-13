package Models;

public class supplier {
    private int supplierID;
    private String name;
    private String address;
    private String email;
    private int phone_number;


    private String newName;
    private String   newAddress;
    private String newEmail;
    private int newPhoneNumber;

    public supplier(String newName, String newAddress, String newEmail, int newPhoneNumber) {
        this.newName = newName;
        this.newAddress = newAddress;
        this.newEmail = newEmail;
        this.newPhoneNumber = newPhoneNumber;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public supplier(int supplierID, String name, String address, String email, int phone_number) {
        this.supplierID = supplierID;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone_number = phone_number;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getNewAddress() {
        return newAddress;
    }

    public void setNewAddress(String newAddress) {
        this.newAddress = newAddress;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }

    public int getNewPhoneNumber() {
        return newPhoneNumber;
    }

    public void setNewPhoneNumber(int newPhoneNumber) {
        this.newPhoneNumber = newPhoneNumber;
    }

    //to add supplier
    public String toString() {
        return "supplier {" + "SupplierID= " + supplierID + "/" + "SupplierID= " + supplierID + "/" + "Name= " + name + "/" + "Address= " + address + "/" + "Email= " + email + "/" + "Phone Number= " + phone_number + "/";

    }
}


