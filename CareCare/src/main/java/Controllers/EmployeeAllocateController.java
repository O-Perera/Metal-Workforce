package Controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeAllocateController {

    // Method to get employee name by ID from the database
    public String getEmployeeNameById(String employeeID) {
        String employeeName = null;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CareCare", "root", "");
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT empname FROM emptable WHERE empId = ?")) {

            preparedStatement.setString(1, employeeID);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    employeeName = resultSet.getString("empname");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions more gracefully, consider logging
        }

        return employeeName;
    }

    // Method to handle employee allocation with name and email
    public void handleEmployeeAllocation(String selectedEmployee, String selectedJob, String enteredName, String enteredEmail) {
        // Get the employee name using the method we added
        String employeeName = getEmployeeNameById(selectedEmployee);

        // Your logic for handling employee allocation goes here
        // You can use the received parameters, including employeeName, as needed

        // Example: Print the values (replace this with your actual logic)
        System.out.println("Selected Employee: " + selectedEmployee);
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Selected Job: " + selectedJob);
        System.out.println("Entered Name: " + enteredName);
        System.out.println("Entered Email: " + enteredEmail);
    }

    // Method to handle employee allocation without name and email
    public void handleEmployeeAllocation(String selectedEmployee, String selectedJob) {
        // Get the employee name using the method we added
        String employeeName = getEmployeeNameById(selectedEmployee);

        // Your logic for handling employee allocation goes here
        // This version is for cases where name and email are not required
        // Example: Print the values (replace this with your actual logic)
        System.out.println("Selected Employee: " + selectedEmployee);
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Selected Job: " + selectedJob);
    }

    // Add any additional methods or logic as needed
}
