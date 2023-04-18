package com.kbstar.service;

import com.kbstar.dao.ProductDAO;
import com.kbstar.dto.ProductDTO;
import com.kbstar.frame.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("pservice")
public class ProductService implements MyService<String, ProductDTO> {

    //    @Autowired
//    @Qualifier("pdao")
//    MyDao<String, ProductDTO> dao;

    @Autowired
    ProductDAO dao;

    @Override
    public void register(ProductDTO productDTO) {
        dao.insert(productDTO);
        System.out.println("Send Mail..");
    }

    @Override
    public void remove(String s) {
        dao.delete(s);
    }

    @Override
    public void modify(ProductDTO productDTO) {
        dao.update(productDTO);
        System.out.println("Send Mail..");
    }

    @Override
    public ProductDTO get(String s) {
        return dao.select(s);
    }

    @Override
    public List<ProductDTO> get() {
        return dao.select();
    }
}
