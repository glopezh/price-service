package com.example.controller;

import com.example.application.PriceService;
import com.example.domain.Price;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.assertTrue;

@WebMvcTest(PriceController.class)
public class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PriceService priceService;

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void testFindPrices() throws Exception {

        LocalDate startDate = LocalDate.parse("2020-06-14");
        Long productId = 1L;
        Long brandId = 1L;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
        Price price1 = new Price(1L, 1L, LocalDate.parse("2020-06-14-10.00.00", formatter), LocalDate.parse("2020-12-31-23.59.59", formatter), 1L, 35455L, 0, 35.50, "EUR");
        Price price2 = new Price(2L, 1L, LocalDate.parse("2020-06-14-16.00.00", formatter), LocalDate.parse("2020-12-31-23.59.59", formatter), 2L, 35455L, 1, 25.45, "EUR");
        List<Price> mockPrices = getPrices(formatter, price1, price2);


        when(priceService.findPrices(startDate, productId, brandId)).thenReturn(mockPrices);

        mockMvc.perform(get("/getPrices")
                        .param("startDate", startDate.toString())
                        .param("productId", productId.toString())
                        .param("brandId", brandId.toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].productId").value(price1.getProductId()))
                .andExpect(jsonPath("$[0].brandId").value(price1.getBrandId()))
                .andExpect(jsonPath("$[0].priceList").value(price1.getPriceList()))
                .andExpect(jsonPath("$[0].endDate").value(price1.getEndDate().toString()))
                .andExpect(jsonPath("$[0].startDate").value(price1.getStartDate().toString()))
                .andExpect(jsonPath("$[0].price").value(price1.getPrice()))
                .andExpect(jsonPath("$[1].productId").value(price2.getProductId()))
                .andExpect(jsonPath("$[1].brandId").value(price2.getBrandId()))
                .andExpect(jsonPath("$[1].priceList").value(price2.getPriceList()))
                .andExpect(jsonPath("$[1].endDate").value(price2.getEndDate().toString()))
                .andExpect(jsonPath("$[1].startDate").value(price2.getStartDate().toString()))
                .andExpect(jsonPath("$[1].price").value(price2.getPrice()));

        assertTrue(true);
        assertEquals(5, mockPrices.size(), "The size of the mockPrices list should be 5");
    }

    private static List<Price> getPrices(DateTimeFormatter formatter, Price price1, Price price2) {
        Price price3 = new Price(1L, 1L, LocalDate.parse("2020-06-14-21.00.00", formatter), LocalDate.parse("2020-12-31-23.59.59", formatter), 1L, 35455L, 0, 35.50, "EUR");
        Price price4 = new Price(2L, 1L, LocalDate.parse("2020-06-15-10.00.00", formatter), LocalDate.parse("2020-12-31-23.59.59", formatter), 2L, 35455L, 1, 25.45, "EUR");
        Price price5 = new Price(2L, 1L, LocalDate.parse("2020-06-16-21.00.00", formatter), LocalDate.parse("2020-12-31-23.59.59", formatter), 2L, 35455L, 1, 25.45, "EUR");
        List<Price> mockPrices = Arrays.asList(price1, price2,price3,price4,price5);
        return mockPrices;
    }
}
