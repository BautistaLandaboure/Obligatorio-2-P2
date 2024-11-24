package dominio;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

// faltaria lo de la imagen
public class Libro {

    private Editorial editorial;
    private Genero genero;
    private Autor autor;
    private String isbn;
    private String titulo;
    private double precioCosto;
    private double precioVenta;
    private int stock;
    private static List<Libro> listaLibros = new ArrayList<>();
    private static final String IMAGENES_PATH = "../../../imagenes";

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

// Método para agregar un libro
    public static boolean agregarLibro(Libro libro) {
        // Verificar si el ISBN ya existe en la lista de libros
        for (Libro l : listaLibros) {
            if (l.getIsbn().equals(libro.getIsbn())) {
                return false; // ISBN duplicado
            }
        }
        listaLibros.add(libro); // Agregar libro si el ISBN es único
        return true;
    }

    // Método para obtener todos los libros
    public static List<Libro> obtenerLibros() {
        return new ArrayList<>(listaLibros); // Devuelve una copia de la lista, pero los objetos son los mismos
    }

    @Override
    public String toString() {
        return titulo; // Lo que se mostrará en JComboBox u otros componentes
    }

//    public static ImageIcon obtenerImagenPorISBN(String isbn) {
//        String rutaImagen = IMAGENES_PATH + "/" + isbn + ".jpg"; // O usa el formato de tus imágenes
//        System.out.println("rutaImagen " + rutaImagen);
//        File archivoImagen = new File(rutaImagen);
//        if (archivoImagen.exists()) {
//            return new ImageIcon(rutaImagen);
//        } else {
//            return null; // Devuelve null si no se encuentra la imagen
//        }
//    }
public static ImageIcon obtenerImagenPorISBN(String isbn) {
    // Ruta absoluta basada en el directorio actual del proyecto
    String rutaImagen = "imagenes/" + isbn + ".jpg"; // Cambia la extensión según corresponda
    File archivoImagen = new File(rutaImagen);

    if (archivoImagen.exists()) {
        System.out.println("Imagen encontrada en: " + archivoImagen.getAbsolutePath());
        return new ImageIcon(archivoImagen.getAbsolutePath());
    } else {
        System.out.println("Imagen no encontrada en: " + archivoImagen.getAbsolutePath());
        return null; // Devuelve null si no se encuentra
    }
}
    // Inicializar ejemplos
    static {
        // Obtener datos iniciales desde las clases correspondientes
        List<Editorial> editoriales = Editorial.obtenerTodasLasEditoriales();
        List<Genero> generos = Genero.obtenerTodosLosGeneros();
        List<Autor> autores = Autor.obtenerTodosLosAutores();

        // Crear libros de ejemplo
        listaLibros.add(new Libro(editoriales.get(0), generos.get(0), autores.get(0),
                "123456789", "Cien Años de Soledad", 20.0, 30.0, 10));
        listaLibros.add(new Libro(editoriales.get(1), generos.get(3), autores.get(2),
                "987654321", "Harry Potter y la Piedra Filosofal", 15.0, 25.0, 5));
        listaLibros.add(new Libro(editoriales.get(0), generos.get(3), autores.get(2),
                "567890123", "Harry Potter y la Cámara Secreta", 18.0, 28.0, 8));
    }
}
