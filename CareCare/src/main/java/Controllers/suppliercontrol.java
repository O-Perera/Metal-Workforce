package Controllers;

import Models.Customer;
import Models.supplier;
import ServiceLayer.SupplierService;
import Views.supplierView.supplierview;

import java.util.ArrayList;
import java.util.List;

public class suppliercontrol {
    private List<supplier> supplierList;
    private SupplierService supplierService; // Add a reference to the service layer

    public suppliercontrol() {
        supplierList = new ArrayList<>();
        supplierService = new SupplierService(); // Initialize the service layer
    }

    public supplier addsupplier(int supplierID, String name, String address, String email, int phone_number) {
        supplier supplierobj = new supplier(supplierID, name, address, email, phone_number);
        //supplierList.add(supplierobj);  // Add the new supplier to the list
        return supplierobj;
    }


    public supplier updateSupplier(int supplierID, String newName, String newAddress, String newEmail, int newPhoneNumber) {
        // Assuming supplierList is used for temporary storage and not directly updating the database
        for (supplier s : supplierList) {
            if (s.getSupplierID() == supplierID) {
                s.setName(newName);
                s.setAddress(newAddress);
                s.setEmail(newEmail);
                s.setPhone_number(newPhoneNumber);
                boolean success = supplierService.updateSupplier(supplierID, newName, newAddress, newEmail, newPhoneNumber);

                if (success) {
                    return s; // Return the updated supplier
                } else {
                    // Handle update failure (e.g., log error, show message to user)
                    return null;
                }
            }
        }
        return null;  // Return null if the supplier with the specified ID was not found
    }


    public List<supplier> getSupplierList() {
        return supplierList;
    }

    public static void main(String[] args) {
        // Example usage
        suppliercontrol controller = new suppliercontrol();

        // Adding a new supplier
        supplier newSupplier = controller.addsupplier(1, "Supplier1", "Address1", "supplier1@example.com", 123456789);

        // Updating a supplier
        supplier updatedSupplier = controller.updateSupplier(1, "NewName", "NewAddress", "newemail@example.com", 987654321);

        // Displaying the updated supplier list
        List<supplier> updatedList = controller.getSupplierList();
        for (supplier s : updatedList) {
            System.out.println(s);
        }
    }
    public supplier supplierDelete(int supplier){
        supplier supplierobj  = new supplier();
        return supplierobj ;
    }
}

