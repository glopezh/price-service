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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PriceController {

    private final PriceService priceService;

    @Autowired
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping("/getPrices")
    public List<Map<String, Object>> findPrices(
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  LocalDate startDate,
            @RequestParam("productId") Long productId,
            @RequestParam("brandId") Long brandId) {
        List<Price> ListPrices = priceService.findPrices(startDate, productId, brandId);

        if (startDate == null || startDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de inicio no es válida");
        }

        List<Map<String, Object>> result = new ArrayList<>();

        for (Price price : ListPrices) {
            Map<String, Object> priceInfo = new HashMap<>();
            priceInfo.put("productId",price.getProductId());
            priceInfo.put("brandId",price.getBrandId());
            priceInfo.put("priceList",price.getPriceList());
            priceInfo.put("endDate",price.getEndDate());
            priceInfo.put("startDate", price.getStartDate());
            priceInfo.put("price", price.getPrice());
            result.add(priceInfo);
        }
        return result;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Price>> getAllPrices() {
        List<Price> allPrices = priceService.getAllPrices();

        return new ResponseEntity<>(allPrices, HttpStatus.OK);
    }
}


