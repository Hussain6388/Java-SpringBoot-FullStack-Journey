package in.strikes;

import org.springframework.stereotype.Component;

@Component
public class OrderService {

    private PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void orderPlace(){
        paymentService.pay();
        getDetails();
        System.out.println("Order placed");

    }

    public void getDetails(){
        System.out.println("Getting details");
    }
}
