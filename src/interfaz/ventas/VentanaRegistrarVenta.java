/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaz.ventas;

import dominio.Factura;
import dominio.Libro;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author vale_
 */
public class VentanaRegistrarVenta extends javax.swing.JFrame {

    private DefaultListModel<String> librosEnStockModel = new DefaultListModel<>();
    private DefaultListModel<String> librosFacturaModel = new DefaultListModel<>();
    private Map<String, Integer> librosEnFactura = new HashMap<>();

    /**
     * Creates new form VentanaVenta
     */
    public VentanaRegistrarVenta() {
        initComponents();
        Factura.cargarFacturas();
        cargarLibrosEnStock();
        inicializarFactura();
        actualizarNumeroFactura();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblNumeroDeFactura = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblCliente = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstLibrosFactura = new javax.swing.JList<>();
        btnAgregarLibro = new javax.swing.JButton();
        btnQuitarLibro = new javax.swing.JButton();
        btnRegistrarFactura = new javax.swing.JButton();
        btnCancelarFactura = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstLibrosEnStock = new javax.swing.JList<>();
        lblVentas = new javax.swing.JLabel();
        lblLibros = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        txtFtdFecha = new javax.swing.JFormattedTextField();
        lblTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Venta de Libros");
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        lblNumeroDeFactura.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblNumeroDeFactura.setText("Factura:");
        jPanel1.add(lblNumeroDeFactura);
        lblNumeroDeFactura.setBounds(10, 0, 130, 19);

        jLabel1.setText("Fecha:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 30, 130, 15);

        lblCliente.setText("Cliente:");
        jPanel1.add(lblCliente);
        lblCliente.setBounds(310, 30, 50, 15);

        lstLibrosFactura.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lstLibrosFactura);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(310, 80, 200, 150);

        btnAgregarLibro.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnAgregarLibro.setText("->");
        btnAgregarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarLibroActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarLibro);
        btnAgregarLibro.setBounds(220, 110, 70, 40);

