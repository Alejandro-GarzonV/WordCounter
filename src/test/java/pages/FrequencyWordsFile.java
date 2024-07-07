package pages;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedWriter;
import java.io.FileWriter;


public class FrequencyWordsFile {
    
    private String texto;

    public void cargarArchivo(String rutaArchivo) throws IOException {
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        }
        texto = contenido.toString();
    }

    public int contarPalabras() {
        if (texto == null || texto.isEmpty()) {
            return 0;
        }
        String[] palabras = texto.split("\\s+");
        return palabras.length;
    }

    public int contarCaracteres() {
        if (texto == null || texto.isEmpty()) {
            return 0;
        }
        return texto.length();
    }

    public String obtenerHistograma() {
        if (texto == null || texto.isEmpty()) {
            return "";
        }
        Map<String, Integer> frecuenciaPalabras = new HashMap<>();
        String[] palabras = texto.split("\\s+");
        for (String palabra : palabras) {
            frecuenciaPalabras.put(palabra, frecuenciaPalabras.getOrDefault(palabra, 0) + 1);
        }

        StringBuilder histograma = new StringBuilder();
        frecuenciaPalabras.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(entry -> histograma.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n"));
        
        return histograma.toString();
    }

    public int obtenerTotalPalabras() {
        return contarPalabras();
    }

    public int obtenerTotalCaracteres() {
        return contarCaracteres();
    }

    public void guardarEnArchivo(String rutaArchivo, String contenido) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            writer.write(contenido);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
