package com.example.universityservicedev;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author ZHONGXI FENG
 * @projectName Antra_HW
 * @create 6/14/2023-3:46 PM
 * @description
 */

@Data
public class University {
    String country;
    @JsonProperty("alpha_two_code")
    String alphaTwoCode;
    String name;
    @JsonProperty("state_province")
    String stateProvince;
    Domain domains;
    @JsonProperty("web_pages")
    WebPage webPage;
}


@Data
class Domain{
    List<String> domains;
}
@Data
class WebPage{
    String webPage;
}
