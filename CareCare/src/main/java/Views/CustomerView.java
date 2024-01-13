package Views;

import javax.swing.*;

public class CustomerView extends JFrame {
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

    public static void main(String[] args) {
        CustomerView customerview=new CustomerView();
        customerview.setContentPane(customerview.backPanel);
        customerview.setTitle("Rider Application");
        customerview.setSize(600,600);
        customerview.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        customerview.setVisible(true);
    }
}
