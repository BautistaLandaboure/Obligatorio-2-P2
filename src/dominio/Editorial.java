package dominio;


import java.util.ArrayList;

public class Editorial {
    
    private String nombre;
    private String paisOrigen;
     private static ArrayList<Editorial> listaEditoriales = new ArrayList<>();

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
        return new ArrayList<>(listaEditoriales); // Retorna una copia para evitar modificaciones externas
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", País: " + paisOrigen;
    }
    
}
