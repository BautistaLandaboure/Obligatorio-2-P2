package dominio;

import java.util.ArrayList;
import java.util.List;

public class Autor {

    private String nombre;
    private String nacionalidad;
    private ArrayList<Genero> generosEscritos;
    private static ArrayList<Autor> listaAutores = new ArrayList<>();

    public Autor(String nombre, String nacionalidad, ArrayList<Genero> generosEscritos) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.generosEscritos = generosEscritos;
        listaAutores.add(this);
    }
    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public ArrayList<Genero> getGenerosEscritos() {
        return generosEscritos;
    }

    public void setGenerosEscritos(ArrayList<Genero> generosEscritos) {
        this.generosEscritos = generosEscritos;
    }

    public static ArrayList<Autor> obtenerTodosLosAutores() {
        return new ArrayList<>(listaAutores); // Retorna una copia para evitar modificaciones externas
    }

    public boolean escribeEnGenero(String nombreGenero) {
        for (Genero genero : generosEscritos) {
            if (genero.getNombre().equalsIgnoreCase(nombreGenero)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return " Nombre " + this.nombre + " Nacionalidad: " + this.nacionalidad;
    }
    // Bloque estático para inicializar autores predefinidos

    static {
        ArrayList<Genero> generos = Genero.obtenerTodosLosGeneros(); // Lista de géneros predefinidos

        new Autor("Gabriel García Márquez", "Colombia", new ArrayList<>(List.of(
                generos.get(0), // Ficción
                generos.get(3) // Fantasía
        )));

        new Autor("Agatha Christie", "Reino Unido", new ArrayList<>(List.of(
                generos.get(4) // Misterio
        )));

        new Autor("J.K. Rowling", "Reino Unido", new ArrayList<>(List.of(
                generos.get(3), // Fantasía
                generos.get(5) // Romance
        )));

        new Autor("Stephen King", "Estados Unidos", new ArrayList<>(List.of(
                generos.get(6), // Terror
                generos.get(0) // Ficción
        )));

        new Autor("Isaac Asimov", "Rusia", new ArrayList<>(List.of(
                generos.get(2) // Ciencia Ficción
        )));
    }

}
