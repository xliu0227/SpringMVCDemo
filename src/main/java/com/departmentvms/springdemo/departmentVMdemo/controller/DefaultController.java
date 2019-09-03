package com.departmentvms.springdemo.departmentVMdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.rmi.server.ExportException;

@ApiIgnore
@RestController
public class DefaultController {
    @GetMapping("/")
    public void defaultRedirect(HttpServletResponse response){
        try{
            response.sendRedirect("/swagger-ui.html");
        }catch(Exception ex){

        }
    }
}
