package com.example.cucumber;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CucumberSpringConfiguration {

    @TestConfiguration
    static class TestConfig {
        @Bean
        TestRestTemplate testRestTemplate() {
            return new TestRestTemplate();
        }
    }
}