package steps;
import org.testng.Assert;
import java.io.IOException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.FrequencyWordsFile;


public class FrequencyWordsFileSteps {
    
    private FrequencyWordsFile fwf = new FrequencyWordsFile();
    
    private int contadorPalabras;
    private int contadorCaracteres;
    private String histograma;

    @Given("un usuario carga el archivo de texto {string}")
    public void cargarArchivo(String rutaArchivo) throws IOException {
        fwf.cargarArchivo(rutaArchivo);
    }

    @When("cuenta las palabras, caracteres y se crea el histograma")
    public void contarPalabrasCaracteresHistograma() {
        contadorPalabras = fwf.obtenerTotalPalabras();
        contadorCaracteres = fwf.obtenerTotalCaracteres();
        histograma = fwf.obtenerHistograma();
    }

    @Then("el usuario visualiza la cantida de palabras,caracteres y el histograma {string}")
    public void verificarHistograma(String rutaArchivo) throws IOException {
    
       System.out.println("Cantidad de palabras: " + contadorPalabras);
       System.out.println("Cantidad de caracteres: " + contadorCaracteres);
       System.out.println("\nHistograma de palabras:"); 
       System.out.println(histograma);

        // Guardar en archivo
        String contenidoArchivo = "Cantidad de palabras: " + contadorPalabras + "\n" +
                                  "Cantidad de caracteres: " + contadorCaracteres + "\n" +
                                  "\nHistograma de palabras:\n" + histograma;
        fwf.guardarEnArchivo(rutaArchivo, contenidoArchivo);
 
        
        Assert.assertNotEquals(contadorPalabras, 0, "El conteo de palabras no debe ser cero.");
        Assert.assertNotEquals(contadorCaracteres, 0, "El conteo de caracteres no debe ser cero.");
        Assert.assertFalse(histograma.isEmpty(), "El histograma no debe estar vacío.");

   }

}
