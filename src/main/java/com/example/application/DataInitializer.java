package com.example.application;

import com.example.domain.Price;
import com.example.infraestructure.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
        Price price1 = new Price(1L,1L,LocalDate.parse("2020-06-14-23.59.59",formatter),LocalDate.parse("2020-12-31-23.59.59",formatter),1L,35455L,0,35.50,"EUR");
        Price price2 = new Price(2L,1L,LocalDate.parse("2020-06-14-18.30.00",formatter),LocalDate.parse("2020-12-31-23.59.59",formatter),2L,35455L,1,25.45,"EUR");
        Price price3 = new Price(3L,1L,LocalDate.parse("2020-06-15-11.00.00",formatter),LocalDate.parse("2020-12-31-23.59.59",formatter),3L,35455L,1,30.50,"EUR");
        Price price4 = new Price(4L,1L,LocalDate.parse("2020-12-31-23.59.59",formatter),LocalDate.parse("2020-12-31-23.59.59",formatter),4L,35455L,1,38.95,"EUR");

        // Save prices to the database
        priceRepository.save(price1);
        priceRepository.save(price2);
        priceRepository.save(price3);
        priceRepository.save(price4);

        System.out.println("Sample data initialized.");
    }
}
