package com.example.universityservicedev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author ZHONGXI FENG
 * @projectName Antra_HW
 * @create 6/14/2023-3:54 PM
 * @description
 */
@Service
public class UniversityServiceImpl implements UniversityService{
    private final RestTemplate restTemplate;
    String url = "http://universities.hipolabs.com/search";
    @Autowired
    UniversityServiceImpl(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    @Override
    public List<University> getUniversityByName(String name) {
        String api= url+String.format("?name=%s",name);
        List<University> list = restTemplate.getForObject(api, List.class);
        return list;
    }

    @Override
    public List<University> getUniversityByCountry(String country) {
        String api= url+String.format("?country=%s",country);
        List<University> list = restTemplate.getForObject(api, List.class);
        return list;
    }
}
