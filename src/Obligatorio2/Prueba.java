
package Obligatorio2;

import interfaz.*;
import dominio.*;
import java.io.File;


public class Prueba {
    
 public static void main(String[] args) {
        // Ruta de la carpeta donde se almacenan los archivos .dat
        String directorioDatos = "."; // "." indica el directorio raíz del proyecto; puedes cambiarlo según sea necesario.

        // Verificar si hay al menos un archivo .dat en el directorio
        boolean existenArchivos = verificarArchivosDat(directorioDatos);

        if (existenArchivos) {
            // Si existen los archivos, mostrar VentanaInicio
            VentanaInicio inicio = new VentanaInicio();
            inicio.setVisible(true);
        } else {
            // Si no existen los archivos, mostrar MenuObl directamente
            MenuPrincipal menu = new MenuPrincipal();
            menu.setVisible(true);
        }
    }

       private static boolean verificarArchivosDat(String directorio) {
        File carpeta = new File(directorio);
        if (!carpeta.exists() || !carpeta.isDirectory()) {
            return false; // El directorio no existe o no es válido
        }

        // Filtrar archivos con la extensión .dat
        File[] archivosDat = carpeta.listFiles((dir, name) -> name.endsWith(".dat"));

        // Retornar true si hay al menos un archivo .dat
        return archivosDat != null && archivosDat.length > 0;
    }
}
