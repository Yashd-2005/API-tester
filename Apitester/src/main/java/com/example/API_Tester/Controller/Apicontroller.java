package com.example.API_Tester.Controller;

import com.example.API_Tester.DTO.Apirequest;
import com.example.API_Tester.DTO.Apiresponse;
import com.example.API_Tester.Service.ApiService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api")
public class Apicontroller {
    ApiService apiservice;
    public Apicontroller(ApiService apiservice){
        this.apiservice=apiservice;
    }

    @PostMapping("/request")
    public Apiresponse sendRequest(@RequestBody Apirequest request){
        return apiservice.sendRequest(request);
    }

}
