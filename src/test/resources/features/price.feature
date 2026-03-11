Feature: Consulta de precios

  Scenario: Consultar precios por producto, marca y fecha
    When consulto los precios con fecha "2020-06-14", producto 35455 y marca 1
    Then la respuesta es 200
    And la respuesta contiene precios