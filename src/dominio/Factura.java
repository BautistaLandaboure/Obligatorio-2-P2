/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    private static int contadorFacturas = 1;
    private int numeroFactura;
    private String fecha;
    private String cliente;
    private List<String> libros;
    private double precioTotal;
    private static Map<Integer, Factura> facturas = new HashMap<>();
    private static final String ARCHIVO_FACTURAS = "facturas.dat";

    public Factura(String fecha, String cliente, List<String> libros, double precioTotal) {
        this.numeroFactura = contadorFacturas++;
        this.fecha = fecha;
        this.cliente = cliente;
        this.libros = libros;
        this.precioTotal = precioTotal;
        facturas.put(this.numeroFactura, this);
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
        return "Factura #" + numeroFactura
                + "\nFecha: " + fecha
                + "\nCliente: " + cliente
                + "\nLibros: " + libros
                + "\nTotal: $" + precioTotal;
    }

    public static int obtenerSiguienteNumeroFactura() {
        return contadorFacturas;
    }

    public static void guardarFacturas() {
        Sistema.guardarObjeto(ARCHIVO_FACTURAS, facturas);
    }

    public static void cargarFacturas() {
        facturas = Sistema.cargarObjeto(ARCHIVO_FACTURAS, new HashMap<>());
        contadorFacturas = facturas.keySet().stream().max(Integer::compare).orElse(0) + 1;
    }

    public static void agregarFactura(Factura factura) {
        facturas.put(contadorFacturas, factura);

    }

    public static Factura obtenerFactura(int numero) {
        return facturas.get(numero);
    }

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

    public static Map<Integer, Factura> obtenerFacturas() {
        return new HashMap<>(facturas);
    }

    static {
        cargarFacturas();
    }

}
