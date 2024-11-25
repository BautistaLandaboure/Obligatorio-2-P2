/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 *
 * @author vale_
 */
public class Sistema {

    public static <T> void guardarObjeto(String rutaArchivo, T objeto) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            oos.writeObject(objeto);
            System.out.println("Datos guardados correctamente en: " + rutaArchivo);
        } catch (IOException e) {
            System.err.println("Error al guardar los datos en: " + rutaArchivo);
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T cargarObjeto(String rutaArchivo, T valorPorDefecto) {
        File archivo = new File(rutaArchivo);
        if (archivo.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
                return (T) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Error al cargar los datos desde: " + rutaArchivo);
                e.printStackTrace();
            }
        }
        System.out.println("Archivo no encontrado o vacío: " + rutaArchivo + ". Se usará valor por defecto.");
        return valorPorDefecto;
    }
}
