package in.strike.demo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Demo2Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Demo2Application.class, args);

//		PaymentGateway payment = context.getBean(PaymentGateway.class);
//		System.out.println(payment.getType());
//		System.out.println(payment.getRetryCount());
//		System.out.println(payment.getTimeout());
//		System.out.println(payment.isEnabled());
	}

}
