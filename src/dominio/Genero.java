package dominio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Genero implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nombre;
    private String descripcion;
    private static ArrayList<Genero> generosRegistrados = new ArrayList<>();
    private static final String ARCHIVO_GENEROS = "generos.dat";

    public Genero(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        generosRegistrados.add(this);
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public static ArrayList<Genero> getGenerosRegistrados() {
        return generosRegistrados;
    }

    public static void agregarGenero(Genero genero) {
        generosRegistrados.add(genero);
    }

    public static ArrayList<Genero> obtenerTodosLosGeneros() {
        return new ArrayList<>(generosRegistrados); // Retorna una copia para evitar modificaciones externas
    }

    @Override
    public String toString() {
        return "Genero: " + nombre + " descripcion: " + descripcion; // Formato para la JList
    }

    public static void guardarGeneros() {
 try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_GENEROS))) {
        oos.writeObject(generosRegistrados);
        System.out.println("Géneros guardados correctamente. Cantidad: " + generosRegistrados.size());
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    public static void cargarGeneros() {
        File archivo = new File(ARCHIVO_GENEROS);
        if (archivo.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
                generosRegistrados = (ArrayList<Genero>) ois.readObject();
                System.out.println("Géneros cargados correctamente.");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    static {
        cargarGeneros(); // Carga los géneros desde el archivo

    }

}
