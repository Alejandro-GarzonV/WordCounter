@Total
Feature: Contador de Frecuencia de Palabras de archivo
  @FWF
  Scenario: Contar la frecuencia de palabras en un archivo de texto y crear un histograma
    Given un usuario carga el archivo de texto "src/test/resources/cadenaTexto.txt"
    When cuenta las palabras, caracteres y se crea el histograma
    Then el usuario visualiza la cantida de palabras,caracteres y el histograma "src/test/resources/resultadosHistograma.txt"