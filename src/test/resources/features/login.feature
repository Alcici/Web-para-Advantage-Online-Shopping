Feature: Login no site

  Scenario: Acessar conta login
  Given Navegar para o site
  When Clicar em usuario
  Then Acessar conta login

  Scenario: Inserir dados de login incorretos e verificar se uma mensagem de erro
    Given Navegar para o site
    When Clicar em usuario
    Then conta com dados errados