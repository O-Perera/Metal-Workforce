package Views.ManageEmployeeView;

import Controllers.ManageEmployeeController;
import Models.ManageEmployee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageEmployeeView extends JFrame {
    private ManageEmployeeController controller;

    private JTextField txtEmployeeID;
    private JTextField txtName;
    private JTextField txtPosition;
    private JButton btnAddEmployee;

    public ManageEmployeeView(ManageEmployeeController controller) {
        this.controller = controller;
        setTitle("Manage Employees");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize components
        txtEmployeeID = new JTextField();
        txtName = new JTextField();
        txtPosition = new JTextField();
        btnAddEmployee = new JButton("Add Employee");

        // Set layout
        setLayout(new GridLayout(4, 2));

        // Add components to the frame
        add(new JLabel("Employee ID:"));
        add(txtEmployeeID);
        add(new JLabel("Name:"));
        add(txtName);
        add(new JLabel("Position:"));
        add(txtPosition);
        add(new JLabel()); // Empty label for spacing
        add(btnAddEmployee);

        // Add action listener to the 'Add Employee' button
        btnAddEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEmployee();
            }
        });
    }

    private void addEmployee() {
        String employeeID = txtEmployeeID.getText();
        String name = txtName.getText();
        String position = txtPosition.getText();

        // Call the controller method to add the employee
        controller.addEmployee(employeeID, name, position);

        // You can add additional logic here if needed
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Instantiate the controller
                ManageEmployeeController controller = new ManageEmployeeController();

                // Instantiate the UI and pass the controller instance to it
                ManageEmployeeView manageEmployeeView = new ManageEmployeeView(controller);

                // Set the UI visible
                manageEmployeeView.setVisible(true);
            }
        });
    }
}
