package com.example.cucumber;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PriceStepDefinitions {

    @LocalServerPort
    private int port;

    private final RestTemplate restTemplate = new RestTemplate();
    private ResponseEntity<List> response;

    @When("consulto los precios con fecha {string}, producto {long} y marca {long}")
    public void consultoLosPreciosConFechaProductoYMarca(String fecha, Long productId, Long brandId) {
        String url = "http://localhost:" + port
                + "/getPrices?startDate=" + fecha
                + "&productId=" + productId
                + "&brandId=" + brandId;

        response = restTemplate.getForEntity(url, List.class);
    }

    @Then("la respuesta es {int}")
    public void laRespuestaEs(Integer status) {
        assertNotNull(response);
        assertEquals(status, response.getStatusCodeValue());
    }

    @Then("la respuesta contiene precios")
    public void laRespuestaContienePrecios() {
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertFalse(response.getBody().isEmpty());
    }
}