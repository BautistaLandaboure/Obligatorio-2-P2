package dominio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Autor implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nombre;
    private String nacionalidad;
    private ArrayList<Genero> generosEscritos;
    private static ArrayList<Autor> listaAutores = new ArrayList<>();
    private static final String ARCHIVO_AUTORES = "autores.dat";

    public Autor(String nombre, String nacionalidad, ArrayList<Genero> generosEscritos) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.generosEscritos = generosEscritos;
        listaAutores.add(this);
    }

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
        return new ArrayList<>(listaAutores);
    }

    public boolean escribeEnGenero(String nombreGenero) {
        for (Genero genero : generosEscritos) {
            if (genero.getNombre().equalsIgnoreCase(nombreGenero)) {
                return true;
            }
        }
        return false;
    }

    public static void agregarAutor(Autor autor) {
        listaAutores.add(autor);
    }

    public static void eliminarAutor(String nombre) {
        listaAutores.removeIf(a -> a.getNombre().equalsIgnoreCase(nombre));
        guardarAutores();
    }

    @Override
    public String toString() {
        return " Nombre: " + this.nombre + " Nacionalidad: " + this.nacionalidad;
    }

    public static void cargarAutores() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_AUTORES))) {
            listaAutores = (ArrayList<Autor>) ois.readObject();
            System.out.println("Autores cargados correctamente.");
        } catch (IOException | ClassNotFoundException e) {
            listaAutores = new ArrayList<>();
            System.out.println("No se encontraron autores. Archivo vacío o no existe.");
        }
    }

    public static void guardarAutores() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_AUTORES))) {
            oos.writeObject(listaAutores);
            System.out.println("Autores serializados correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
