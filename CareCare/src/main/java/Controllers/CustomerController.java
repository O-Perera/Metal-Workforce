package Controllers;

import Models.Customer;
import ServiceLayer.CustomerService;
import org.checkerframework.checker.units.qual.C;

import java.util.ArrayList;

public class CustomerController {


    CustomerService service;

    public CustomerController(){
        service = new CustomerService();
    }

    public Customer customerAdd(int empId, String name, String email,String address,int contact, String service){
        Customer addObj =new Customer();
        addObj.setEmpId(empId);
        addObj.setName(name);
        addObj.setEmail(email);
        addObj.setAddress(address);
        addObj.setContact(contact);
        addObj.setService(service);
        return addObj;
    }

    public Customer customerUpdate(int empId, String name, String email,String address,int contact, String service,int orderId){
        Customer updateObj =new Customer();
        updateObj.setEmpId(empId);
        updateObj.setName(name);
        updateObj.setEmail(email);
        updateObj.setAddress(address);
        updateObj.setContact(contact);
        updateObj.setService(service);
        updateObj.setOrderId(orderId);
        return updateObj;
    }

    public Customer customerDelete(int orderID){
        Customer deleteObj = new Customer();
        deleteObj.setOrderId(orderID);
        return deleteObj;
    }

    public boolean addCustomerToDatabase(Customer customer){
        return  service.addCustomer(customer);
    }

    public boolean UpdateCustomerInDatabase(Customer customer){
        return  service.updateCustomer(customer);
    }

    public boolean deleteCustomerFromDatabase(Customer customer){

        return  service.deleteCustomer(customer);
    }

}
