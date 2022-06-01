# Cálculo de Horas Laboradas

## Descripción
Este ejercicio tiene como finalidad desarrollar un software, que dada las horas laboradas por el personal de una empresa, se calcule el promedio de coincidencias en que el personal coincidió al momento de trabajar.

## Como usar el programa
El programa presentado es una aplicación la cual está realizada sobre el lenguaje de programación Java.  
Está hecho siguiendo una arquitectura de tres capas, donde la capa de nivel de datos, se encarga leer desde archivos de texto, y el nivel de aplicación encargada de manejar la lógica del negocio, en este caso el determinar la cantidad coincidencias, la capa de presentación se delega la salida de datos mediante la terminal.  
La lógica implementada en el desarrollo de esta solución se la ejecutó haciendo empleo del patrón de diseño factory method, mediante el uso de interfaces para definir la funcionalidad que serán implementadas por las clases finales.  
La solución presenta la siguiente estructura:  
1. Main.java
2. src:
>
   - accessData: Contiene la lógica para la lectura de los datos desde los archivos
   - logic: Contiene la lógica para resolver el problema de las asistencias
   - models: Contiene clases, bases para estructurar nuestros datos
   - resource: Contiene la clase para leer las configuraciones de la aplicación
   - utils: Contiene clases con métodos comunes a ser usados por la aplicación
 

### Ejecutar el programa

Para ejecutar el programa, hágalo ejecutando el archivo DockerFile con los siguientes pasos:  
1. Ejecute: docker build .  
>    Ejecutado el comando anterior, se le dará un id como el siguiente:  
    image sha256:3055f708fcb25168d01895c1a66613aaf1c840799a1a8bf9d70cc6fc376daf04  
      
    Nota: El ID solo es lo que se encuentra luego de "image sha256:".  
2. Ejecute: docker run -it <ID>  
   Este comando permitirá ejecutar el programa exponiendo las salidas en la terminal.