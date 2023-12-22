package com.example.infraestructure;

import com.example.domain.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
    List<Price> findByStartDateAndBrandIdAndProductId(LocalDate startDate, Long productId, Long brandId);
}


