package Models;

public class Customer {
    private int empId;
    private String name;
    private String email;
    private String address;
    private int contact;
    private String service;

    public Customer(int empId, String name, String email, String address, int contact, String service) {
        this.empId = empId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.contact = contact;
        this.service = service;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
}

