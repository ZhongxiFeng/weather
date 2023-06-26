package com.example.search.service;

import com.example.search.config.EndPointConfig;

import com.example.search.response.GeneralResponse;
import com.netflix.hystrix.contrib.javanica.annotation.*;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author ZHONGXI FENG
 * @projectName weather
 * @create 6/25/2023-10:33 PM
 * @description
 */
@Slf4j
@Service
public class MySearchServiceImpl implements MySearchService{
    RestTemplate restTemplate;
    ExecutorService executorService = Executors.newCachedThreadPool();
    MySearchServiceImpl(RestTemplate getRestTemplate){

        this.restTemplate = getRestTemplate;
    }
    @HystrixCommand(fallbackMethod = "timeoutHandler",
            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")})
    @Override
    public Map<String, Object> mySearch() {

        try{
            TimeUnit.SECONDS.sleep(5);
        }catch (Exception e){

        }

        HashMap<String, Object> resultMap = new HashMap<>();

        CompletableFuture.supplyAsync(() -> {
            GeneralResponse studentResponse = restTemplate.getForObject(EndPointConfig.endpoint_1, GeneralResponse.class);
            return studentResponse;
        }, executorService).whenComplete((result,throwable) -> {
            if(result!=null&&result.getCode()== HttpStatus.OK.value()){
                resultMap.put("studentResult",result.getData());
            }
            if(throwable!=null){
                log.error("completableFuture1 error:"+throwable);
            }
        }).join();

        CompletableFuture.supplyAsync(() -> {
            GeneralResponse universityResponse = restTemplate.getForObject(EndPointConfig.endpoint_2, GeneralResponse.class);
            return universityResponse;
        }, executorService).whenComplete((result,throwable) -> {
            if(result!=null&&result.getCode()== HttpStatus.OK.value()){
                resultMap.put("universityResult",result.getData());
            }
            if(throwable!=null){
                log.error("completableFuture1 error:"+throwable);
            }
        }).join();
        return resultMap;


    }

    @Override
    public Map<String, Object> timeoutHandler() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("timeout","limit-3000-milliseconds");
        return map;
    }


}
