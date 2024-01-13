package Views.SupplierView;
import Models.supplier;
import Controllers.suppliercontrol;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class supplierview  extends JFrame{
    private JPanel panel1;
    private JLabel lblID;
    private JTextField txtID;
    private JLabel lblname;
    private JTextField txtname;
    private JLabel lblAddress;
    private JTextField txtAddress;
    private JLabel lblEmail;
    private JLabel iblphonenumber;
    private JTextField txtEmail;
    private JTextField txtPhonenumber;
    private JLabel lbladd;
    private JButton btnadd;
    private JLabel lblupdate;
    private JButton btnupdate;
    private JLabel lblIDU;
    private JTextField txtIDU;
    private JLabel lblnameU;
    private JLabel lblAddressU;
    private JLabel lblemailU;
    private JLabel lblPhonenumberU;
    private JTextField txtnameu;
    private JTextField txtaddressu;
    private JTextField txtphonenumberu;
    private JTextField txtemailu;
    private JLabel lbldelete;
    private JButton btndelete;
    private JLabel lblIDD;
    private JTextField txtdelete;
    supplier supplierobj;

    // suppliercontrol controller;
    public ArrayList<supplier> supplierList;
    suppliercontrol controller = new suppliercontrol();


    public supplierview() {
        supplierList= new ArrayList<>();

        btnadd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String txtIDValue = txtID.getText().trim();
                    String name = txtname.getText().trim();
                    String address = txtAddress.getText().trim();
                    String email = txtEmail.getText().trim();
                    String txtPhoneNumberValue = txtPhonenumber.getText().trim();

                    if (txtIDValue.isEmpty() || name.isEmpty() || address.isEmpty() || email.isEmpty() || txtPhoneNumberValue.isEmpty()) {
                        JOptionPane.showMessageDialog(panel1, "Please fill in all the fields", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    int supplierID = Integer.parseInt(txtIDValue);
                    int phone_number = Integer.parseInt(txtPhoneNumberValue);

                    // Open connection here
                    // SQL statement to insert
                    supplierobj = controller.addsupplier(supplierID, name, address, email, phone_number);
                    supplierList.add(supplierobj);
                    JOptionPane.showMessageDialog(panel1, "Supplier details added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel1, "Invalid input for Supplier ID or Phone Number", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel1, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }


            }
        });
        btnupdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int supplierID = Integer.parseInt(txtIDU.getText());
                    String newName = txtnameu.getText();
                    String newAddress = txtaddressu.getText();
                    String newEmail = txtemailu.getText();
                    int newPhone_number = Integer.parseInt(txtphonenumberu.getText());

                    supplierobj = controller.updateSupplier(supplierID,newName,newAddress,newEmail,newPhone_number);
                    JOptionPane.showMessageDialog(panel1, "Supplier details updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                }catch(NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel1, "Invalid input for Supplier ID or Phone Number", "Error", JOptionPane.ERROR_MESSAGE);

                }
            }

        });
        btndelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int supplierID = Integer.parseInt(txtdelete.getText());
                    supplierobj  = controller.supplierDelete(supplierID);
                    JOptionPane.showMessageDialog(panel1, "Delete Successfully", "Success", 0);
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(panel1, "Invalid Employee ID or the Customer ContactNumber", "Success", 0);
                }
            }
        });
    }


    public static void main(String[] args) {
        supplierview supview=new supplierview();
        supview.setContentPane(supview.panel1);
        supview.setTitle("supplier application");
        supview.setSize(600,600);
        supview.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        supview.setVisible(true);
    }


}



