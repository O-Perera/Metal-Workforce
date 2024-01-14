package Views;

import Models.Customer;
import Controllers.CustomerController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class  CustomerView extends JFrame {
    private JPanel panel1;
    private JTextField txtId;
    private JButton btnDelete;
    private JButton btnAdd;
    private JButton btnUpdate;
    private JTextField txtName;
    private JTextField txtEmail;
    private JTextField txtAddress;
    private JTextField txtContact;
    private JTextField txtService;
    private JLabel lblService;
    private JLabel lblContact;
    private JLabel lblAddress;
    private JLabel lblEmail;
    private JLabel lblName;
    private JLabel lblId;
    private JPanel backPanel;
    private JLabel lblOrder;
    private JTextField txtOrder;

    Customer customer;
    CustomerController controller = new CustomerController();

    public CustomerView() {
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    int empId = Integer.parseInt(txtId.getText());
                    String name = txtName.getText();
                    String email = txtEmail.getText();
                    String address = txtAddress.getText();
                    int contact = Integer.parseInt(txtContact.getText());
                    String service = txtService.getText();

                    customer = controller.customerAdd(empId, name, email, address, contact, service);

                    if(controller.addCustomerToDatabase()){
                        JOptionPane.showMessageDialog(backPanel, "Added Successfully", "Success", 0);

                    }else{
                        JOptionPane.showMessageDialog(backPanel, "Cannot Insert Customer", "unsuccessful", 0);
                    }
                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(backPanel, "Invalid Employee ID or the Customer ContactNumber", "unsuccessful", 0);

                }


            }
        });
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int empId = Integer.parseInt(txtId.getText());
                    String name = txtName.getText();
                    String email = txtEmail.getText();
                    String address = txtAddress.getText();
                    int contact = Integer.parseInt(txtContact.getText());
                    String service = txtService.getText();
                    int orderId = Integer.parseInt(txtOrder.getText());

                    customer = controller.customerUpdate(empId, name, email, address, contact, service,orderId);

                    if(controller.UpdateCustomerInDatabase()){
                        JOptionPane.showMessageDialog(backPanel, "Updated Successfully", "Success", 0);
                    }else{
                        JOptionPane.showMessageDialog(backPanel, "Cannot Update Customer", "unsuccessful", 0);
                    }
                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(backPanel, "Invalid Employee ID or the Customer ContactNumber", "unsuccessful", 0);
                }


            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int orderId = Integer.parseInt(txtOrder.getText());
                    customer = controller.customerDelete(orderId);

                    if(controller.deleteCustomerFromDatabase()){
                        JOptionPane.showMessageDialog(backPanel, "Delete Successfully", "Success", 0);
                    }else{
                        JOptionPane.showMessageDialog(backPanel, "Delete unsuccessfully", "unsuccessful", 0);
                    }


                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(backPanel, "Invalid Employee ID or the Customer ContactNumber", "Success", 0);
                }


                }
        });
    }

    public static void main(String[] args) {
        CustomerView customerview=new CustomerView();
        customerview.setContentPane(customerview.backPanel);
        customerview.setTitle("Rider Application");
        customerview.setSize(600,600);
        customerview.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        customerview.setVisible(true);
    }
}
