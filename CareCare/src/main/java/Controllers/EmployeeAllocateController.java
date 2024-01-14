package Controllers;

import Views.AllocaterView.EmployeeAllocateUI;

public class EmployeeAllocateController {
    private EmployeeAllocateUI view;

    public EmployeeAllocateController(EmployeeAllocateUI view) {
        this.view = view;

        // Add any additional initialization or logic for the controller
    }

    public void handleEmployeeAllocation(String selectedEmployee, String selectedJob, String enteredName, String enteredEmail) {
        // Your logic for handling employee allocation goes here
        // You can use the received parameters as needed

        // Example: Print the values (replace this with your actual logic)
        System.out.println("Selected Employee: " + selectedEmployee);
        System.out.println("Selected Job: " + selectedJob);
        System.out.println("Entered Name: " + enteredName);
        System.out.println("Entered Email: " + enteredEmail);
    }

    // Add controller logic as needed
}



//package Controllers;



//
//import Views.AllocaterView.EmployeeAllocateUI;
//
//public class EmployeeAllocateController {
//    private EmployeeAllocateUI view;
//
//    public EmployeeAllocateController() {
//        this.view = view;
//
//        // Add any additional initialization or logic for the controller
//    }
//
//    public void handleEmployeeAllocation(String selectedEmployee, String selectedJob) {
//        // Your logic for handling employee allocation goes here
//    }
//
//    // Add controller logic as needed
//}
