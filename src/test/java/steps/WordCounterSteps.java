package steps;

import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.WordCounterPage;


public class WordCounterSteps {
    
    WordCounterPage wc = new WordCounterPage();

    @Given ("un usuario navega la pagina wordcounter.net")
    public void naviteToWC(){
        wc.navegarWordCounter();
    }

    @When ("el usuario ingresa el texto {string}")
    public void insertText(String Text) throws InterruptedException{
        wc.ingresarTexto(Text);
        //necesario para este paso ya que la pagina demora 3.9 milesimas en cambiar el valor de la etiqueta
        Thread.sleep(500);
    }

    @Then ("entonces visualiza el recuento de palabras en {string}")
    public void seeWords(String expectedCountW){
       Assert.assertEquals(wc.getContadorPalabras(),expectedCountW);
    }

    @Then ("visualiza el recuento de caracteres en {string}")
    public void seeCharacters(String expectedCountC){
        Assert.assertEquals(wc.getContadorCaracter(),expectedCountC);
    }

    @Then ("visualiza el recuento de palabras mas usadas {string}")
    public void densityWords(String expectedDensity){
        String actualDensity = wc.getDensidadPalabrasEnPagina();
        System.out.println("Densidad esperada: " + expectedDensity);
        System.out.println("Densidad actual: " + actualDensity);
        Assert.assertEquals(actualDensity, expectedDensity, "La densidad de palabras coincide exactamente.");
    }
}

