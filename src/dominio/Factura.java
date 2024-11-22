/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author vale_
 */
public class Factura {
    private static int contadorFacturas = 1; // Contador estático para asignar IDs únicos
    private int numeroFactura;
    private String fecha;
    private String cliente;
    private List<String> libros; // Lista de títulos de los libros
    private double precioTotal;
       private static Map<Integer, Factura> facturas = new HashMap<>();


    public Factura(String fecha, String cliente, List<String> libros, double precioTotal) {
        this.numeroFactura = contadorFacturas++;
        this.fecha = fecha;
        this.cliente = cliente;
        this.libros = libros;
        this.precioTotal = precioTotal;
    }

    // Getters y Setters
    public int getNumeroFactura() {
        return numeroFactura;
    }

    public String getFecha() {
        return fecha;
    }

    public String getCliente() {
        return cliente;
    }

    public List<String> getLibros() {
        return libros;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    @Override
    public String toString() {
        return "Factura #" + numeroFactura + 
               "\nFecha: " + fecha + 
               "\nCliente: " + cliente + 
               "\nLibros: " + libros + 
               "\nTotal: $" + precioTotal;
    }
    
     public static void agregarFactura(int numero, Factura factura) {
        facturas.put(numero, factura);
    }

    // Obtener una factura por su número
    public static Factura obtenerFactura(int numero) {
        return facturas.get(numero);
    }

    // Eliminar una factura por su número
    public static void eliminarFactura(int numero) {
        facturas.remove(numero);
    }
    
    public static void imprimirFacturas() {
    if (facturas.isEmpty()) {
        System.out.println("No hay facturas registradas.");
    } else {
        System.out.println("Facturas registradas:");
        for (Map.Entry<Integer, Factura> entry : facturas.entrySet()) {
            System.out.println("Número: " + entry.getKey() + " -> " + entry.getValue());
        }
    }
}
}
