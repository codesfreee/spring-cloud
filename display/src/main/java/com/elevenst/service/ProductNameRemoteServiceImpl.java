package com.elevenst.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductNameRemoteServiceImpl implements ProductNameRemoteService {

    private static final String url = "http://localhost:8082/products/";
    private final RestTemplate restTemplate;

    public ProductNameRemoteServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String getProductNameInfo(String productId, String productName) {
        return this.restTemplate.getForObject(url + productId + "/" + productName, String.class);
    }
}
