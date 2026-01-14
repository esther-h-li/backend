package com.impulsepricechecker.controllers;

import com.impulsepricechecker.model.PriceResult;
import com.impulsepricechecker.model.Product;
import com.impulsepricechecker.service.ScrapingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*")

public class ProductController {
    private final ScrapingService scrapingService;
    public ProductController(ScrapingService scrapingService) {
        this.scrapingService = scrapingService;
    }

    @PostMapping
    public List<PriceResult> getProduct(@RequestBody Product product) {
        System.out.println("===== ENDPOINT HIT =====");

        System.out.println("Product: " + product.getTitle());

        List<PriceResult> mockData =  List.of(
                new PriceResult("iPhone 15 Pro", 799.99, "https://ebay.com/item1", "https://example.com/img1.jpg"),
                new PriceResult("iPhone 15 Pro - Refurbished", 649.99, "https://ebay.com/item2", "https://example.com/img2.jpg"),
                new PriceResult("iPhone 15 Pro - Used", 599.99, "https://ebay.com/item3", "https://example.com/img3.jpg"),
                new PriceResult("iPhone 15", 699.99, "https://ebay.com/item4", "https://example.com/img4.jpg"),
                new PriceResult("iPhone 15 - Open Box", 549.99, "https://ebay.com/item5", "https://example.com/img5.jpg")
        );
        //System.out.print(mockData);
        //return mockData;
        return scrapingService.scrapeAllSites(product);
    }
}
