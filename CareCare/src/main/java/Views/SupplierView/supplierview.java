package Views.SupplierView;

import javax.swing.*;

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

    public static void main(String[] args) {
        supplierview supview=new supplierview();
            supview.setContentPane(supview.panel1);
            supview.setTitle("supplier application");
            supview.setSize(600,600);
            supview.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            supview.setVisible(true);
        }
    }

