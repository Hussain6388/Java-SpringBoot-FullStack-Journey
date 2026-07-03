package in.coderarmy;

import in.coderarmy.payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

    PaymentService payment;

    @Autowired  // constructor
    public OrderService(@Qualifier("card") PaymentService payment) {
        this.payment = payment;
    }
//    @Autowired
//    public void setPaymentService(PaymentService payment) {
//        this.payment = payment;
//    }

    public void placeOrder() {
        payment.pay();
        System.out.println("Order Placed");
    }
}
