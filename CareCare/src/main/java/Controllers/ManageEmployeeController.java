package Controllers.ManageEmployeeView;

import Models.ManageEmployee;
import Views.ManageEmployeeView.ManageEmployeeView;

public class ManageEmployeeController {
    private ManageEmployeeView view;

    public ManageEmployeeController() {
        this.view = view;

        // Add any additional initialization or logic for the controller
    }

    public void addEmployee(String employeeID, String name, String position) {
        // Create a ManageEmployee object
        ManageEmployee employee = new ManageEmployee(employeeID, name, position);

        // Add logic to save the employee to the database or perform any necessary operations
        // You might want to use a DAO class for database operations
    }

    // Add controller logic as needed
}
