package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.*;
import java.util.List;


public class BasePage {
    protected static WebDriver driver;

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    static{
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public BasePage (WebDriver driver){
        BasePage.driver = driver;
    }

    public static void navigateTo(String url) {
        driver.get(url);
    }

    public static void closeBrowser(){
        driver.quit();
    }

    private WebElement Find(String locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    public void  write (String locator, String KeyToSend){
        Find(locator).clear();
        Find(locator).sendKeys(KeyToSend);
    }

    public String getTexto(String locator) {
        return Find(locator).getText();
    }

    public String getDensidadPalabras(String locator, int topW) {
        // Crear un StringBuilder para almacenar las palabras y sus respectivos conteos.
        StringBuilder topWords = new StringBuilder();

        // Encontrar los elementos que coinciden con el locator XPath dentro de una lista
        List<WebElement> palabras = driver.findElements(By.xpath(locator));
        
        // Definir un límite para iterar hasta un máximo de # elementos, o menos si hay menos de # elementos.
        int limit = Math.min(palabras.size(), topW);
        for (int i = 0; i < limit; i++) {
            WebElement palabra = palabras.get(i);
            WebElement badgeElement = palabra.findElement(By.className("badge"));
            WebElement wordElement = palabra.findElement(By.className("word"));
            String word = wordElement.getText();
            // Obtener el texto del elemento 'badge', dividirlo por espacios, y extraer solo el número.
            String badgeText = badgeElement.getText().split(" ")[0];
            int count = Integer.parseInt(badgeText);
            if (i > 0) {
                topWords.append(";");
            }
            topWords.append(word).append(",").append(count);
        }
        return topWords.toString();
    }
}
