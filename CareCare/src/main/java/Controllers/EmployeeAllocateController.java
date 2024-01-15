package Controllers;

import Views.AllocaterView.EmployeeAllocateUI;

public class EmployeeAllocateController {
    private EmployeeAllocateUI view;

    // Parameterized constructor that accepts an EmployeeAllocateUI instance
    public EmployeeAllocateController() {
        this.view = view;

        // Add any additional initialization or logic for the controller
    }

    // Method to handle employee allocation with name and email
    public void handleEmployeeAllocation(String selectedEmployee, String selectedJob, String enteredName, String enteredEmail) {
        // Your logic for handling employee allocation goes here
        // You can use the received parameters as needed

        // Example: Print the values (replace this with your actual logic)
        System.out.println("Selected Employee: " + selectedEmployee);
        System.out.println("Selected Job: " + selectedJob);
        System.out.println("Entered Name: " + enteredName);
        System.out.println("Entered Email: " + enteredEmail);
    }

    // Method to handle employee allocation without name and email
    public void handleEmployeeAllocation(String selectedEmployee, String selectedJob) {
        // Your logic for handling employee allocation goes here
        // This version is for cases where name and email are not required
        // Example: Print the values (replace this with your actual logic)
        System.out.println("Selected Employee: " + selectedEmployee);
        System.out.println("Selected Job: " + selectedJob);
    }

    // Add any additional methods or logic as needed
}
