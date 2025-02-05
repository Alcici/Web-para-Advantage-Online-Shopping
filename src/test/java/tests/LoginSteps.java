package tests;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Random;
import java.util.UUID;

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
    @Then("criar usuario")
    public void criar_usuario() {
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("CREATE NEW ACCOUNT")).click();
        pause(4000); // Pausa por 4 segundos
        page.locator("input[name=\"usernameRegisterPage\"]").click();
        pause(3000);

        // Gerar nome de usuário aleatório
        String randomUsername = "user_" + UUID.randomUUID().toString().substring(0, 8);
        page.locator("input[name=\"usernameRegisterPage\"]").fill(randomUsername);
        pause(3000);

        // Pausa de 2 segundos antes de gerar o e-mail
        pause(2000);

        // Gerar e-mail aleatório
        String randomEmail = "email_" + UUID.randomUUID().toString().substring(0, 8) + "@example.com";
        page.locator("input[name=\"emailRegisterPage\"]").click();
        page.locator("input[name=\"emailRegisterPage\"]").fill(randomEmail);
        pause(2000);

        // Gerar senha aleatória com letras e números
        String randomPassword = generateRandomPassword(10);
        page.locator("input[name=\"passwordRegisterPage\"]").click();
        page.locator("input[name=\"passwordRegisterPage\"]").fill(randomPassword);
        pause(2000);

        // Colocar a mesma senha gerada no campo de confirmação
        page.locator("input[name=\"confirm_passwordRegisterPage\"]").click();
        page.locator("input[name=\"confirm_passwordRegisterPage\"]").fill(randomPassword);
        pause(3000);

        // Clicar em aceite termos
        page.locator("input[name='i_agree']").click();
        pause(1000);

        // Clicar no botão REGISTER
        page.locator("button:has-text('REGISTER')").click();
        pause(6000);
    }

    private String generateRandomPassword(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            password.append(characters.charAt(random.nextInt(characters.length())));
        }

        return password.toString();
    }

    private void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            // Handle the exception if needed
        }
    }
}