Feature: Buscar produto e colocar no carrinho

  Scenario: Buscar e preencher dados para um produto
    Given Navegar para o site
    When Clicar no link "dvantage DEMO"
    And Clicar na categoria "Laptops"
    And Selecionar o primeiro laptop
    And Adicionar ao carrinho
    And Ir para o checkout

Scenario: Clicar nos BTN dos cantos superiores
  Given Navegar para o site
  When Clicar em nossos produtos
  When Clicar no link "dvantage DEMO"
  And Clicar em oferta especial
  And Clicar em itens populares
  Then Clicar em contact us
