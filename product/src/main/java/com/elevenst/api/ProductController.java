package com.elevenst.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

//    @GetMapping(path = "{productId}")
//	@RequestMapping(value="{productId}",method = RequestMethod.GET)
	@RequestMapping(value="{productId}")
    public String getProductInfo(@PathVariable String productId) {
        return "[product id = " + productId + " at " + System.currentTimeMillis() + "]";
    }
        
//    @RequestMapping(value="{productId}/{productName}",method = RequestMethod.GET)
    @RequestMapping(value="{productId}/{productName}")
//    @GetMapping(path = "{productId}/{productName}")
    public String getProductName( @PathVariable("productId") String productId,
                                  @PathVariable("productName") String productName) {
    	return "[product id = " + productId + " product name = " + productName + " at " + System.currentTimeMillis() + "]";
    }
}
