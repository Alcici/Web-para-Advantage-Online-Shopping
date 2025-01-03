package tests;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import io.cucumber.java.After;
import io.cucumber.java.en.*;

public class ProductSteps {
    private Playwright playwright;
    private Browser browser;
    private Page page;

    @Given("Navegar para o site")
    public void navegar_para_o_site() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
        page.navigate("https://www.advantageonlineshopping.com/#/search/?viewAll=computador");
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); } // Pausa por 1 segundo
    }

    @When("Clicar no link {string}")
    public void clicar_no_link(String linkText) {
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(linkText)).click();
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); } // Pausa por 1 segundo
    }

    @When("Clicar na categoria {string}")
    public void clicar_na_categoria(String category) {
        page.getByLabel("LaptopsCategoryTxt").click();
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); } // Pausa por 1 segundo
    }

    @When("Selecionar o primeiro laptop")
    public void selecionar_o_primeiro_laptop() {
        page.locator("[id=\"\\31 0\"]").click();
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); } // Pausa por 1 segundo
    }

    @When("Adicionar ao carrinho")
    public void adicionar_ao_carrinho() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("ADD TO CART")).click();
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); } // Pausa por 1 segundo
    }

    @When("Ir para o checkout")
    public void ir_para_o_checkout() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("CHECKOUT ($1,261.99)")).click();
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); } // Pausa por 1 segundo
    }

    @When("Clicar em usuario")
    public void clicar_em_usuario() {
        page.getByLabel("UserMenu").click();
        try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); } // Pausa por 2 segundos
    }
    @When("Acessar conta login")
    public void Acessar_conta_login() {
        try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); } // Pausa por 2 segundos

        page.locator("input[name='username']").fill("lucasalcici");
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); } // Pausa por 1 segundo

        page.locator("label").filter(new Locator.FilterOptions().setHasText("Password")).click();
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); } // Pausa por 1 segundo

        page.locator("input[name='password']").press("CapsLock");
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); } // Pausa por 1 segundo

        page.locator("input[name='password']").fill("L");
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); } // Pausa por 1 segundo

        page.locator("input[name='password']").press("CapsLock");
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); } // Pausa por 1 segundo

        page.locator("input[name='password']").fill("Lu758801");
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); } // Pausa por 1 segundo

        page.getByRole(AriaRole.CHECKBOX).check();
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); } // Pausa por 1 segundo

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("SIGN IN")).click();

        try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
    }
    @When ("conta com dados errados")
public void conta_com_dados_errados() {
        page.locator("input[name='username']").click();
        try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); } // Pausa por 2 segundos

        page.locator("input[name='username']").fill("teste");
        try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); } // Pausa por 2 segundos

        page.locator("input[name='password']").click();
        try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); } // Pausa por 2 segundos

        page.locator("input[name='password']").fill("123");
        try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); } // Pausa por 2 segundos

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("SIGN IN")).click();
        try { Thread.sleep(4000); } catch (InterruptedException e) { e.printStackTrace(); } // Pausa por 4 segundos
    }
    @After
    public void tearDown() {
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }
}