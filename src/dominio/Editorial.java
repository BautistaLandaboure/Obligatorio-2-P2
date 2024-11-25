package dominio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Editorial implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nombre;
    private String paisOrigen;
    private static ArrayList<Editorial> listaEditoriales = new ArrayList<>();
    private static final String ARCHIVO_EDITORIALES = "editoriales.dat";

    public Editorial(String nombre, String paisOrigen) {
        this.nombre = nombre;
        this.paisOrigen = paisOrigen;
        listaEditoriales.add(this);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public static ArrayList<Editorial> obtenerTodasLasEditoriales() {
        return new ArrayList<>(listaEditoriales);
    }

    public static void guardarEditoriales() {
        Sistema.guardarObjeto(ARCHIVO_EDITORIALES, listaEditoriales);
    }

    public static void cargarEditoriales() {
        listaEditoriales = Sistema.cargarObjeto(ARCHIVO_EDITORIALES, new ArrayList<>());
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", País: " + paisOrigen;
    }

    static {
        cargarEditoriales();
    }
}
