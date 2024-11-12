## Visão Geral
Este projeto contém testes automatizados para as funcionalidades web do Advantage Online Shopping. As implementações são fornecidas em JavaScript (usando Cucumber.js e Axios).

# Pré-requisitos
- Antes de começar, certifique-se de que você tem as seguintes ferramentas instaladas:
- Para JavaScript
- Node.js
- NPM
- Visual Studio Code (ou qualquer editor de texto de sua preferência)

# Configuração do Ambiente
Clone o Repositório:
sh
git clone https://github.com/seu-usuario/seu-repositorio.git
cd seu-repositorio

#Instale as Dependências: No diretório do projeto, execute:
sh
npm install
Estrutura do Projeto: Certifique-se de que o package.json inclui as dependências do Cucumber.js e Axios.

# Executar os Testes: 

sh
npx cucumber-js

## Cenários de Teste
Realizar a Busca de um Produto

 # Scenario: Buscar por um produto específico
  ```gherkin
    Given que o usuário está na página inicial do Advantage Online Shopping
    When o usuário insere "Notebook" na barra de busca
    And clica no botão de busca
    Then os resultados da busca devem exibir produtos relacionados a "Notebook"
 ```
# Incluir Produto no Carrinho
```gherkin
  Scenario: Adicionar um produto específico ao carrinho
    Given que o usuário está na página de resultados de busca para "Notebook"
    When o usuário seleciona um produto específico
    And clica no botão "Adicionar ao Carrinho"
    Then o carrinho deve ser atualizado para incluir o produto selecionado
 ```
# Validar Produtos no Carrinho
```gherkin
  Scenario: Validar que os produtos incluídos estão na tela de pagamento
    Given que o usuário adicionou produtos ao carrinho
    When o usuário navega até a tela de pagamento
    Then a tela de pagamento deve listar todos os produtos adicionados ao carrinho
 ```
# Autor - https://www.linkedin.com/in/lucas-rocha-60a7a119b/
