package Controllers;

import java.util.ArrayList;
import java.util.List;

import Models.Product;
import ServiceLayer.productService;

public class productController {
    private List<Product> productList;
    private productService productService; // Add a reference to the service layer

    public productController() {
        productList = new ArrayList<>();
        productService = new productService(); // Initialize the service layer
    }

    public boolean addProduct(int prodID, int quantity, int userID, double costPrice, double sellPrice,
                              Double totalCost, Double totalRevenue, String prodCode, String prodName,
                              String date, String suppCode, String custCode)
    {
        Product product = new Product(prodID, quantity, userID, costPrice, sellPrice, totalCost, totalRevenue,
                prodCode, prodName, date, suppCode, custCode);

        // Call the service layer to add the product to the database
        boolean success = productService.addProduct(product);

        if (success) {
            // If the product is successfully added to the database, you might want to update your local list
            productList.add(product);
        }

        return success;
    }

    public Product updateProduct(int prodID, int newQuantity, int newUserID, double newCostPrice, double newSellPrice,
                                 Double newTotalCost, Double newTotalRevenue, String newProdCode, String newProdName,
                                 String newDate, String newSuppCode, String newCustCode) {
        // Call the service layer to update the product in the database
        boolean success = productService.updateProduct(prodID, newQuantity, newUserID, newCostPrice, newSellPrice,
                newTotalCost, newTotalRevenue, newProdCode, newProdName,
                newDate, newSuppCode, newCustCode);

        if (success) {
            // Return the updated product received from the service layer
            return productService.getProductById(prodID);
        } else {
            // Handle update failure (e.g., log error, show message to user)
            return null;
        }
    }

    public boolean deleteProduct(int prodID) {
        // Call the service layer to delete the product from the database
        boolean success = productService.deleteProduct(prodID);

        if (success) {
            // Remove the product from the local list if deletion was successful
            productList.removeIf(product -> product.getProdID() == prodID);
        }

        return success;
    }

    public List<Product> getProductList() {
        return productList;
    }
}
