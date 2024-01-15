package ServiceLayer;

import DBlayer.dbconnection;
import Models.supplier;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
            String query = "UPDATE supplier SET name=?, address=?, email=?, phone_number=? WHERE supplierID=?";
            System.out.println("Executing query: " + query);

            try (PreparedStatement statement = singleConn.getConnection().prepareStatement(query)) {
                statement.setString(1, newName);
                statement.setString(2, newAddress);
                statement.setString(3, newEmail);
                statement.setInt(4, newPhoneNumber);
                statement.setInt(5, supplierID);

                int rowsAffected = statement.executeUpdate();

                System.out.println("Rows affected: " + rowsAffected);

                return rowsAffected > 0;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Cannot update supplier");
            return false;
        }
    }

    public supplier getSupplierById(int supplierID) {
        try {
            String query = "SELECT * FROM supplier WHERE supplierID=?";
            System.out.println("Executing query: " + query);

            try (PreparedStatement statement = singleConn.getConnection().prepareStatement(query)) {
                statement.setInt(1, supplierID);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        int retrievedSupplierID = resultSet.getInt("supplierID");
                        String name = resultSet.getString("name");
                        String address = resultSet.getString("address");
                        String email = resultSet.getString("email");
                        int phone_number = resultSet.getInt("phone_number");

                        return new supplier(retrievedSupplierID, name, address, email, phone_number);
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error getting supplier by ID");
        }

        return null;
    }

    public boolean deleteSupplier(int supplierID) {
        try {
            String query = "DELETE FROM supplier WHERE supplierID=?";
            System.out.println("Executing query: " + query);

            try (PreparedStatement statement = singleConn.getConnection().prepareStatement(query)) {
                statement.setInt(1, supplierID);

                int rowsAffected = statement.executeUpdate();

                System.out.println("Rows affected: " + rowsAffected);

                return rowsAffected > 0;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Cannot delete supplier");
            return false;
        }
    }
}
