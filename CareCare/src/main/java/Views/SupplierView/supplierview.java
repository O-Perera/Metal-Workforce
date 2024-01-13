package Views.SupplierView;
import Models.supplier;
import Controllers.suppliercontrol;
import java.sql.*;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Supplier;
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
    private JTextField textField2;
    private JLabel lblnameU;
    private JLabel lblAddressU;
    private JLabel lblemailU;
    private JLabel lblPhonenumberU;
    private JTextField textField1;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JLabel lbldelete;
    private JButton button1;
    private JLabel lblIDD;
    private JTextField textField6;
     supplier supplierobj;

     suppliercontrol controller;
    ArrayList<supplier> supplierList;


    public supplierview() {
        supplierList= new ArrayList<>();

        btnadd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    int supplierID =Integer.parseInt(txtID.getText());
                    String name=txtname.getText();
                    String address=txtAddress.getText();
                    String  email =txtEmail.getText();
                    int phone_number=Integer.parseInt(txtPhonenumber.getText());
                  try{
                      //open connection here
                      //sql statement to insert
                      supplierobj=controller.addsupplier(supplierID,name,address,email,phone_number);
                      supplierList.add(supplierobj);


                }
                catch( Exception e1   ){


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

