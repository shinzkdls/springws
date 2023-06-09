package com.kbstar.dao;

import com.kbstar.dto.ProductDTO;
import com.kbstar.frame.MyDao;

import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements MyDao<String, ProductDTO> {

    @Override
    public void insert(ProductDTO productDTO) {
        System.out.println("Inserted Oracle: " + productDTO);
    }

    @Override
    public void delete(String s) {
        System.out.println("Deleted Oracle: " + s);
    }

    @Override
    public void update(ProductDTO productDTO) {
        System.out.println("Updated Oracle: " + productDTO);
    }

    @Override
    public ProductDTO select(String s) {
        ProductDTO user = null;
        user = new ProductDTO(s, "name1", 1000, 20);
        return user;
    }

    @Override
    public List<ProductDTO> select() {
        List<ProductDTO> list = new ArrayList<ProductDTO>();
        list.add(new ProductDTO("id01", "name01", 1000, 20));
        list.add(new ProductDTO("id02", "name02", 2000, 40));
        list.add(new ProductDTO("id03", "name03", 3000, 60));
        return list;
    }
}
