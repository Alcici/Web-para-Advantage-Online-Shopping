package tests;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitForSelectorState;

public class OpenSiteTest {
    public static void main(String[] args) {
        // Configurar Playwright
        try (Playwright playwright = Playwright.create()) {
            BrowserType browserType = playwright.chromium();
            Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();

            // Navegar para o site
            page.navigate("https://www.advantageonlineshopping.com/#/");

            // Verificar o título da página
            String title = page.title();
            System.out.println("Título da página: " + title);

            // Clicar no primeiro elemento de busca
            Locator searchIcon = page.locator("svg#menuSearch").first();
            searchIcon.click();

            // Adicionar tempo para visualizar a página
            Thread.sleep(2000); // Pausa por 2 segundos

            // Escrever "MOUSE" no campo de busca
            Locator searchInput = page.locator("input#autoComplete");
            searchInput.type("MOUSE");

            // Adicionar tempo para visualizar a página
            Thread.sleep(5000); // Pausa por 5 segundos

            // Clicar no segundo elemento de imagem duplicado
            Locator imageElement = page.locator("img[data-ng-src='/catalog/fetchImage?image_id=5400']");
            imageElement.click();

            // Adicionar tempo para visualizar a página
            Thread.sleep(5000); // Pausa por 5 segundos

            // Fechar o navegador
            browser.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}