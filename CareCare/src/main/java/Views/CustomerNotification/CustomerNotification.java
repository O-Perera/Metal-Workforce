package Views.CustomerNotification;
import Controllers.CustomerEmail;



import Controllers.GmailerEmployeeController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerNotification extends JFrame{

    public JPanel backpanel;
    private JLabel lblif;
    private JButton cusbtn;


    public CustomerNotification() {
        cusbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                sendEmail("A new message", """
               Dear Customer,

              Your car is ready to be collected.


             Best Regards,
              CareCare Team
              """) ;

            }
        });
    }
    private void sendEmail(String subject, String message) {
        try {
            // Create an instance of GmailerEmployeeController to send the email
            CustomerEmail emailControllerCus = new CustomerEmail();
            emailControllerCus.sendMail(subject, message);
        } catch (Exception ex) {
            ex.printStackTrace();
            // Handle the exception as needed
        }
    }

    public static void main(String[] args) {
        CustomerNotification cusview=new CustomerNotification();
        cusview.setContentPane(cusview.backpanel);
        cusview.setTitle("Customer application");
        cusview.setSize(600,600);
        cusview.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cusview.setVisible(true);
    }
}
