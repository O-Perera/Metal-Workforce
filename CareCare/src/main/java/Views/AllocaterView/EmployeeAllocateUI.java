package Views.AllocaterView;

import Controllers.EmployeeAllocateController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeAllocateUI extends JFrame {
    private EmployeeAllocateController controller;

    private JPanel panel1;
    private JLabel empid;
    private JLabel orderid;

    private JTextField txtempid;
    private JTextField txtorderid;

    private JButton allocate;

    // Parameterized constructor that accepts an EmployeeAllocateController instance
    public EmployeeAllocateUI(EmployeeAllocateController controller) {
        this.controller = controller;
        setTitle("Employee Allocation");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize components
        panel1 = new JPanel();
        empid = new JLabel("Employee ID:");
        orderid = new JLabel("Order ID:");
        txtempid = new JTextField();
        txtorderid = new JTextField();
        allocate = new JButton("Allocate");

        // Set layout for the panel
        panel1.setLayout(new GridLayout(3, 2));

        // Add components to the panel
        panel1.add(empid);
        panel1.add(txtempid);
        panel1.add(orderid);
        panel1.add(txtorderid);
        panel1.add(new JLabel()); // Empty label for spacing
        panel1.add(allocate);

        // Add action listener to the allocate button
        allocate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allocateEmployeeToJob();
            }
        });

        // Add the panel to the frame
        add(panel1);
    }

    private void allocateEmployeeToJob() {
        String employeeID = txtempid.getText();
        String orderID = txtorderid.getText();

        // Call the controller method to handle the allocation logic with both values
        controller.handleEmployeeAllocation(employeeID, orderID);

        // You can add additional logic here if needed
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Instantiate the controller
                EmployeeAllocateController controller = new EmployeeAllocateController();

                // Instantiate the UI and pass the controller instance to it
                EmployeeAllocateUI employeeAllocateUI = new EmployeeAllocateUI(controller);

                // Set the UI visible
                employeeAllocateUI.setVisible(true);
            }
        });
    }
}
