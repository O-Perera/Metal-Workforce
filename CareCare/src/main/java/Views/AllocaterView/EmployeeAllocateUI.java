package Views.AllocaterView;

import Controllers.EmployeeAllocateController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeAllocateUI extends JFrame {
    private JComboBox<String> employeeComboBox;
    private JComboBox<String> jobComboBox;
    private JButton allocateButton;
    private EmployeeAllocateController controller;

    // Parameterized constructor that accepts an EmployeeAllocateController instance
    public EmployeeAllocateUI(EmployeeAllocateController controller) {
        this.controller = controller;
        setTitle("Employee Allocation");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize components
        employeeComboBox = new JComboBox<>(new String[]{"Employee 1", "Employee 2", "Employee 3"});
        jobComboBox = new JComboBox<>(new String[]{"Job 1", "Job 2", "Job 3"});
        allocateButton = new JButton("Allocate");

        // Set layout
        setLayout(new GridLayout(4, 2));

        // Add components to the frame
        add(new JLabel("")); // Empty label for spacing
        add(new JLabel(""));
        add(new JLabel("Select Employee:"));
        add(employeeComboBox);
        add(new JLabel("Select Job:"));
        add(jobComboBox);
        add(new JLabel()); // Empty label for spacing
        add(allocateButton);

        // Add action listener to the allocate button
        allocateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allocateEmployeeToJob();
            }
        });
    }

    private void allocateEmployeeToJob() {
        String selectedEmployee = (String) employeeComboBox.getSelectedItem();
        String selectedJob = (String) jobComboBox.getSelectedItem();

        // Call the controller method to handle the allocation logic
        controller.handleEmployeeAllocation(selectedEmployee, selectedJob);
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



//package Views.AllocaterView;
//
//
//
//import Controllers.EmployeeAllocateController;
//
//
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class EmployeeAllocateUI extends JFrame {
//    private JComboBox<String> employeeComboBox;
//    private JComboBox<String> jobComboBox;
//    private JButton allocateButton;
//    private EmployeeAllocateController controller;
//
//    public EmployeeAllocateUI(EmployeeAllocateController controller) {
//        this.controller = controller;
//        setTitle("Employee Allocation");
//        setSize(400, 200);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        // Initialize components
//        employeeComboBox = new JComboBox<>(new String[]{"Employee 1", "Employee 2", "Employee 3"});
//        jobComboBox = new JComboBox<>(new String[]{"Job 1", "Job 2", "Job 3"});
//        allocateButton = new JButton("Allocate");
//
//        // Set layout
//        setLayout(new GridLayout(4, 2));
//
//        // Add components to the frame
//        add(new JLabel("")); // Empty label for spacing
//        add(new JLabel(""));
//        add(new JLabel("Select Employee:"));
//        add(employeeComboBox);
//        add(new JLabel("Select Job:"));
//        add(jobComboBox);
//        add(new JLabel()); // Empty label for spacing
//        add(allocateButton);
//
//        // Add action listener to the allocate button
//        allocateButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                allocateEmployeeToJob();
//            }
//        });
//    }
//
//    private void allocateEmployeeToJob() {
//        String selectedEmployee = (String) employeeComboBox.getSelectedItem();
//        String selectedJob = (String) jobComboBox.getSelectedItem();
//
//        // Call the controller method to handle the allocation logic
//        controller.handleEmployeeAllocation(selectedEmployee, selectedJob);
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                // Instantiate the UI
//                EmployeeAllocateUI employeeAllocateUI = new EmployeeAllocateUI();
//
//                // Instantiate the controller and pass the UI instance to it
//                EmployeeAllocateController controller = new EmployeeAllocateController(employeeAllocateUI);
//
//                // Set the UI visible
//                employeeAllocateUI.setVisible(true);
//            }
//        });
//    }
//
//
//
//
//
//}
