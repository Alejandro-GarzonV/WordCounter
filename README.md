Instrucciones para Ejecutar el Proyecto
PRE-Requisitos
Git: Asegúrate de tener Git instalado en tu máquina. Puedes descargarlo desde git-scm.com.
Java: Instala el JDK de Java. Puedes descargarlo desde oracle.com o utilizar una distribución como OpenJDK.
Gradle: No es necesario tener Gradle instalado, ya que el proyecto utiliza el wrapper de Gradle (gradlew). Sin embargo, puedes instalarlo si lo prefieres desde gradle.org.

1. Clonar el Repositorio
-Abre la terminal (Command Prompt en Windows, Terminal en macOS/Linux).
-Clona el repositorio utilizando el siguiente comando: git clone https://github.com/Alejandro-GarzonV/WordCounter
-Navega al directorio del proyecto clonado: cd ruta_donde_dejaste_el proyecto y cd WordCounter

2. Ejecutar el Proyecto con Gradle
Para sistemas Unix (Linux, macOS), ejecuta: ./gradlew test
Para sistemas Windows, ejecuta: gradlew.bat test

3.Archivos de Texto de Entrada y Salida
-En la ruta del proyecto src/test/resources/cadenaTexto.txt. Puedes modificar el contenido de este archivo si deseas probar con diferentes textos.
-En la ruta src/test/resources/resultadosHistograma.txt podras visualizar los resultados de lo impreso en consola después de la ejecución de las pruebas.

4.Reporte de Cucumber
-Después de ejecutar las pruebas, Cucumber generará un reporte con la cantidad de escenarios ejecutados, navega al directorio build/reports/tests/test/index.html dentro del proyecto. 
         -Aquí encontrarás el reporte HTML generado por Gradle para las pruebas ejecutadas: cd build/reports/tests/test
         -Abre el archivo index.html en tu navegador preferido para ver el reporte detallado de las pruebas ejecutadas por Gradle.
-(Opcional) En la ruta  https://reports.cucumber.io/report-collections/2e0e5e06-c9d4-4c63-8b08-92f583050510 puedes encontrar los reportes  relacionados  del proyecto, selecciona  el que este  en el rango de tu ejecucion
