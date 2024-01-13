package ServiceLayer;

import Models.supplier;
import DBlayer.dbconnection;

import java.sql.PreparedStatement;

public class SupplierService {
    private dbconnection singleConn;

    public SupplierService() {
        singleConn = dbconnection.getSingleInstance();

        if (singleConn == null) {
            // Handle the case when the database connection is null
            System.out.println("Database connection is null.");
            // You may throw an exception, log an error, or take appropriate action here.
        }
    }


    public boolean addSupplier(supplier Supplier) {
        try {
            // Use a prepared statement to avoid SQL injection
            String query = "INSERT INTO supplier VALUES (?, ?, ?, ?, ?)";
            System.out.println("Executing query: " + query);

            try (PreparedStatement statement = singleConn.getConnection().prepareStatement(query)) {
                statement.setInt(1, Supplier.getSupplierID());
                statement.setString(2, Supplier.getName());
                statement.setString(3, Supplier.getAddress());
                statement.setString(4, Supplier.getEmail());
                statement.setInt(5, Supplier.getPhone_number());

                int rowsAffected = statement.executeUpdate();

                System.out.println("Rows affected: " + rowsAffected);

                return rowsAffected > 0;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error adding supplier to the database: " + ex.getMessage());
            return false;
        }
    }




    public boolean updateSupplier(int supplierID, String newName, String newAddress, String newEmail, int newPhoneNumber) {
        try {
            // Use a prepared statement to avoid SQL injection
            String query = "UPDATE supplier SET name=?, address=?, email=?, phone_number=? WHERE supplierID=?";

            try (PreparedStatement statement = singleConn.getConnection().prepareStatement(query)) {
                statement.setString(1, newName);
                statement.setString(2, newAddress);
                statement.setString(3, newEmail);
                statement.setInt(4, newPhoneNumber);
                statement.setInt(5, supplierID);

                int rowsAffected = statement.executeUpdate();

                return rowsAffected > 0;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Cannot update supplier");
            return false;
        }
    }
}

