package Controllers;

import Models.Customer;
import org.checkerframework.checker.units.qual.C;

import java.util.ArrayList;

public class CustomerController {

    public Customer customerNew(int empId, String name, String email,String address,int contact, String service){
        Customer updateObj =new Customer();
        return updateObj;
    }

    public Customer customerDelete(int orderID){
        Customer deleteObj = new Customer();
        return deleteObj;
    }

}
