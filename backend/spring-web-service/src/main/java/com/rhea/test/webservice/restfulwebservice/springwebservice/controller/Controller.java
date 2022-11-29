package com.rhea.test.webservice.restfulwebservice.springwebservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping(method = RequestMethod.GET, path = "/request")
    public String getRequest(){
        return "ehe te nan da yo";
    }
}
