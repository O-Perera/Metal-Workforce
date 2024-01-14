//package Controllers;
//
//import Models.Product;
//import ServiceLayer.productService;
//
//public class productController {
//
//    Product productObj;
//    productService service;
//
//    public Product addProduct(int prodID, int quantity, int userID, double costPrice, double sellPrice,
//                           Double totalCost, Double totalRevenue, String prodCode, String prodName,
//                           String date, String suppCode, String custCode) {
//
//        Product addObj = new Product();
//        return addObj;
//
//    }
//
//    public Product updateProduct(Product existingProduct, int newQuantity, double newCostPrice, double newSellPrice,
//                              String newProdName, String newDate, String newSuppCode, String newCustCode) {
//
//        Product updateObj = new Product();
//        return updateObj;
//
//    }
//
//    public Product deleteProduct(int prodID){
//        Product deleteObj = new Product();
//        return deleteObj;
//    }
//
//    public boolean addProductToDatabase(){
//        return  service.addProduct(productObj);
//    }
//
//    public boolean UpdateProductInDatabase(){
//        return  service.updateProduct(productObj);
//    }
//
//    public boolean deleteProductFromDatabase(){
//        return  service.deleteProduct(productObj);
//    }
//
//}