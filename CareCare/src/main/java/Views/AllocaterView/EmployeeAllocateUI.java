package Views.AllocaterView;

import Controllers.EmployeeAllocateController;
import Controllers.GmailerEmployeeController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeAllocateUI extends JFrame {
    private EmployeeAllocateController controller;
    private GmailerEmployeeController emailController;

    public JPanel panelemp;
    private JLabel empid;
    private JLabel orderid;

    private JTextField txtempid;
    private JTextField txtorderid;

    private JButton allocate;

    // Parameterized constructor that accepts instances of controllers
    public EmployeeAllocateUI(EmployeeAllocateController controller, GmailerEmployeeController emailController) {
        this.controller = controller;
        this.emailController = emailController;

        setTitle("Employee Allocation");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize components
        panelemp = new JPanel();
        empid = new JLabel("Employee ID:");
        orderid = new JLabel("Order ID:");
        txtempid = new JTextField();
        txtorderid = new JTextField();
        allocate = new JButton("Allocate");

        // Set layout for the panel
        panelemp.setLayout(new GridLayout(3, 2));

        // Add components to the panel
        panelemp.add(empid);
        panelemp.add(txtempid);
        panelemp.add(orderid);
        panelemp.add(txtorderid);
        panelemp.add(new JLabel()); // Empty label for spacing
        panelemp.add(allocate);

        // Add action listener to the allocate button
        allocate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform actions when the 'Allocate' button is clicked
                // You can call the allocateEmployeeToJob method or add specific logic here
                allocateEmployeeToJob();

                // Show a success message
                JOptionPane.showMessageDialog(EmployeeAllocateUI.this,
                        "Employee ID and Order ID added successfully",
                        "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        });


        // Add the panel to the frame

        add(panelemp);
        txtempid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Try to parse the content of txtempid to an integer
                    int employeeID = Integer.parseInt(txtempid.getText());

                    // If successful, you can proceed with your logic
                    // For example, you can display a success message
                    System.out.println("Employee ID is an integer: " + employeeID);
                } catch (NumberFormatException ex) {
                    // If an exception occurs, the content is not an integer
                    // Display an error message
                    JOptionPane.showMessageDialog(EmployeeAllocateUI.this,
                            "Check your Employee ID. It should be an integer.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        txtorderid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Try to parse the content of txtorderid to an integer
                    int orderID = Integer.parseInt(txtorderid.getText());

                    // If successful, you can proceed with your logic
                    // For example, you can display a success message
                    System.out.println("Order ID is an integer: " + orderID);
                } catch (NumberFormatException ex) {
                    // If an exception occurs, the content is not an integer
                    // Display an error message
                    JOptionPane.showMessageDialog(EmployeeAllocateUI.this,
                            "Check your Order ID. It should be an integer.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        add(panelemp);
    }

    public EmployeeAllocateUI() {


    }

    private void allocateEmployeeToJob() {
        String employeeID = txtempid.getText();
        String orderID = txtorderid.getText();

        // Call the controller method to get employee name and handle the allocation logic with both values
        String employeeName = controller.getEmployeeNameById(employeeID);
        controller.handleEmployeeAllocation(employeeID, orderID);

        // Use the injected instance of GmailerEmployeeController to send the email
        sendEmail("You've Been Assigned a New Task!",
                "Dear " + employeeName + ",\n\n" +
                        "Congratulations! We're happy to inform you that you have been successfully assigned to a new task:\n" +
                        "\n" +
                        "Employee ID: " + employeeID + "\n" +
                        "Order ID: " + orderID + "\n\n" +
                        "Details:\n" +
                        "-----------\n" +
                        "You have been chosen to contribute your expertise to an exciting project. OrderID: " + orderID+ ". Your dedication and hard work are highly appreciated.\n" +
                        "\n" +
                        "----------------\n" +
                        "Get ready to showcase your skills and make a significant impact. Your team is counting on you!\n" +
                        "\n" +
                        "Best Regards,\n" +
                        "CareCare Team");
    }


    private void sendEmail(String subject, String message) {
        try {
            // Use the injected instance of GmailerEmployeeController
            emailController.sendMail(subject, message);
        } catch (Exception ex) {
            ex.printStackTrace();
            // Handle the exception as needed
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Instantiate the controllers
                EmployeeAllocateController controller = new EmployeeAllocateController();
                GmailerEmployeeController emailController = null;
                try {
                    emailController = new GmailerEmployeeController();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

                // Instantiate the UI and pass the controller instances to it
                EmployeeAllocateUI employeeAllocateUI = new EmployeeAllocateUI(controller, emailController);

                // Set the UI visible
                employeeAllocateUI.setVisible(true);
            }
        });
    }
}
