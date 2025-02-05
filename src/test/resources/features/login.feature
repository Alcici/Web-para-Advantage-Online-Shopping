Feature: Login no site

  Scenario: Inserir dados de login incorretos e verificar se uma mensagem de erro
    Given Navegar para o site
    When Clicar em usuario
    Then conta com dados errados

  Scenario:Criar um usuario novo
    Given Navegar para o site
    When Clicar em usuario
    Then criar usuario