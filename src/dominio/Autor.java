package dominio;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Autor implements Serializable {
    private static final long serialVersionUID = 1L; // Versionado
    
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
    
    public static void cargarAutores() {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("autores.dat"))) {
        listaAutores = (ArrayList<Autor>) ois.readObject();
    } catch (IOException | ClassNotFoundException e) {
        listaAutores = new ArrayList<>();
    }
}


    @Override
    public String toString() {
        return " Nombre: " + this.nombre + " Nacionalidad: " + this.nacionalidad;
    }
    
    static {
        ArrayList<Genero> generos = Genero.obtenerTodosLosGeneros();
    }

}
