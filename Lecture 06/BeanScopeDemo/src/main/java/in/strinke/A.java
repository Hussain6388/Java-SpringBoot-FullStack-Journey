package in.strinke;

import org.springframework.stereotype.Component;

@Component
public class A {

    public OrderService orderService;
    public A(OrderService orderService){
        this.orderService = orderService;
    }
}
