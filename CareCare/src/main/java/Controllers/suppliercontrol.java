package Controllers;

import Models.supplier;
import ServiceLayer.SupplierService;

import java.util.ArrayList;
import java.util.List;

public class suppliercontrol {
    private List<supplier> supplierList;
    private SupplierService supplierService; // Add a reference to the service layer

    public suppliercontrol() {
        supplierList = new ArrayList<>();
        supplierService = new SupplierService(); // Initialize the service layer
    }

    public boolean addsupplier(int supplierID, String name, String address, String email, int phone_number) {
        supplier supplierobj = new supplier(supplierID, name, address, email, phone_number);

        // Call the service layer to add the supplier to the database
        boolean success = supplierService.addSupplier(supplierobj);

        if (success) {
            // If the supplier is successfully added to the database, you might want to update your local list
            supplierList.add(supplierobj);
        }

        return success;
    }

    public supplier updateSupplier(int supplierID, String newName, String newAddress, String newEmail, int newPhoneNumber) {
        // Call the service layer to update the supplier in the database
        boolean success = supplierService.updateSupplier(supplierID, newName, newAddress, newEmail, newPhoneNumber);

        if (success) {
            // Return the updated supplier received from the service layer
            return supplierService.getSupplierById(supplierID);
        } else {
            // Handle update failure (e.g., log error, show message to user)
            return null;
        }
    }

    public boolean supplierDelete(int supplierID) {
        // Call the service layer to delete the supplier from the database
        boolean success = supplierService.deleteSupplier(supplierID);

        if (success) {
            // Remove the supplier from the local list if deletion was successful
            supplierList.removeIf(supplier -> supplier.getSupplierID() == supplierID);
        }

        return success;
    }

    public List<supplier> getSupplierList() {
        return supplierList;
    }

    public static void main(String[] args) {
        // Example usage
        suppliercontrol controller = new suppliercontrol();

        // Adding a new supplier
        boolean newSupplier = controller.addsupplier(1, "Supplier1", "Address1", "supplier1@example.com", 123456789);

        // Updating a supplier
        supplier updatedSupplier = controller.updateSupplier(1, "NewName", "NewAddress", "newemail@example.com", 987654321);

        // Displaying the updated supplier list
        List<supplier> updatedList = controller.getSupplierList();
        for (supplier s : updatedList) {
            System.out.println(s);
        }

        // Deleting a supplier
        boolean deleteSuccess = controller.supplierDelete(1);
        if (deleteSuccess) {
            System.out.println("Supplier deleted successfully.");
        } else {
            System.out.println("Failed to delete supplier.");
        }
    }
}
