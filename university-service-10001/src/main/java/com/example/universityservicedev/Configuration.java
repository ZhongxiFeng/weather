package com.example.universityservicedev;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author ZHONGXI FENG
 * @projectName Antra_HW
 * @create 6/14/2023-3:43 PM
 * @description
 */
@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
