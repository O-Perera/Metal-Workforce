package Models;

public class Notification {
    private int  CustomerId;
    private int OrderId;
    private String email;
    private boolean status;

    public Notification(int CustomerId, int OrderId, String email, boolean status){
        this.CustomerId = CustomerId;
        this.email = email;
        this.OrderId = OrderId;
        this.status = status;
    }
    public Notification(){

        this.status = false;
    }


    public int getCustomerId() {
        return CustomerId;
    }

    public int getOrderId() {
        return OrderId;
    }

    public String getEmail() {
        return email;
    }

    public boolean isStatus() {
        return status;
    }

    public void setCustomerId(int customerId) {
        CustomerId = customerId;
    }

    public void setOrderId(int orderId) {
        OrderId = orderId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
