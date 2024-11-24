
package interfaz.registro;

import dominio.Autor;
import dominio.Genero;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;


public class VentanaAutor extends javax.swing.JFrame  {
    
 private ArrayList<Autor> autoresRegistrados = new ArrayList<>();

   public VentanaAutor(){
       initComponents();
        cargarGeneros();
         lstGenerosAutor.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); 
       // hay que apretar control para poder selecionar varios elementos a la vez;
         objetoAPantalla();
   }
   
private void cargarGeneros() {
    DefaultListModel<String> model = new DefaultListModel<>();
    for (Genero genero : Genero.getGenerosRegistrados()) {
        model.addElement(genero.getNombre());
    }
    lstGenerosAutor.setModel(model); // Asigna el modelo actualizado a la lista
}
   
    private void objetoAPantalla() {
        lstAutores.setListData(obtenerAutores());
    }
   
    private String[] obtenerAutores() {
        String[] autoresArray = new String[autoresRegistrados.size()];
        for (int i = 0; i < autoresRegistrados.size(); i++) {
            autoresArray[i] = autoresRegistrados.get(i).toString();
        }
        return autoresArray;
    }
    
     private boolean existeAutor(String nombre) {
        for (Autor autor : autoresRegistrados) {
            if (autor.getNombre().equalsIgnoreCase(nombre)) {
                return true; // Autor ya existe
            }
        }
        return false; // Autor no existe
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombreAutor = new javax.swing.JLabel();
        txtNombreAutor = new javax.swing.JTextField();
        txtNacionalidadAutor = new javax.swing.JTextField();
        lblNacionalidadAutor = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstGenerosAutor = new javax.swing.JList<>();
        lblGenerosAutor = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstAutores = new javax.swing.JList<>();
        lblAutoresRegistrados = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro de autor");
        getContentPane().setLayout(null);

        lblNombreAutor.setText("Nombre del autor");
        getContentPane().add(lblNombreAutor);
        lblNombreAutor.setBounds(10, 20, 220, 20);

        txtNombreAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreAutorActionPerformed(evt);
            }
        });
        getContentPane().add(txtNombreAutor);
        txtNombreAutor.setBounds(140, 20, 220, 19);
        getContentPane().add(txtNacionalidadAutor);
        txtNacionalidadAutor.setBounds(140, 80, 220, 19);

        lblNacionalidadAutor.setText("Nacionalidad");
        getContentPane().add(lblNacionalidadAutor);
        lblNacionalidadAutor.setBounds(10, 80, 100, 20);

        lstGenerosAutor.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lstGenerosAutor);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(140, 140, 220, 139);

        lblGenerosAutor.setText("Generos");
        getContentPane().add(lblGenerosAutor);
        lblGenerosAutor.setBounds(10, 140, 90, 15);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar);
        btnAgregar.setBounds(140, 310, 220, 25);

        lstAutores.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(lstAutores);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(420, 40, 250, 139);

        lblAutoresRegistrados.setText("Autores registrados");
        getContentPane().add(lblAutoresRegistrados);
        lblAutoresRegistrados.setBounds(420, 20, 160, 15);

        setBounds(0, 0, 733, 426);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreAutorActionPerformed
       
    }//GEN-LAST:event_txtNombreAutorActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String nombre = txtNombreAutor.getText().trim();
        String nacionalidad = txtNacionalidadAutor.getText().trim();
        java.util.List<String> generosSeleccionados = lstGenerosAutor.getSelectedValuesList();

        if (!nombre.isEmpty() && !nacionalidad.isEmpty() && !generosSeleccionados.isEmpty()) {
            if (existeAutor(nombre)) {
                JOptionPane.showMessageDialog(this, "El autor ya existe.", "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Convertir la lista de strings a una lista de objetos Genero
            ArrayList<Genero> generosEscritos = new ArrayList<>();
            for (String generoNombre : generosSeleccionados) {
                // Agregar una descripción genérica por ahora
                generosEscritos.add(new Genero(generoNombre, "Descripción genérica"));
            }

            // Crear y agregar el nuevo autor
            Autor autor = new Autor(nombre, nacionalidad, generosEscritos);
            autoresRegistrados.add(autor);

            // Actualizar la lista en pantalla
            objetoAPantalla();

            // Limpiar campos después de agregar
            txtNombreAutor.setText("");
            txtNacionalidadAutor.setText("");
            lstGenerosAutor.clearSelection();
        } else {
            // Mostrar un mensaje de error si faltan campos
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos y seleccione al menos un género.");
        }

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
           //     new VentanaAutor().setVisible(true);
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
    private javax.swing.JTextField txtNacionalidadAutor;
    private javax.swing.JTextField txtNombreAutor;
    // End of variables declaration//GEN-END:variables
}
