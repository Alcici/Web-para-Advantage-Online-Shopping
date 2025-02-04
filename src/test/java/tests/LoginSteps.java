package tests;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.cucumber.java.en.When;

public class LoginSteps {
    private Page page;

    // Construtor vazio necessário para o Cucumber
    public LoginSteps() {
        this.page = TestSetup.getPage();
    }

    @When("Clicar em usuario")
    public void clicar_em_usuario() {
        page.getByLabel("UserMenu").click();
        pause(2000); // Pausa por 2 segundos
    }

    @When("Acessar conta login")
    public void acessar_conta_login() {
        pause(2000); // Pausa por 2 segundos

        page.locator("input[name='username']").fill("lucasalcici");
        pause(1000); // Pausa por 1 segundo

        page.locator("label").filter(new Locator.FilterOptions().setHasText("Password")).click();
        pause(1000); // Pausa por 1 segundo

        page.locator("input[name='password']").press("CapsLock");
        pause(1000); // Pausa por 1 segundo

        page.locator("input[name='password']").fill("L");
        pause(1000); // Pausa por 1 segundo

        page.locator("input[name='password']").press("CapsLock");
        pause(1000); // Pausa por 1 segundo

        page.locator("input[name='password']").fill("Lu758801");
        pause(1000); // Pausa por 1 segundo

        page.getByRole(AriaRole.CHECKBOX).check();
        pause(1000); // Pausa por 1 segundo

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("SIGN IN")).click();
        pause(5000); // Pausa por 5 segundos
    }

    @When("conta com dados errados")
    public void conta_com_dados_errados() {
        page.locator("input[name='username']").click();
        pause(2000); // Pausa por 2 segundos

        page.locator("input[name='username']").fill("teste");
        pause(2000); // Pausa por 2 segundos

        page.locator("input[name='password']").click();
        pause(2000); // Pausa por 2 segundos

        page.locator("input[name='password']").fill("123");
        pause(2000); // Pausa por 2 segundos

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("SIGN IN")).click();
        pause(4000); // Pausa por 4 segundos
    }

    private void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            // Handle the exception if needed
        }
    }
}