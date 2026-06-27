package com.example.application;

import com.example.domain.Price;
import com.example.domain.dto.PriceFilterDTO;
import com.example.infraestructure.PriceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceService {

    private final PriceRepository priceRepository;

    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public List<Price> findPrices(PriceFilterDTO filter) {
        return priceRepository.findByStartDateAndBrandIdAndProductId(
                filter.getStartDate(), 
                filter.getBrandId(), 
                filter.getProductId()
        );
    }

    public List<Price> getAllPrices() {
        return priceRepository.findAll();
    }

    public Price createPrice(Price price) {
        return priceRepository.save(price);
    }

}

