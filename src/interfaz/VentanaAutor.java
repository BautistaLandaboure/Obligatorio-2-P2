
package interfaz;

import dominio.Autor;
import dominio.Genero;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;


public class VentanaAutor extends javax.swing.JFrame  {
    
     private DefaultListModel<String> autoresModel;



   public VentanaAutor(){
       initComponents();
        cargarGeneros();
         lstGenerosAutor.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); 
       // hay que apretar control para poder selecionar varios elementos a la vez;
        autoresModel = new DefaultListModel<>();
        lstAutores.setModel(autoresModel);
   }
   
   private void cargarGeneros() {
        // Crear un modelo de lista con géneros predefinidos
        DefaultListModel<String> model = new DefaultListModel<>();
        model.addElement("Ficción");
        model.addElement("No Ficción");
        model.addElement("Poesía");
        model.addElement("Drama");
        model.addElement("Misterio");

        // Asignar el modelo a la JList
        lstGenerosAutor.setModel(model);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
        txtNombreAutor.setBounds(140, 20, 220, 23);
        getContentPane().add(txtNacionalidadAutor);
        txtNacionalidadAutor.setBounds(140, 80, 220, 23);

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
        jScrollPane1.setBounds(140, 140, 220, 140);

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
        btnAgregar.setBounds(140, 310, 220, 23);

        lstAutores.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(lstAutores);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(420, 40, 250, 140);

        lblAutoresRegistrados.setText("Autores registrados");
        getContentPane().add(lblAutoresRegistrados);
        lblAutoresRegistrados.setBounds(420, 20, 160, 15);

        setBounds(0, 0, 774, 637);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreAutorActionPerformed
       
    }//GEN-LAST:event_txtNombreAutorActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
            String nombre = txtNombreAutor.getText().trim();
        String nacionalidad = txtNacionalidadAutor.getText().trim();
        java.util.List<String> generosSeleccionados = lstGenerosAutor.getSelectedValuesList();

        if (!nombre.isEmpty() && !nacionalidad.isEmpty() && !generosSeleccionados.isEmpty()) {
            // Convertir la lista de strings a una lista de objetos Genero
            ArrayList<Genero> generosEscritos = new ArrayList<>();
            for (String generoNombre : generosSeleccionados) {
                generosEscritos.add(new Genero(generoNombre, "Descripción genérica")); // Asegúrate de que Genero tenga un constructor que acepte un String
            }

            // Crear y agregar el nuevo autor
            Autor autor = new Autor(nombre, nacionalidad, generosEscritos);
            autoresModel.addElement(autor.toString());

            // Limpiar campos después de agregar
            txtNombreAutor.setText("");
            txtNacionalidadAutor.setText("");
            lstGenerosAutor.clearSelection();
        } else {
            // Mostrar un mensaje de error si faltan campos
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos y seleccione al menos un género.");
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
