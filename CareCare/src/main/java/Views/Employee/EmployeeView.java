package Views.Employee;

import Controllers.EmployeeController;

import Models.ManageEmployee;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeView extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField4;
    private JLabel lblEmployeeID;
    private JLabel lblname;
    private JLabel lblAddress;
    private JLabel lblEmail;
    private JLabel lblposition;
    private JTextField textField3;
    private JTextField textField5;
    private JButton btnadd;
    private JLabel lblID;
    private JTextField txtempid;
    private JButton btndelete;
    private JButton btnupdate;
    public JPanel backpanel;
    ManageEmployee employee;
    EmployeeController controller = new EmployeeController();

    public EmployeeView() {
        btnadd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int empId = Integer.parseInt(textField1.getText());
                    String name = textField2.getText();
                    String address = textField3.getText();
                    String email = textField4.getText();
                    String position=textField5.getText();


                    employee = controller.employeeAdd(empId,name,address,email,position);

                    JOptionPane.showMessageDialog(backpanel, "Added Successfully", "Success", 0);


                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(backpanel, "Invalid Employee ID or the Customer ContactNumber", "unsuccessful", 0);

                }

            }
        });
        btnupdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int empId = Integer.parseInt(textField1.getText());
                    String name = textField2.getText();
                    String address = textField3.getText();
                    String email = textField4.getText();
                    String position=textField5.getText();


                    employee = controller.employeeupdate(empId,name,address,email,position);

                    JOptionPane.showMessageDialog(backpanel, "Updated Successfully", "Success", 0);


                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(backpanel, "Invalid Employee ID or the Customer ContactNumber", "unsuccessful", 0);

                }
            }
        });
        btndelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int employeeid = Integer.parseInt(textField1.getText());
                    employee = controller.employeeDelete(employeeid );


                        JOptionPane.showMessageDialog(backpanel, "Delete Successfully", "Success", 0);

                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(backpanel, "Invalid Employee ID", "Success", 0);
                }
            }
        });

        }
    public static void main(String[]args) {
        EmployeeView empview=new EmployeeView();
        empview.setContentPane(empview.backpanel);
        empview.setTitle("Customer Application");
        empview.setSize(600,600);
        empview.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        empview.setVisible(true);
    }
}
