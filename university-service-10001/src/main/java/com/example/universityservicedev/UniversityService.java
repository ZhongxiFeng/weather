package com.example.universityservicedev;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZHONGXI FENG
 * @projectName Antra_HW
 * @create 6/14/2023-3:52 PM
 * @description
 */
@Service
public interface UniversityService {
    List<University> getUniversityByName(String name);
    List<University> getUniversityByCountry(String country);
}
