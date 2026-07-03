package in.coderarmy.payment;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
@Qualifier("card")
public class CarPayment implements PaymentService {

    @Override
    public void pay() {
        System.out.println("Paying via Card");
    }
}
