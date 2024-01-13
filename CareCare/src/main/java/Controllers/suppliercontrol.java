package Controllers;

import Models.supplier;
import Views.supplierView.supplierview;

import java.util.ArrayList;
import java.util.List;

public class suppliercontrol {
    private List<supplier> supplierList;

    public suppliercontrol() {
        // Initialize the supplier list
        supplierList = new ArrayList<>();
    }

    public supplier addsupplier(int supplierID, String name, String address, String email, int phone_number) {
        supplier supplierobj = new supplier(supplierID, name, address, email, phone_number);
        supplierList.add(supplierobj);  // Add the new supplier to the list
        return supplierobj;
    }

    public supplier updateSupplier(int supplierID, String newName, String newAddress, String newEmail, int newPhoneNumber) {
        for (supplier i : supplierList) {
            if (i.getSupplierID() == supplierID) {
                i.setName(newName);
                i.setAddress(newAddress);
                i.setEmail(newEmail);
                i.setPhone_number(newPhoneNumber);
                return i;
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
}

