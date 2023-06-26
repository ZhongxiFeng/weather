package com.example.search.controller;

import com.example.search.service.MySearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Api(tags = "search-service")
@RestController
public class SearchController {
    private final MySearchService mySearchService;
    @Autowired
    SearchController(MySearchService mySearchService){
        this.mySearchService = mySearchService;
    }
    @ApiOperation(value = "Get information about student and 3rd party api")
    @GetMapping("/weather/search")
    public ResponseEntity<?> getDetails() {
        //TODO
        Map<String, Object> map = mySearchService.mySearch();
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
