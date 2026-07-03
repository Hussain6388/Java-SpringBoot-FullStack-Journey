package in.coderarmy;

import in.coderarmy.notification.EmailService;
import in.coderarmy.notification.NotificationService;
import in.coderarmy.notification.PopUpNotificationService;
import in.coderarmy.notification.SmsService;

public class OrderService {
    NotificationService notification;

    public OrderService(NotificationService notification) {
        this.notification = notification;
    }

    public void placeOrder(){
        System.out.println("Order Placed");
        notification.sendNotification();
    }
}
