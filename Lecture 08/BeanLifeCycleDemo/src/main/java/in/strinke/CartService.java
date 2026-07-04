package in.strinke;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.security.auth.Destroyable;
import java.util.HashMap;
import java.util.Map;

@Component
public class CartService implements BeanNameAware, ApplicationContextAware /* InitializingBean , DisposableBean */ {

    Map<Integer,String> mp;
    public CartService() {
        mp = new HashMap<>();
        System.out.println("CartService Constructor Called");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean Name : " + name);

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContext : " + applicationContext);

    }


    @PostConstruct
    public void start2(){
        System.out.println("Initialization callback");
        mp.put(1,"Aditya");
        mp.put(2,"Bob");
    }

    public void addToCart(){
        System.out.println("Added to Cart");
    }

    public String getValue(int key){
        return mp.get(key);
    }

    @PreDestroy
    public void stop2(){
        mp.clear();
        System.out.println("Bean getting destroyed");
    }

//    public void stop(){
//        mp.clear();
//        System.out.println("Bean getting destroyed");
//
//    }

//    @Override
//    public void destroy() throws Exception {
//        mp.clear();
//        System.out.println("Bean getting destroyed");
//    }


//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("Initialization callback");
//        mp.put(1,"Aditya");
//        mp.put(2,"Bob");
//    }

//    public void start(){
//        System.out.println("Initialization callback");
//        mp.put(1,"Aditya");
//        mp.put(2,"Bob");
//    }



}
