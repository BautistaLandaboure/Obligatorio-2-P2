/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.List;

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
}
