package com.example.application;

import com.example.domain.Price;
import com.example.infraestructure.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class PriceService {

    private final PriceRepository priceRepository;

    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public List<Price> findPrices(LocalDate startDate, Long productId, Long brandId) {
        return priceRepository.findByStartDateAndBrandIdAndProductId(startDate, brandId, productId);
    }

    public List<Price> getAllPrices() {
        return priceRepository.findAll();
    }

}

