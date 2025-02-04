package tests;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import io.cucumber.java.en.*;

public class ProductSteps {
    private Page page;

    // Construtor vazio necessário para o Cucumber
    public ProductSteps() {
        this.page = TestSetup.getPage();
    }

    @When("Clicar no link {string}")
    public void clicar_no_link(String linkText) {
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(linkText)).click();
        pause(1000); // Pausa por 1 segundo
    }

    @When("Clicar na categoria {string}")
    public void clicar_na_categoria(String category) {
        page.getByLabel("LaptopsCategoryTxt").click();
        pause(1000); // Pausa por 1 segundo
    }

    @When("Selecionar o primeiro laptop")
    public void selecionar_o_primeiro_laptop() {
        page.locator("[id=\"\\31 0\"]").click();
        pause(1000); // Pausa por 1 segundo
    }

    @When("Adicionar ao carrinho")
    public void adicionar_ao_carrinho() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("ADD TO CART")).click();
        pause(1000); // Pausa por 1 segundo
    }

    @When("Ir para o checkout")
    public void ir_para_o_checkout() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("CHECKOUT ($1,261.99)")).click();
        pause(1000); // Pausa por 1 segundo
    }

    private void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            // Handle the exception if needed
        }
    }
}