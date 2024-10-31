package dominio;

import java.util.ArrayList;

public class Autor {
    
     private String nombre;
    private String nacionalidad;
    private ArrayList<Genero> generosEscritos;

    public Autor(String nombre, String nacionalidad, ArrayList<Genero> generosEscritos) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.generosEscritos = generosEscritos;
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
   
    @Override
    public String toString(){
        return " Nombre " + this.nombre + " Nacionalidad: " + this.nacionalidad;
    }
    
}
