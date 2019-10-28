package com.elevenst.api;

import com.elevenst.service.ProductNameRemoteService;
import com.elevenst.service.ProductRemoteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/displays")
public class DisplayController {

//	@AutoWired
    private final ProductRemoteService productRemoteService;
    
//	@AutoWired
    private final ProductNameRemoteService productNameRemoteService;

    public DisplayController(ProductRemoteService productRemoteService , ProductNameRemoteService productNameRemoteService) {
        this.productRemoteService = productRemoteService;
        this.productNameRemoteService = productNameRemoteService;
    }

    
//    @GetMapping(path = "/{displayId}")
    @RequestMapping(value="{displayId}")
    public String getDisplayDetail(@PathVariable String displayId) {
        String productInfo = getProductInfo(displayId);
        return String.format("[display id = %s at %s %s ]", displayId, System.currentTimeMillis(), productInfo);
    }
    
    @RequestMapping(value="{displayId}/{productId}/{productName}")
    public String getProductName( @PathVariable("displayId") String displayId,
    							  @PathVariable("productId") String productId,
                                  @PathVariable("productName") String productName) {
    	
    	String productNameInfo = getProductNameInfo(productId, productName);
    	return String.format("[display id = %s at %s %s ]", displayId, System.currentTimeMillis(), productNameInfo);
    }

    private String getProductInfo(String displayId) {
        return productRemoteService.getProductInfo(displayId);
    }
    
    private String getProductNameInfo(String productId, String productName) {
    	return productNameRemoteService.getProductNameInfo(productId , productName);
    }
}