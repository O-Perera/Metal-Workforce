package ServiceLayer;

import DBlayer.dbconnection;
import Models.Product;

public class productService {
    private dbconnection singleConn;

    public CustomerService() {
        singleConn = dbconnection.getSingleInstance();
    }

    public boolean addProduct(Product product) {
        try {
            // Use a prepared statement to avoid SQL injection
            String query = "INSERT INTO products VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            System.out.println("Executing query: " + query);

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, product.getProdID());
                statement.setInt(2, product.getQuantity());
                statement.setInt(3, product.getUserID());
                statement.setDouble(4, product.getCostPrice());
                statement.setDouble(5, product.getSellPrice());
                statement.setDouble(6, (product.getTotalCost() != null) ? product.getTotalCost() : 0);
                statement.setDouble(7, (product.getTotalRevenue() != null) ? product.getTotalRevenue() : 0);
                statement.setString(8, product.getProdCode());
                statement.setString(9, product.getProdName());
                statement.setString(10, product.getDate());
                statement.setString(11, product.getSuppCode());
                statement.setString(12, product.getCustCode());

                int rowsAffected = statement.executeUpdate();

                System.out.println("Rows affected: " + rowsAffected);

                return rowsAffected > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error adding product to the database: " + ex.getMessage());
            return false;
        }
    }

    public boolean updateProduct(Product existingProduct) {
        try {
            // Use a prepared statement to avoid SQL injection
            String query = "UPDATE products SET quantity=?, costPrice=?, sellPrice=?, prodName=?, date=?, suppCode=?, custCode=? WHERE prodID=?";
            System.out.println("Executing query: " + query);

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, existingProduct.getQuantity());
                statement.setDouble(2, existingProduct.getCostPrice());
                statement.setDouble(3, existingProduct.getSellPrice());
                statement.setString(4, existingProduct.getProdName());
                statement.setString(5, existingProduct.getDate());
                statement.setString(6, existingProduct.getSuppCode());
                statement.setString(7, existingProduct.getCustCode());
                statement.setInt(8, existingProduct.getProdID());

                int rowsAffected = statement.executeUpdate();

                System.out.println("Rows affected: " + rowsAffected);

                return rowsAffected > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();


        }

    }


    public boolean deleteProduct(Product productToDelete) {
        try {
            // Use a prepared statement to avoid SQL injection
            String query = "DELETE FROM products WHERE prodID=?";
            System.out.println("Executing query: " + query);

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, productToDelete.getProdID());

                int rowsAffected = statement.executeUpdate();

                System.out.println("Rows affected: " + rowsAffected);

                return rowsAffected > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error deleting product from the database: " + ex.getMessage());
            return false;
        }
    }
}