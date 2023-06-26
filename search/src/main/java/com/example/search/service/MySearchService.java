package com.example.search.service;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author ZHONGXI FENG
 * @projectName weather
 * @create 6/25/2023-10:32 PM
 * @description
 */

@Service
public interface MySearchService {
    public Map<String,Object> mySearch();
    public Map<String, Object>timeoutHandler();
}
