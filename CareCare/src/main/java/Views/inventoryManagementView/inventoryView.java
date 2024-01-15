package Views.inventoryManagementView;

import Controllers.productController;
import Models.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.text.SimpleDateFormat;


public class inventoryView extends JFrame{
    private JPanel panel1;
    private JTable table1;
    private JTextField txtQty;
    private JTextField txtUID;
    private JTextField txtTCost;
    private JTextField txtTRevenue;
    private JTextField txtPCode;
    private JTextField txtPName;
    private JTextField txtSCode;
    private JTextField txtCCode;
    private JTextField txtCPrice;
    private JTextField txtSPrice;
    private JButton searchButton;
    private JButton addButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JTextField txtPID;
    private Container backPanel;

    Product productObj;


    public ArrayList<Product> productList;
    private static productController controller = new productController();

    public inventoryView(){

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    LocalDate currentDate = LocalDate.now();

                    // Define the date format
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                    // Format the current date as a string
                    String dateString = currentDate.format(formatter);

                    int prodID = 0;
                    int quantity = Integer.parseInt(txtQty.getText());
                    int userID = Integer.parseInt(txtUID.getText());
                    double costPrice = Double.parseDouble(txtCPrice.getText());
                    double sellPrice = Double.parseDouble(txtSPrice.getText());
                    Double totalCost = Double.parseDouble(txtTCost.getText());
                    Double totalRevenue = Double.parseDouble(txtTRevenue.getText());
                    String prodCode = txtPCode.getText();
                    String prodName = txtPName.getText();
                    String date = dateString;
                    String suppCode = txtSCode.getText();
                    String custCode = txtCCode.getText();


                    Product productObj = new Product(prodID,quantity, userID, costPrice, sellPrice, totalCost,totalRevenue,prodCode,prodName,date,suppCode,custCode);

                    // Call the controller to add the supplier to the database
                    boolean success = controller.addProduct(prodID,quantity, userID, costPrice, sellPrice, totalCost,totalRevenue,prodCode,prodName,date,suppCode,custCode);

                    if (success) {
                        JOptionPane.showMessageDialog(panel1, "Supplier details added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                        txtQty.setText("");
                        txtUID.setText("");
                        txtCPrice.setText("");
                        txtSPrice.setText("");
                        txtTCost.setText("");
                        txtTRevenue.setText("");
                        txtPCode.setText("");
                        txtPName.setText("");
                        txtSCode.setText("");
                        txtCCode.setText("");

                        refreshTable();
                    } else {
                        JOptionPane.showMessageDialog(panel1, "Failed to add supplier to the database", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel1, "Invalid input for Supplier ID or Phone Number", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String dateString = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));


                    int prodID = Integer.parseInt(txtPID.getText());
                    int newQuantity = Integer.parseInt(txtQty.getText());
                    int newUserID = Integer.parseInt(txtUID.getText());
                    double newCostPrice = Double.parseDouble(txtCPrice.getText());
                    double newSellPrice = Double.parseDouble(txtSPrice.getText());
                    Double newTotalCost = Double.parseDouble(txtTCost.getText());
                    Double newTotalRevenue = Double.parseDouble(txtTRevenue.getText());
                    String newProdCode = txtPCode.getText();
                    String newProdName = txtPName.getText();
                    String newDate = dateString;
                    String newSuppCode = txtSCode.getText();
                    String newCustCode = txtCCode.getText();

                    productObj = controller.updateProduct(prodID,newQuantity,newUserID, newCostPrice, newSellPrice, newTotalCost,newTotalRevenue,newProdCode,newProdName,newDate,newSuppCode,newCustCode);
                    JOptionPane.showMessageDialog(panel1, "Product details updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    txtQty.setText("");
                    txtUID.setText("");
                    txtCPrice.setText("");
                    txtSPrice.setText("");
                    txtTCost.setText("");
                    txtTRevenue.setText("");
                    txtPCode.setText("");
                    txtPName.setText("");
                    txtSCode.setText("");
                    txtCCode.setText("");

                    refreshTable();

                }catch(NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel1, "Invalid input for Supplier ID or Phone Number", "Error", JOptionPane.ERROR_MESSAGE);

                }
            }

        });


       searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String dateString = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                    int prodID = Integer.parseInt(txtPID.getText()); // Assuming txtProdID is a JTextField for product ID
                    Product productObj = controller.getProductById(prodID);

                    // Set the values of the text fields with the retrieved data
                    txtQty.setText(String.valueOf(productObj.getQuantity()));
                    txtUID.setText(String.valueOf(productObj.getUserID()));
                    txtCPrice.setText(String.valueOf(productObj.getCostPrice()));
                    txtSPrice.setText(String.valueOf(productObj.getSellPrice()));
                    txtTCost.setText(String.valueOf(productObj.getTotalCost()));
                    txtTRevenue.setText(String.valueOf(productObj.getTotalRevenue()));
                    txtPCode.setText(productObj.getProdCode());
                    txtPName.setText(productObj.getProdName());
                    txtSCode.setText(productObj.getSuppCode());
                    txtCCode.setText(productObj.getCustCode());
                    // Set other text fields accordingly



                    JOptionPane.showMessageDialog(panel1, "Product Found", "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel1, "Invalid input for Supplier ID or Phone Number", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });



        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int productID = Integer.parseInt(txtPID.getText());

                    // Call the controller to delete the supplier
                    boolean deleteSuccess = controller.deleteProduct(productID);

                    if (deleteSuccess) {
                        JOptionPane.showMessageDialog(panel1, "Delete Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                        txtPID.setText("");
                        txtQty.setText("");
                        txtUID.setText("");
                        txtCPrice.setText("");
                        txtSPrice.setText("");
                        txtTCost.setText("");
                        txtTRevenue.setText("");
                        txtPCode.setText("");
                        txtPName.setText("");
                        txtSCode.setText("");
                        txtCCode.setText("");

                        refreshTable();

                    } else {
                        JOptionPane.showMessageDialog(panel1, "Failed to delete product", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel1, "Invalid Product ID", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });



    }


    private void refreshTable() {
        // Retrieve the updated product list from the controller
        List<Product> updatedProductList = controller.getProductList();

        // Update the table with the new data
        productTableApp(updatedProductList);
    }


    public void productTableApp(List<Product> productList) {
        this.productList = new ArrayList<>(productList);

        // Create a table model
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Product ID");
        tableModel.addColumn("Quantity");
        tableModel.addColumn("User ID");
        tableModel.addColumn("Cost Price");
        tableModel.addColumn("Sell Price");
        tableModel.addColumn("Total Cost");
        tableModel.addColumn("Total Revenue");
        tableModel.addColumn("Product Code");
        tableModel.addColumn("Product Name");
        tableModel.addColumn("Date");
        tableModel.addColumn("Supplier Code");
        tableModel.addColumn("Customer Code");

        // Add data to the table model
        for (Product product : productList) {
            Object[] rowData = {
                    product.getProdID(),
                    product.getQuantity(),
                    product.getUserID(),
                    product.getCostPrice(),
                    product.getSellPrice(),
                    product.getTotalCost(),
                    product.getTotalRevenue(),
                    product.getProdCode(),
                    product.getProdName(),
                    product.getDate(),
                    product.getSuppCode(),
                    product.getCustCode()
            };
            tableModel.addRow(rowData);
        }

        // Update the existing table with the new data
        table1.setModel(tableModel);
    }


    public static void main(String[] args) {
        inventoryView inventoryView=new inventoryView();
        inventoryView.setContentPane(inventoryView.panel1);
        inventoryView.setTitle("Customer Application");
        inventoryView.setSize(600,600);
        inventoryView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inventoryView.setVisible(true);


        List<Product> productList = controller.getProductList();

        // Call the method on the instance of the class
        inventoryView.productTableApp(productList);

    }
}






