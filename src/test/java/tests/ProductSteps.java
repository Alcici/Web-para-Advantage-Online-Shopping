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

    @When("Clicar em nossos produtos")
    public void Clicar_em_nossos_produtos() {
        // Procurar em inglês
        if (page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("OUR PRODUCTS")).isVisible()) {
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("OUR PRODUCTS")).click();
        }
        // Procurar em português
        else if (page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("NOSSOS PRODUTOS")).isVisible()) {
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("NOSSOS PRODUTOS")).click();
        }
        // Caso nenhum dos links esteja visível
        else {
            System.out.println("Link 'OUR PRODUCTS' ou 'NOSSOS PRODUTOS' não encontrado.");
        }
    }
    @And("Clicar em oferta especial")
    public void Clicar_em_oferta_especial() {
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("POPULAR ITEMS")).click();
        pause(4000);
    }
    @And("Clicar em itens populares")
    public void Clicar_em_itens_populares() {
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("POPULAR ITEMS")).click();
        pause(3000);
    }
    @Then("Clicar em contact us")
    public void Clicar_em_contact_us() {
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("CONTACT US")).click();
        pause (6000);
    }
    @When("Clicar em pesquisar + resultado da pesquisa")
    public void Clicar_em_pesquisar() {
        page.getByTitle("SEARCH").click();
        pause(2000); // Pausa por 2 segundos

        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search")).press("CapsLock");
        pause(2000); // Pausa por 2 segundos

        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search")).fill("L");
        pause(2000); // Pausa por 2 segundos

        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search")).press("CapsLock");
        pause(2000); // Pausa por 2 segundos

        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search")).fill("La");
        pause(2000); // Pausa por 2 segundos

        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("laptops").setExact(true)).click();
        pause(2000); // Pausa por 2 segundos

        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("HP ENVY - 17T TOUCH LAPTOP $")).click();
        pause(2000); // Pausa por 2 segundos
    }

    private void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            // Handle the exception if needed
        }
    }
}