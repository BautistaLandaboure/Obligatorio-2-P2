package dominio;

import java.util.ArrayList;

public class Genero {

    private String nombre;
    private String descripcion;
    private static ArrayList<Genero> generosRegistrados = new ArrayList<>();

    public Genero(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
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

    @Override
    public String toString() {
        return "Genero: " + nombre + " descripcion: " + descripcion; // Formato para la JList
    }

}
