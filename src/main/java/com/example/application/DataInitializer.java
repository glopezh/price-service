package com.example.application;

import com.example.domain.Price;
import com.example.infraestructure.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    private final PriceRepository priceRepository;

    @Autowired
    public DataInitializer(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        initializeData();
    }

    private void initializeData() {
        // Sample data initialization
        Price price1 = new Price();
        price1.setBrandId(1L);
        price1.setStartDate(LocalDate.parse("2020-06-14"));
        price1.setEndDate(LocalDate.parse("2021-06-14"));
        price1.setPriceList(1L);
        price1.setProductId(35455L);
        price1.setPriority(0);
        price1.setPrice(35.50);
        price1.setCurrency("EUR");


        Price price2 = new Price();
        price2.setStartDate(LocalDate.now());
        price2.setBrandId(1L);
        price2.setProductId(35455L);
        // set other fields as needed

        // Save prices to the database
        priceRepository.save(price1);
        priceRepository.save(price2);

        System.out.println("Sample data initialized.");
    }
}
