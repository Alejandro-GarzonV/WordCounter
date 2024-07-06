package pages;

public class WordCounterPage  extends BasePage{
    
    private String contenedorTexto = "//textarea[@id='box']"; 
    private String contadorPalabras = "//span[@id='word_count']";
    private String contadorCaracter = "//span[@id='character_count']";
    private String repeticionPalabras = "//div[@id='kwd-density']";

    public WordCounterPage() {
        super(driver);
    }

    public void navegarWordCounter(){
        driver.manage().window().maximize();      
        driver.get("https://wordcounter.net/");
    }

    public void ingresarTexto(String texto){
        write(contenedorTexto, texto);
    }

    public String getContadorPalabras() {
        return getTexto(contadorPalabras);
    }

    public String getContadorCaracter() {
        return getTexto(contadorCaracter);
    }

}
