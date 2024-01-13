package Views;

import Controllers.NotificationController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NotificationView extends JFrame{
    private JCheckBox checkBox1;

    notification notification;

    NotificationController Controller = new NotificationController();

    boolean status;

    public NotificationView() {
        checkBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    try {
                        boolean status = checkBox1.getText();

                        notification = Controller.Notify(status);

                        if (status == true) {
                            JOptionPane.showMessageDialog(rootPane, e.getClass(), "Success", 0);
                        }

                        catch(RuntimeException e){
                            JOptionPane.showMessageDialog(rootPane, e.getClass(), "Error", 0);


                        }
                    }

                    }
            }
        });
    }
}
