package ServiceLayer;

import DBlayer.dbconnection;
import Models.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class productService {
    private dbconnection singleConn;

    public productService() {
        singleConn = dbconnection.getSingleInstance();
    }

    public boolean addProduct(Product product) {
        try {

            String query = "INSERT INTO products VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            System.out.println("Executing query: " + query);

            try (PreparedStatement statement = singleConn.getConnection().prepareStatement(query)) {
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

    public boolean updateProduct(int prodID, int newQuantity, int newUserID, double newCostPrice, double newSellPrice,
                                 Double newTotalCost, Double newTotalRevenue, String newProdCode, String newProdName,
                                 String newDate, String newSuppCode, String newCustCode) {
        try {

            String query = "UPDATE products SET quantity=?, costPrice=?, sellPrice=?, prodName=?, date=?, suppCode=?, custCode=? WHERE prodID=?";
            System.out.println("Executing query: " + query);

            try (PreparedStatement statement = singleConn.getConnection().prepareStatement(query)) {
                statement.setInt(1, newQuantity);
                statement.setDouble(2, newCostPrice);
                statement.setDouble(3, newSellPrice);
                statement.setString(4,newProdName);
                statement.setString(5,newDate);
                statement.setString(6, newSuppCode);
                statement.setString(7, newCustCode);
                statement.setInt(8, prodID);

                int rowsAffected = statement.executeUpdate();

                System.out.println("Rows affected: " + rowsAffected);

                return rowsAffected > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;

        }

    }


    public boolean deleteProduct(int productToDelete) {
        try {

            String query = "DELETE FROM products WHERE prodID=?";
            System.out.println("Executing query: " + query);

            try (PreparedStatement statement = singleConn.getConnection().prepareStatement(query))  {
                statement.setInt(1, productToDelete);

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

    public Product getProductById(int prodID) {
        try {
            String query = "SELECT * FROM products WHERE prodID=?";
            System.out.println("Executing query: " + query);

            try (PreparedStatement statement = singleConn.getConnection().prepareStatement(query)) {
                statement.setInt(1, prodID);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        int retrievedProdID = resultSet.getInt("prodID");
                        int quantity = resultSet.getInt("quantity");
                        int userID = resultSet.getInt("userID");
                        double costPrice = resultSet.getDouble("costPrice");
                        double sellPrice = resultSet.getDouble("sellPrice");
                        Double totalCost = resultSet.getDouble("totalCost");
                        Double totalRevenue = resultSet.getDouble("totalRevenue");
                        String prodCode = resultSet.getString("prodCode");
                        String prodName = resultSet.getString("prodName");
                        String date = resultSet.getString("date");
                        String suppCode = resultSet.getString("suppCode");
                        String custCode = resultSet.getString("custCode");

                        return new Product(retrievedProdID, quantity, userID, costPrice, sellPrice,
                                totalCost, totalRevenue, prodCode, prodName, date, suppCode, custCode);
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error getting product by ID");
        }

        return null;
    }


    public List<Product> viewAllProducts() {
        List<Product> productList = new ArrayList<>();

        try {
            String query = "SELECT * FROM products";
            System.out.println("Executing query: " + query);

            try (PreparedStatement statement = singleConn.getConnection().prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    int prodID = resultSet.getInt("prodID");
                    int quantity = resultSet.getInt("quantity");
                    int userID = resultSet.getInt("userID");
                    double costPrice = resultSet.getDouble("costPrice");
                    double sellPrice = resultSet.getDouble("sellPrice");
                    Double totalCost = resultSet.getDouble("totalCost");
                    Double totalRevenue = resultSet.getDouble("totalRevenue");
                    String prodCode = resultSet.getString("prodCode");
                    String prodName = resultSet.getString("prodName");
                    String date = resultSet.getString("date");
                    String suppCode = resultSet.getString("suppCode");
                    String custCode = resultSet.getString("custCode");

                    Product product = new Product(prodID, quantity, userID, costPrice, sellPrice,
                            totalCost, totalRevenue, prodCode, prodName, date, suppCode, custCode);

                    productList.add(product);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error getting all products");
        }

        return productList;
    }



}