        btnQuitarLibro.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnQuitarLibro.setText("<-");
        btnQuitarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarLibroActionPerformed(evt);
            }
        });
        jPanel1.add(btnQuitarLibro);
        btnQuitarLibro.setBounds(220, 170, 70, 40);

        btnRegistrarFactura.setText("Registrar");
        btnRegistrarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarFacturaActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrarFactura);
        btnRegistrarFactura.setBounds(70, 290, 100, 25);

        btnCancelarFactura.setText("Cancelar");
        btnCancelarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarFacturaActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelarFactura);
        btnCancelarFactura.setBounds(360, 300, 100, 25);

        lstLibrosEnStock.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(lstLibrosEnStock);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(10, 80, 190, 150);

        lblVentas.setText("Ventas");
        jPanel1.add(lblVentas);
        lblVentas.setBounds(310, 60, 70, 15);

        lblLibros.setText("Libros");
        jPanel1.add(lblLibros);
        lblLibros.setBounds(10, 60, 60, 15);
        jPanel1.add(txtCliente);
        txtCliente.setBounds(380, 30, 130, 19);

        try {
            txtFtdFecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFtdFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFtdFechaActionPerformed(evt);
            }
        });
        jPanel1.add(txtFtdFecha);
        txtFtdFecha.setBounds(110, 30, 90, 19);

        lblTotal.setText("Total:");
        jPanel1.add(lblTotal);
        lblTotal.setBounds(310, 240, 190, 15);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(30, 20, 570, 400);

        setBounds(0, 0, 665, 479);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarLibroActionPerformed

        int selectedIndex = lstLibrosEnStock.getSelectedIndex();
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un libro de la lista en stock.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String libroSeleccionado = librosEnStockModel.get(selectedIndex);
        String isbn = libroSeleccionado.split(" - ")[0];
        Libro libro = Libro.obtenerLibros().stream()
                .filter(l -> l.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);

        if (libro == null) {
            JOptionPane.showMessageDialog(this, "No se encontró información del libro seleccionado.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        librosEnFactura.put(isbn, librosEnFactura.getOrDefault(isbn, 0) + 1);

        librosFacturaModel.clear();
        for (Map.Entry<String, Integer> entry : librosEnFactura.entrySet()) {
            String isbnFactura = entry.getKey();
            int cantidad = entry.getValue();

            Libro libroFactura = Libro.obtenerLibros().stream()
                    .filter(l -> l.getIsbn().equals(isbnFactura))
                    .findFirst()
                    .orElse(null);

            if (libroFactura != null) {
                String facturaItem = cantidad + " - " + libroFactura.getTitulo() + " - $" + libroFactura.getPrecioVenta();
                librosFacturaModel.addElement(facturaItem);
            }
        }

        lstLibrosFactura.setModel(librosFacturaModel);

        actualizarTotalFactura();
    }//GEN-LAST:event_btnAgregarLibroActionPerformed

    private void btnQuitarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarLibroActionPerformed

        int selectedIndex = lstLibrosFactura.getSelectedIndex();
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un libro de la lista de la factura.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String libroSeleccionado = librosFacturaModel.get(selectedIndex);
        String[] partes = libroSeleccionado.split(" - ");
        if (partes.length < 3) {
            JOptionPane.showMessageDialog(this, "Formato de libro seleccionado inválido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String titulo = partes[1];
        Libro libro = Libro.obtenerLibros().stream()
                .filter(l -> l.getTitulo().equals(titulo))
                .findFirst()
                .orElse(null);

        if (libro == null) {
            JOptionPane.showMessageDialog(this, "No se encontró información del libro seleccionado.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String isbn = libro.getIsbn();

        if (!librosEnFactura.containsKey(isbn)) {
            JOptionPane.showMessageDialog(this, "El libro seleccionado no se encuentra en la factura.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int cantidadActual = librosEnFactura.get(isbn);
        if (cantidadActual > 1) {
            librosEnFactura.put(isbn, cantidadActual - 1);
        } else {
            librosEnFactura.remove(isbn);
        }

        librosFacturaModel.clear();
        for (Map.Entry<String, Integer> entry : librosEnFactura.entrySet()) {
            String isbnFactura = entry.getKey();
            int cantidad = entry.getValue();

            Libro libroFactura = Libro.obtenerLibros().stream()
                    .filter(l -> l.getIsbn().equals(isbnFactura))
                    .findFirst()
                    .orElse(null);

            if (libroFactura != null) {
                String facturaItem = cantidad + " - " + libroFactura.getTitulo() + " - $" + libroFactura.getPrecioVenta();
                librosFacturaModel.addElement(facturaItem);
            }
        }

        lstLibrosFactura.setModel(librosFacturaModel);
        actualizarTotalFactura();
    }//GEN-LAST:event_btnQuitarLibroActionPerformed

    private void btnRegistrarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarFacturaActionPerformed
        if (librosEnFactura.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay libros en la factura. Agregue libros antes de registrar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String fecha = txtFtdFecha.getText().trim();
        String cliente = txtCliente.getText().trim();

        if (fecha.length() != 10 || !fecha.matches("\\d{2}/\\d{2}/\\d{4}")) {
            JOptionPane.showMessageDialog(this, "Ingrese una fecha válida en el formato dd/MM/yyyy.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double precioTotal = 0.0;
        List<String> libros = new ArrayList<>();
        StringBuilder advertencias = new StringBuilder("Advertencias:\n");
        boolean huboAdvertencias = false;

        for (Map.Entry<String, Integer> entry : librosEnFactura.entrySet()) {
            String isbn = entry.getKey();
            int cantidadSolicitada = entry.getValue();

            Libro libro = Libro.obtenerLibros().stream()
                    .filter(l -> l.getIsbn().equals(isbn))
                    .findFirst()
                    .orElse(null);

            if (libro != null) {
                int stockDisponible = libro.getStock();

                int cantidadAAgregar = Math.min(cantidadSolicitada, stockDisponible);
                if (cantidadAAgregar < cantidadSolicitada) {
                    huboAdvertencias = true;
                    advertencias.append("- ").append(libro.getTitulo())
                            .append(": solicitados ").append(cantidadSolicitada)
                            .append(", agregados ").append(cantidadAAgregar)
                            .append(" por falta de stock.\n");
                }

                if (cantidadAAgregar > 0) {
                    libro.setStock(stockDisponible - cantidadAAgregar);
                    libros.add(cantidadAAgregar + "x " + libro.getTitulo());
                    precioTotal += libro.getPrecioVenta() * cantidadAAgregar;
                }
            }
        }

        if (libros.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se pudo registrar la factura. No hay suficiente stock disponible para los libros seleccionados.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (huboAdvertencias) {
            JOptionPane.showMessageDialog(this, advertencias.toString(), "Advertencias", JOptionPane.WARNING_MESSAGE);
        }

        Factura nuevaFactura = new Factura(fecha, cliente, libros, precioTotal);
        Factura.agregarFactura(nuevaFactura);
        Factura.guardarFacturas();

        JOptionPane.showMessageDialog(this, nuevaFactura.toString(), "Factura Registrada", JOptionPane.INFORMATION_MESSAGE);

        actualizarNumeroFactura();
        inicializarFactura();
        txtFtdFecha.setText("");
        txtCliente.setText("");
        cargarLibrosEnStock();
        lblTotal.setText("Total: $0.00");
    }//GEN-LAST:event_btnRegistrarFacturaActionPerformed

    private void txtFtdFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFtdFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFtdFechaActionPerformed

    private void btnCancelarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarFacturaActionPerformed

        inicializarFactura();
        txtCliente.setText("");
        txtFtdFecha.setText("");
        lblTotal.setText("Total: $0.00");
        cargarLibrosEnStock();

        this.dispose();
    }//GEN-LAST:event_btnCancelarFacturaActionPerformed
    private void cargarLibrosEnStock() {
        librosEnStockModel.clear();

        List<Libro> librosEnStock = Libro.obtenerLibros().stream()
                .filter(libro -> libro.getStock() > 0)
                .collect(Collectors.toList());

        librosEnStock.sort(Comparator.comparing(Libro::getTitulo));

        for (Libro libro : librosEnStock) {
            librosEnStockModel.addElement(libro.getIsbn() + " - " + libro.getTitulo());
        }

        lstLibrosEnStock.setModel(librosEnStockModel);
    }

    private void inicializarFactura() {
        librosFacturaModel.clear();
        lstLibrosFactura.setModel(librosFacturaModel);
        librosEnFactura.clear();
    }

    private void actualizarNumeroFactura() {
        lblNumeroDeFactura.setText("Factura: " + Factura.obtenerSiguienteNumeroFactura());
    }

    private void actualizarTotalFactura() {
        double total = 0.0;

        for (Map.Entry<String, Integer> entry : librosEnFactura.entrySet()) {
            String isbn = entry.getKey();
            int cantidad = entry.getValue();

            Libro libro = Libro.obtenerLibros().stream()
                    .filter(l -> l.getIsbn().equals(isbn))
                    .findFirst()
                    .orElse(null);

            if (libro != null) {
                total += libro.getPrecioVenta() * cantidad;
            }
        }

        lblTotal.setText("Total: $" + String.format("%.2f", total));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistrarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistrarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistrarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistrarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaRegistrarVenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarLibro;
    private javax.swing.JButton btnCancelarFactura;
    private javax.swing.JButton btnQuitarLibro;
    private javax.swing.JButton btnRegistrarFactura;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblLibros;
    private javax.swing.JLabel lblNumeroDeFactura;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblVentas;
    private javax.swing.JList<String> lstLibrosEnStock;
    private javax.swing.JList<String> lstLibrosFactura;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JFormattedTextField txtFtdFecha;
    // End of variables declaration//GEN-END:variables
}
