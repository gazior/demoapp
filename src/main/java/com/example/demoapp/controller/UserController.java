package com.example.demoapp.controller;


import com.example.demoapp.domain.CustomUser;
import com.example.demoapp.domain.prestashop.CategoryResponse;
import com.example.demoapp.rest.RestPrestashop;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    private final RestPrestashop restPrestashop;

    public UserController(RestPrestashop restPrestashop) {
        this.restPrestashop = restPrestashop;
    }


    @GetMapping("/index")
    @ResponseBody
    public CustomUser addUser(@AuthenticationPrincipal CustomUser userApp) {

        return userApp;
    }

    @GetMapping("/products")
    @ResponseBody
    public ResponseEntity<String> getAllProducts(){
        return restPrestashop.getAllProduct();
    }

    @GetMapping("/products/{id}")
    @ResponseBody
    public ResponseEntity<String> getAllProducts(@PathVariable Long id){
        return restPrestashop.getAllProduct(id);
    }

    @GetMapping("/categories/{id}")
    @ResponseBody
    public CategoryResponse getCategories(@PathVariable Long id){
        return restPrestashop.getCategories(id);
    }


    @GetMapping("/test")
    @ResponseBody
    public String test(@Value("${test.test1.test2}") String test){
        return test;
    }
}
