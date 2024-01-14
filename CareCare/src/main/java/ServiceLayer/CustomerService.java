package ServiceLayer;

import DBlayer.dbconnection;
import Models.Customer;

public class CustomerService {
    private dbconnection singleConn;
    public CustomerService(){
        singleConn = dbconnection.getSingleInstance();
    }

    public boolean addCustomer(Customer customer){
        try{
            String addQuery = "insert into order values("+customer.getEmpId()+",'"+customer.getName()+"','"+customer.getEmail()+"','"+customer.getAddress()+"',"+customer.getContact()+",'"+customer.getService()+"')";
            boolean result= singleConn.ExecuteQuery(addQuery);
            return result;

        }catch (Exception ex){
            System.out.println("Cannot insert a Customer");
            return false;

        }
    }

    public boolean updateCustomer(Customer customer){
        try{
            String updateQuery = "UPDATE order set empId = "+customer.getEmpId()+" , name = '"+customer.getName()+"', email = '"+customer.getEmail()+"', address ='"+customer.getAddress()+"',contact="+customer.getContact()+", service = '"+customer.getService()+"' WHERE orderid="+customer.getOrderId()+")";
            boolean result= singleConn.ExecuteQuery(updateQuery);
            return result;

        }catch (Exception ex){
            System.out.println("Cannot update a Customer");
            return false;

        }
    }

    public boolean deleteCustomer(Customer customer){
        try{
            String deleteQuery = "DELETE FROM order WHERE orderid="+customer.getOrderId()+")";
            boolean result= singleConn.ExecuteQuery(deleteQuery);
            return result;

        }catch (Exception ex){
            System.out.println("Cannot delete a Customer");
            return false;

        }
    }


}
