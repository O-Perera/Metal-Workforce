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
            String addQuery = "insert into orders (empID,Name,Email,Address,Contact,Service) values("+customer.getEmpId()+",'"+customer.getName()+"','"+customer.getEmail()+"','"+customer.getAddress()+"',"+customer.getContact()+",'"+customer.getService()+"')";
            boolean result= singleConn.ExecuteQuery(addQuery);
            return result;

        }catch (Exception ex){
            System.out.println("Cannot insert a Customer");
            return false;

        }
    }

    public boolean updateCustomer(Customer customer){
        try{
            String updateQuery = "update orders set empID = "+customer.getEmpId()+" , Name = '"+customer.getName()+"', Email = '"+customer.getEmail()+"', Address ='"+customer.getAddress()+"',Contact="+customer.getContact()+", Service = '"+customer.getService()+"' WHERE orderID="+customer.getOrderId()+" ";
            boolean result= singleConn.ExecuteQuery(updateQuery);
            return result;

        }catch (Exception ex){
            System.out.println("Cannot update a Customer");
            return false;

        }
    }

    public boolean deleteCustomer(Customer customer){
        try{
            String deleteQuery = "DELETE FROM orders WHERE orderID="+customer.getOrderId()+"";
            boolean result= singleConn.ExecuteQuery(deleteQuery);
            return result;

        }catch (Exception ex){
            System.out.println("Cannot delete a Customer");
            return false;

        }
    }


}
