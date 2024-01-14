package Controllers;

import Models.Customer;
import ServiceLayer.CustomerService;
import org.checkerframework.checker.units.qual.C;

import java.util.ArrayList;

public class CustomerController {

    Customer customerobj;

    CustomerService service;

    public CustomerController(){
        service = new CustomerService();
    }

    public Customer customerAdd(int empId, String name, String email,String address,int contact, String service){
        Customer updateObj =new Customer();
        return updateObj;
    }

    public Customer customerUpdate(int empId, String name, String email,String address,int contact, String service,int orderId){
        Customer updateObj =new Customer();
        return updateObj;
    }

    public Customer customerDelete(int orderID){
        Customer deleteObj = new Customer();
        return deleteObj;
    }

    public boolean addCustomerToDatabase(){
        return  service.addCustomer(customerobj);
    }

    public boolean UpdateCustomerInDatabase(){
        return  service.updateCustomer(customerobj);
    }

    public boolean deleteCustomerFromDatabase(){
        return  service.deleteCustomer(customerobj);
    }

}
