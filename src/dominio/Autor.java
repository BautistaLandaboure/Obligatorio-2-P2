//  Valentina Giusti - 199747
// Bautista Landaboure – 316326
package dominio;

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
        listaAutores = Sistema.cargarObjeto(ARCHIVO_AUTORES, new ArrayList<>());
    }

    public static void guardarAutores() {
        Sistema.guardarObjeto(ARCHIVO_AUTORES, listaAutores);
    }

}
