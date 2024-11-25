package interfaz.registro;

import dominio.Autor;
import dominio.Genero;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

public class VentanaAutor extends javax.swing.JFrame {

    public VentanaAutor() {
        initComponents();
        cargarGeneros();
        lstGenerosAutor.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        Autor.cargarAutores();
        objetoAPantalla();
    }

    private void cargarGeneros() {
        DefaultListModel<String> model = new DefaultListModel<>();
        for (Genero genero : Genero.getGenerosRegistrados()) {
            model.addElement(genero.getNombre());
        }
        lstGenerosAutor.setModel(model);
    }

    private String[] obtenerAutores() {
        return Autor.obtenerTodosLosAutores().stream()
                .map(Autor::toString) 
                .toArray(String[]::new);
    }

    private void objetoAPantalla() {
        lstAutores.setListData(obtenerAutores()); 
    }

    private boolean existeAutor(String nombre) {
        return Autor.obtenerTodosLosAutores().stream()
                .anyMatch(a -> a.getNombre().equalsIgnoreCase(nombre)); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAutor = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstGenerosAutor = new javax.swing.JList<>();
        btnAgregar = new javax.swing.JButton();
        lblGenerosAutor = new javax.swing.JLabel();
        lblNacionalidadAutor = new javax.swing.JLabel();
        txtNacionalidadAutor = new javax.swing.JTextField();
        txtNombreAutor = new javax.swing.JTextField();
        lblNombreAutor = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstAutores = new javax.swing.JList<>();
        lblAutoresRegistrados = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Autor");
        getContentPane().setLayout(null);

        panelAutor.setLayout(null);

        lstGenerosAutor.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lstGenerosAutor);

        panelAutor.add(jScrollPane1);
        jScrollPane1.setBounds(110, 120, 220, 110);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        panelAutor.add(btnAgregar);
        btnAgregar.setBounds(110, 250, 220, 25);

        lblGenerosAutor.setText("Géneros");
        panelAutor.add(lblGenerosAutor);
        lblGenerosAutor.setBounds(0, 120, 90, 15);

        lblNacionalidadAutor.setText("Nacionalidad");
        panelAutor.add(lblNacionalidadAutor);
        lblNacionalidadAutor.setBounds(0, 70, 100, 20);
        panelAutor.add(txtNacionalidadAutor);
        txtNacionalidadAutor.setBounds(110, 70, 220, 19);

        txtNombreAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreAutorActionPerformed(evt);
            }
        });
        panelAutor.add(txtNombreAutor);
        txtNombreAutor.setBounds(110, 30, 220, 19);

        lblNombreAutor.setText("Nombre del autor");
        panelAutor.add(lblNombreAutor);
        lblNombreAutor.setBounds(0, 30, 220, 20);

        lstAutores.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(lstAutores);

        panelAutor.add(jScrollPane2);
        jScrollPane2.setBounds(360, 30, 180, 250);

        lblAutoresRegistrados.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        lblAutoresRegistrados.setText("Autores Registrados");
        panelAutor.add(lblAutoresRegistrados);
        lblAutoresRegistrados.setBounds(360, 10, 160, 15);

        getContentPane().add(panelAutor);
        panelAutor.setBounds(30, 20, 540, 280);

        setBounds(0, 0, 623, 356);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreAutorActionPerformed

    }//GEN-LAST:event_txtNombreAutorActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
 String nombre = txtNombreAutor.getText().trim();
    String nacionalidad = txtNacionalidadAutor.getText().trim();
    java.util.List<String> generosSeleccionados = lstGenerosAutor.getSelectedValuesList();

    if (nombre.isEmpty() || nacionalidad.isEmpty() || generosSeleccionados.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos y seleccione al menos un género.");
        return;
    }

    if (existeAutor(nombre)) {
        JOptionPane.showMessageDialog(this, "El autor ya existe.", "Error", JOptionPane.WARNING_MESSAGE);
        return;
    }

    ArrayList<Genero> generosEscritos = new ArrayList<>();
    for (String generoNombre : generosSeleccionados) {
        Genero genero = Genero.getGenerosRegistrados().stream()
                .filter(g -> g.getNombre().equalsIgnoreCase(generoNombre))
                .findFirst()
                .orElse(null);
        if (genero != null) {
            generosEscritos.add(genero);
        }
    }

    // Crea un nuevo autor y agrégalo a la lista global.
    Autor nuevoAutor = new Autor(nombre, nacionalidad, generosEscritos);
    Autor.obtenerTodosLosAutores().add(nuevoAutor);

    // Guarda la lista actualizada de autores.
    Autor.guardarAutores();

    // Actualiza la interfaz gráfica.
    objetoAPantalla();

    // Limpia los campos de entrada.
    txtNombreAutor.setText("");
    txtNacionalidadAutor.setText("");
    lstGenerosAutor.clearSelection();
    }//GEN-LAST:event_btnAgregarActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAutoresRegistrados;
    private javax.swing.JLabel lblGenerosAutor;
    private javax.swing.JLabel lblNacionalidadAutor;
    private javax.swing.JLabel lblNombreAutor;
    private javax.swing.JList<String> lstAutores;
    private javax.swing.JList<String> lstGenerosAutor;
    private javax.swing.JPanel panelAutor;
    private javax.swing.JTextField txtNacionalidadAutor;
    private javax.swing.JTextField txtNombreAutor;
    // End of variables declaration//GEN-END:variables
}
