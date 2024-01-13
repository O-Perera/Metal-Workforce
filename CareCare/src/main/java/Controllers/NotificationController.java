package Controllers;

import Models.Notification;
import Models.supplier;


public class NotificationController {
    public Notification Notify(int CustomerId, int OrderId, String email, boolean status)
    {
        Notification Notifyobj = new Notification( CustomerId, OrderId,  email, status);
        return Notifyobj;

    }

}
