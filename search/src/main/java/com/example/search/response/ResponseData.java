package com.example.search.response;

import lombok.Data;

import java.util.HashMap;

/**
 * @author ZHONGXI FENG
 * @projectName Antra_HW
 * @create 6/15/2023-12:31 AM
 * @description
 */
@Data
public class ResponseData {
    HashMap<String,Object> map = new HashMap<>();
    public void put(String s,Object o){
        map.put(s,o);
    }
}
