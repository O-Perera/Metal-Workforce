package Models;

public class InsertProduct {


        private int prodID;
        private int quantity;
        private int userID;
        private double costPrice;
        private double sellPrice;
        private Double totalCost;
        private Double totalRevenue;
        private String prodCode;
        private String prodName;
        private String date;
        private String suppCode;
        private String custCode;

        public InsertProduct (int prodID, int quantity, int userID, double costPrice, double sellPrice,
                       Double totalCost, Double totalRevenue, String prodCode, String prodName,
                       String date, String suppCode, String custCode) {
            this.prodID = prodID;
            this.quantity = quantity;
            this.userID = userID;
            this.costPrice = costPrice;
            this.sellPrice = sellPrice;
            this.totalCost = totalCost;
            this.totalRevenue = totalRevenue;
            this.prodCode = prodCode;
            this.prodName = prodName;
            this.date = date;
            this.suppCode = suppCode;
            this.custCode = custCode;
        }

        // Getters and Setters for all fields

        public int getProdID() {
            return prodID;
        }

        public void setProdID(int prodID) {
            this.prodID = prodID;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public int getUserID() {
            return userID;
        }

        public void setUserID(int userID) {
            this.userID = userID;
        }

        public double getCostPrice() {
            return costPrice;
        }

        public void setCostPrice(double costPrice) {
            this.costPrice = costPrice;
        }

        public double getSellPrice() {
            return sellPrice;
        }

        public void setSellPrice(double sellPrice) {
            this.sellPrice = sellPrice;
        }

        public Double getTotalCost() {
            return totalCost;
        }

        public void setTotalCost(Double totalCost) {
            this.totalCost = totalCost;
        }

        public Double getTotalRevenue() {
            return totalRevenue;
        }

        public void setTotalRevenue(Double totalRevenue) {
            this.totalRevenue = totalRevenue;
        }

        public String getProdCode() {
            return prodCode;
        }

        public void setProdCode(String prodCode) {
            this.prodCode = prodCode;
        }

        public String getProdName() {
            return prodName;
        }

        public void setProdName(String prodName) {
            this.prodName = prodName;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getSuppCode() {
            return suppCode;
        }

        public void setSuppCode(String suppCode) {
            this.suppCode = suppCode;
        }

        public String getCustCode() {
            return custCode;
        }

        public void setCustCode(String custCode) {
            this.custCode = custCode;
        }


    }


