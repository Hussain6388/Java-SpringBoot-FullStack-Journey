package in.coderarmy;

import in.coderarmy.notification.EmailService;
import in.coderarmy.notification.NotificationService;

public class Main {
    public static void main(String[] args) {
        NotificationService notification = new EmailService();
        OrderService order = new OrderService(notification);
        order.placeOrder();
    }
}