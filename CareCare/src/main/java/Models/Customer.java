package Models;

public class Customer {
    private int empId;
    private String name;
    private String email;
    private String address;
    private int contact;
    private String service;

    private int orderId;

    public Customer(int empId, String name, String email, String address, int contact, String service, int orderId) {
        this.empId = empId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.contact = contact;
        this.service = service;
        this.orderId = orderId;
    }

    public Customer(){
        this.empId = 0;
        this.name = null;
        this.email = null;
        this.address = null;
        this.contact = 0;
        this.service = null;
        this.orderId = 0;
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

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}

