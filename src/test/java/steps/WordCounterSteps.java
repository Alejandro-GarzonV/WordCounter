package steps;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import pages.WordCounterPage;

public class WordCounterSteps {
    
    WordCounterPage wc = new WordCounterPage();
    SoftAssert soft = new SoftAssert();

    @Given ("un usuario navega la pagina wordcounter.net")
    public void naviteToWC(){
        wc.navegarWordCounter();
    }

    @When ("el usuario ingresa el texto {string}")
    public void insertText(String Text){
        wc.ingresarTexto(Text);
    }

    @Then ("entonces visualiza el recuento de palabras en {string}")
    public void seeWords(String expectedCountW){
        soft.assertEquals(wc.getContadorPalabras(),expectedCountW);
        //Assert.assertEquals(wc.getContadorPalabras(),expectedCountW);
    }

    @Then ("visualiza el recuento de caracteres en {string}")
    public void seeCharacters(String expectedCountC){
        soft.assertEquals(wc.getContadorCaracter(),expectedCountC);
        //Assert.assertEquals(wc.getContadorCaracter(),expectedCountC);
    }


}
