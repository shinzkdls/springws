package com.kbstar.app;

import com.kbstar.dto.ProductDTO;
import com.kbstar.frame.MyService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProductSelectTest {
    public static void main(String[] args) {
        ApplicationContext factory =
                new ClassPathXmlApplicationContext("spring.xml");

        MyService<String, ProductDTO> service =
                (MyService<String, ProductDTO>) factory.getBean("pservice");

        String id = "id01";
        ProductDTO prod = service.get(id);
        System.out.println(prod);
    }

}
