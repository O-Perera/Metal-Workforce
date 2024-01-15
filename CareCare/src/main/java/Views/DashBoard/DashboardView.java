package Views.DashBoard;

import Views.AllocaterView.EmployeeAllocateUI;
import Views.CustomerView;
import Views.SupplierView.supplierview;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashboardView extends JFrame {
    private JButton Customerorderbtn;
    private JButton productbtn;
    public JPanel backpanel;
    private JButton Employeebtn;
    private JButton Supplierbtn;
    private JButton allocatingbtn;
    private JButton inventorybtn;
    private JButton reportbtn;
    public JLabel lblcarecare;


    public DashboardView() {


        Customerorderbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CustomerView customerview=new CustomerView();
                customerview.setContentPane(customerview.backPanel);
                customerview.setTitle("Customer Application");
                customerview.setSize(600,600);
                customerview.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                customerview.setVisible(true);

            }
        });


        Supplierbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                supplierview supview=new supplierview();
                supview.setContentPane(supview.panel1);
                supview.setTitle("supplier application");
                supview.setSize(600,600);
                supview.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                supview.setVisible(true);
            }
        });

        inventorybtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        Employeebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        allocatingbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmployeeAllocateUI empview=new EmployeeAllocateUI();
                empview.setContentPane(empview.panelemp);
                empview.setTitle("supplier application");
                empview.setSize(600,600);
                empview.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                empview.setVisible(true);


            }
        });
        inventorybtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        reportbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        allocatingbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

        public static void main(String[] args) {
            DashboardView ui=new DashboardView();
            ui.setContentPane(ui.backpanel);
            ui.setTitle("Dashboard 1.0");
            ui.setSize(600,600);
            ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ui.setVisible(true);
        }
    }




