//package ServiceLayer;
//
//import DBlayer.dbconnection;
//import Models.ManageEmployee;
//
//import java.sql.PreparedStatement;
//
//public class EmployeeService {
//    private dbconnection singleConn;
//
//    public EmployeeService() {
//        singleConn = dbconnection.getSingleInstance();
//    }
//
//    public boolean addEmployee(ManageEmployee employee) {
//        try {
//            String addQuery = "INSERT INTO employee (empID, name, address, email, position) VALUES (?, ?, ?, ?, ?)";
//            PreparedStatement preparedStatement = singleConn.getPreparedStatement(addQuery);
//
//            preparedStatement.setInt(1, employee.getEmpId());
//            preparedStatement.setString(2, employee.getName());
//            preparedStatement.setString(3, employee.getAddress());
//            preparedStatement.setString(4, employee.getEmail());
//            preparedStatement.setString(5, employee.getPosition());
//
//            boolean result = singleConn.ExecutePreparedStatement(preparedStatement);
//            return result;
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            System.out.println("Cannot insert an Employee");
//            return false;
//        }
//    }
//
////    public boolean updateCustomer(Customer customer){
////        try{
////            String updateQuery = "update orders set empID = "+customer.getEmpId()+" , Name = '"+customer.getName()+"', Email = '"+customer.getEmail()+"', Address ='"+customer.getAddress()+"',Contact="+customer.getContact()+", Service = '"+customer.getService()+"' WHERE orderID="+customer.getOrderId()+" ";
////            boolean result= singleConn.ExecuteQuery(updateQuery);
////            return result;
////
////        }catch (Exception ex){
////            System.out.println("Cannot update a Customer");
////            return false;
////
////        }
////    }
////
////    public boolean deleteCustomer(Customer customer){
////        try{
////            String deleteQuery = "DELETE FROM orders WHERE orderID="+customer.getOrderId()+"";
////            boolean result= singleConn.ExecuteQuery(deleteQuery);
////            return result;
////
////        }catch (Exception ex){
////            System.out.println("Cannot delete a Customer");
////            return false;
////
////        }
////    }
//
//
//}
