package com.kbstar.controller;

import com.kbstar.dto.Cust;
import com.kbstar.dto.Marker;
import com.kbstar.service.MarkerService;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Slf4j
@RestController
public class AjaxImplController {

    @Autowired
    MarkerService service;

    @RequestMapping("/getservertime")
    public Object getservertime() {
        Date date = new Date();
        return date;
    }

    @RequestMapping("/checkid")
    public Object checkid(String id) {
        int result = 0;
        if (id.equals("qqqq") || id.equals("aaaa") || id.equals("ssss")) {
            result = 1;
        }
        return result;
    }

    @RequestMapping("/getdata")
    public Object getdata() {
        List<Cust> list = new ArrayList<>();
        list.add(new Cust("id01", "pwd01", "james1"));
        list.add(new Cust("id02", "pwd02", "james2"));
        list.add(new Cust("id03", "pwd03", "james3"));
        list.add(new Cust("id04", "pwd04", "james4"));
        list.add(new Cust("id05", "pwd05", "james5"));

        // Java Object ---> JSON
        // JSON(JavaScript Object Notation)
        // [{}, {}, {}, ...]
        JSONArray ja = new JSONArray();
        for (Cust obj : list) {
            JSONObject jo = new JSONObject();
            Random r = new Random();
            int i = r.nextInt(100) + 1;
            jo.put("id", obj.getId());
            jo.put("pwd", obj.getPwd());
            jo.put("name", obj.getName() + i);
            ja.add(jo);
        }
        return ja;
    }

    @RequestMapping("/markers")
    public Object markers(String loc) {
        List<Marker> list = null;
        try {
            list = service.get();
        } catch (Exception e) {
            log.info("error...");
            e.printStackTrace();
        }
        JSONArray ja = new JSONArray();
        for (Marker obj : list) {
            if (obj.getLoc().equals(loc)) {
                JSONObject jo = new JSONObject();
                jo.put("id", obj.getId());
                jo.put("title", obj.getTitle());
                jo.put("target", obj.getTarget());
                jo.put("lat", obj.getLat());
                jo.put("lng", obj.getLng());
                jo.put("img", obj.getImg());
                jo.put("loc", obj.getLoc());
                ja.add(jo);
            }
        }
        return ja;
    }

}
