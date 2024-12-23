/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaz.consultas;

import dominio.Libro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

/**
 *
 * @author vale_
 */
public class VentanaConsultaLibros extends javax.swing.JFrame {

    /**
     * Creates new form VentanaConsultaLibros
     */
    public VentanaConsultaLibros() {
        initComponents();
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
        txtGenero = new javax.swing.JTextField();
        txtTitulo = new javax.swing.JTextField();
        txtAutor = new javax.swing.JTextField();
        lblGenero = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblAutor = new javax.swing.JLabel();
        btnConsultar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelLibros = new javax.swing.JPanel();
        lblNoResultados = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Libros");

        txtAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAutorActionPerformed(evt);
            }
        });

        lblGenero.setText("Género");

        lblTitulo.setText("Título");

        lblAutor.setText("Autor");

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        panelLibros.setLayout(new GridLayout(0, 3, 10, 10));

        javax.swing.GroupLayout panelLibrosLayout = new javax.swing.GroupLayout(panelLibros);
        panelLibros.setLayout(panelLibrosLayout);
        panelLibrosLayout.setHorizontalGroup(
            panelLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLibrosLayout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(lblNoResultados)
                .addContainerGap(308, Short.MAX_VALUE))
        );
        panelLibrosLayout.setVerticalGroup(
            panelLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLibrosLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblNoResultados)
                .addContainerGap(235, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(panelLibros);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo)
                    .addComponent(lblAutor)
                    .addComponent(lblGenero))
                .addGap(156, 156, 156)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtGenero)
                        .addGap(0, 0, 0))
                    .addComponent(txtAutor)
                    .addComponent(txtTitulo)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGenero))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitulo))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAutor))
                .addGap(18, 18, 18)
                .addComponent(btnConsultar)
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(444, 444, 444))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBounds(0, 0, 524, 538);
    }// </editor-fold>//GEN-END:initComponents

    private void txtAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAutorActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        String genero = txtGenero.getText().trim().toLowerCase();
        String titulo = txtTitulo.getText().trim().toLowerCase();
        String autor = txtAutor.getText().trim().toLowerCase();

        if (genero.isEmpty() && titulo.isEmpty() && autor.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese al menos un criterio de búsqueda.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        panelLibros.removeAll();
        lblNoResultados.setVisible(false);

        panelLibros.setLayout(new GridLayout(0, 3, 10, 10));

        long resultados = Libro.obtenerLibros().stream()
                .filter(libro -> {
                    return (genero.isEmpty() || libro.getGenero().getNombre().toLowerCase().contains(genero))
                            && (titulo.isEmpty() || libro.getTitulo().toLowerCase().contains(titulo))
                            && (autor.isEmpty() || libro.getAutor().getNombre().toLowerCase().contains(autor));
                })
                .peek(libro -> {
                    JButton nuevo = new JButton();
                    ImageIcon imagen = Libro.obtenerImagenPorISBN(libro.getIsbn());

                    if (imagen != null) {
                        nuevo.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(100, 150, java.awt.Image.SCALE_SMOOTH)));
                    } else {
                        nuevo.setText(libro.getTitulo());
                    }

                    nuevo.addActionListener(new LibroListener(libro));
                    panelLibros.add(nuevo);
                })
                .count();

        if (resultados == 0) {
            lblNoResultados.setVisible(true);
        } else {
            lblNoResultados.setVisible(false);
        }

        panelLibros.revalidate();
        panelLibros.repaint();

        txtGenero.setText("");
        txtTitulo.setText("");
        txtAutor.setText("");
    }//GEN-LAST:event_btnConsultarActionPerformed

    private class LibroListener implements ActionListener {

        private final Libro libro;

        public LibroListener(Libro libro) {
            this.libro = libro;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(VentanaConsultaLibros.this,
                    "Título: " + libro.getTitulo() + "\n"
                    + "Autor: " + libro.getAutor().getNombre() + "\n"
                    + "Género: " + libro.getGenero().getNombre() + "\n"
                    + "Precio: $" + libro.getPrecioVenta() + "\n"
                    + "Stock: " + libro.getStock(),
                    "Información del Libro",
                    JOptionPane.INFORMATION_MESSAGE);
        }
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
            java.util.logging.Logger.getLogger(VentanaConsultaLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaConsultaLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaConsultaLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaConsultaLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaConsultaLibros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAutor;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblNoResultados;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelLibros;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtGenero;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
