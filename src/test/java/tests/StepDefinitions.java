package tests;

import io.cucumber.java.en.Given;

public class StepDefinitions {
    private TestSetup testSetup;
    private ProductSteps productSteps;
    private LoginSteps loginSteps;

    public StepDefinitions() {
        testSetup = new TestSetup();
        testSetup.setUp(); // Inicializa o Playwright e a página
        productSteps = new ProductSteps();
        loginSteps = new LoginSteps();
    }

    @Given("Navegar para o site")
    public void navegar_para_o_site() {
        // A navegação já é feita no método setUp() da classe TestSetup
    }
}