package com.example.controller;

import com.example.application.PriceService;
import com.example.domain.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;
import java.util.List;

@RestController
public class PriceController {

    private final PriceService priceService;

    @Autowired
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping("/getPrices")
    public List<Price> findPrices(
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  LocalDate startDate,
            @RequestParam("productId") Long productId,
            @RequestParam("brandId") Long brandId) {
        return priceService.findPrices(startDate, productId, brandId);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Price>> getAllPrices() {
        List<Price> allPrices = priceService.getAllPrices();

        return new ResponseEntity<>(allPrices, HttpStatus.OK);
    }
}


