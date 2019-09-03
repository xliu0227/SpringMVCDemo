package com.departmentvms.springdemo.departmentVMdemo.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;

@ApiIgnore
@RestController
public class CustomizedErrorHandler implements ErrorController {

    @RequestMapping("/error")
    public void handleError(HttpServletResponse response) {
        try{
            response.sendRedirect("/swagger-ui.html");
        }catch(Exception ex){

        }
    }

    @Override
    public String getErrorPath() {
        return "/swagger-ui.html";
    }
}
