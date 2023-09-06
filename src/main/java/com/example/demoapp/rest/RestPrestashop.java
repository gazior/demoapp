package com.example.demoapp.rest;

import com.example.demoapp.domain.prestashop.CategoryResponse;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestPrestashop {


    private final RestTemplate restTemplate;


    public RestPrestashop(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> getAllProduct() {

        return restTemplate.exchange("http://localhost:8080/api/products/?output_format=JSON"
                , HttpMethod.GET
                , new HttpEntity<>("parameters", setHeaders()), String.class);
    }

    public ResponseEntity<String> getAllProduct(Long id) {

        return restTemplate.exchange("http://localhost:8080/api/products/"+id+"/?output_format=JSON"
                , HttpMethod.GET
                , new HttpEntity<>("parameters", setHeaders()), String.class);
    }

    public CategoryResponse getCategories(Long id) {

        return restTemplate.exchange("http://localhost:8080/api/categories/"+id+"/?output_format=JSON"
                , HttpMethod.GET
                , new HttpEntity<>("parameters", setHeaders()), CategoryResponse.class).getBody();
    }


    private HttpHeaders setHeaders() {

        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("IHFAWWS59XLFZPELJKDZ1IFKZXZRMPDP","");
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
