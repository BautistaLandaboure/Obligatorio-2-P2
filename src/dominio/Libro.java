package dominio;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

// faltaria lo de la imagen
public class Libro implements Serializable {

    private static final long serialVersionUID = 1L;

    private Editorial editorial;
    private Genero genero;
    private Autor autor;
    private String isbn;
    private String titulo;
    private double precioCosto;
    private double precioVenta;
    private int stock;
    private static List<Libro> listaLibros = new ArrayList<>();
    private static final String ARCHIVO_LIBROS = "libros.dat";

    public Libro(Editorial editorial, Genero genero, Autor autor, String isbn, String titulo,
            double precioCosto, double precioVenta, int stock) {

        this.editorial = editorial;
        this.genero = genero;
        this.autor = autor;
        this.isbn = isbn;
        this.titulo = titulo;
        this.precioCosto = precioCosto;
        this.precioVenta = precioVenta;
        this.stock = stock;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(double precioCosto) {
        this.precioCosto = precioCosto;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public static void guardarLibros() {
        Sistema.guardarObjeto(ARCHIVO_LIBROS, listaLibros);
    }

    public static void cargarLibros() {
        listaLibros = Sistema.cargarObjeto(ARCHIVO_LIBROS, new ArrayList<>());
    }

    public static boolean agregarLibro(Libro libro) {

        for (Libro l : listaLibros) {
            if (l.getIsbn().equals(libro.getIsbn())) {
                return false;
            }
        }
        listaLibros.add(libro);
        return true;
    }

    public static List<Libro> obtenerLibros() {
        return new ArrayList<>(listaLibros);
    }

    @Override
    public String toString() {
        return titulo;
    }

    public static ImageIcon obtenerImagenPorISBN(String isbn) {

        String rutaImagen = "imagenes/" + isbn + ".jpg";
        File archivoImagen = new File(rutaImagen);

        if (archivoImagen.exists()) {
            System.out.println("Imagen encontrada en: " + archivoImagen.getAbsolutePath());
            return new ImageIcon(archivoImagen.getAbsolutePath());
        } else {
            System.out.println("Imagen no encontrada en: " + archivoImagen.getAbsolutePath());
            return null;
        }
    }

    public static Libro obtenerLibroPorIsbn(String isbn) {
        for (Libro libro : listaLibros) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }

    static {
        cargarLibros();
    }
}
