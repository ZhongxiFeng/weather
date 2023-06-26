package com.example.universityservicedev;

import com.example.universityservicedev.response.GeneralResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * @author ZHONGXI FENG
 * @projectName Antra_HW
 * @create 6/14/2023-4:04 PM
 * @description
 */
@RestController
@RequestMapping("university")
public class UniversityController {
    private final UniversityService universityService;
    @Autowired
    UniversityController(UniversityService universityService){
        this.universityService = universityService;
    }
    //@GetMapping("/hello")
    //public String hhh(){
    //    return "hello";
    //}
    @GetMapping(value = "/search",params = "name")
    public GeneralResponse searchUniversityById(@RequestParam String name){
        List<University> universityByName = universityService.getUniversityByName(name);
        GeneralResponse generalResponse = new GeneralResponse(universityByName);
        return generalResponse;
    }

    @GetMapping(value = "/search",params = "country")
    public GeneralResponse searchUniversityByCountry(@RequestParam String country){
        List<University> universityByCountry = universityService.getUniversityByCountry(country);
        GeneralResponse generalResponse = new GeneralResponse(universityByCountry);
        return generalResponse;
    }
}
