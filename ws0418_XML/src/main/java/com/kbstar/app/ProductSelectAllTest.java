package com.kbstar.app;

import com.kbstar.dto.ProductDTO;
import com.kbstar.frame.MyService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class ProductSelectAllTest {
    public static void main(String[] args) {
        ApplicationContext factory =
                new ClassPathXmlApplicationContext("spring.xml");

        MyService<String, ProductDTO> service =
                (MyService<String, ProductDTO>) factory.getBean("pservice");

        List<ProductDTO> list = new ArrayList<>();
        list = service.get();
        System.out.println(list);
    }

}
