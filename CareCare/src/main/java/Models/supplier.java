package Models;

public class supplier {
    private int supplierID;
    private String name;
    private String address;
    private String email;
    private int phone_number;

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

    //to add supplier
    public String toString() {
        return "supplier {" + "SupplierID= " + supplierID + "/" + "SupplierID= " + supplierID + "/" + "Name= " + name + "/" + "Address= " + address + "/" + "Email= " + email + "/" + "Phone Number= " + phone_number + "/";

    }
}


