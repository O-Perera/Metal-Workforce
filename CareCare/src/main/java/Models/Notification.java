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

}
