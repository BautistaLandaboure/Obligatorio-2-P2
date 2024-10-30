
package interfaz;

import dominio.*;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;

public class VentanaGenero extends javax.swing.JFrame {
    

    
    public VentanaGenero() {
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

        lblNombreGenero = new javax.swing.JLabel();
        txtNombreGenero = new javax.swing.JTextField();
        txtDescripcionGenero = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstGenerosRegistrados = new javax.swing.JList<>();
        txtGenerosRegistrados = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ventana registro de genero");
        getContentPane().setLayout(null);

        lblNombreGenero.setText("Nombre del genero");
        getContentPane().add(lblNombreGenero);
        lblNombreGenero.setBounds(30, 30, 120, 30);

        txtNombreGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreGeneroActionPerformed(evt);
            }
        });
        getContentPane().add(txtNombreGenero);
        txtNombreGenero.setBounds(180, 30, 190, 23);
        getContentPane().add(txtDescripcionGenero);
        txtDescripcionGenero.setBounds(180, 80, 190, 23);

        jLabel1.setText("Descripcion del genero");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 80, 140, 20);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar);
        btnAgregar.setBounds(180, 130, 190, 23);

        lstGenerosRegistrados.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lstGenerosRegistrados);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(450, 30, 290, 180);

        txtGenerosRegistrados.setText("Generos Registrados:");
        getContentPane().add(txtGenerosRegistrados);
        txtGenerosRegistrados.setBounds(450, 10, 210, 15);

        setBounds(0, 0, 825, 526);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreGeneroActionPerformed
       
    }//GEN-LAST:event_txtNombreGeneroActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
          String nombre = txtNombreGenero.getText();
        String descripcion = txtDescripcionGenero.getText();

        // Crea el nuevo objeto Genero
        Genero genero = new Genero(nombre, descripcion);
        


        // Limpia los campos de texto
        txtNombreGenero.setText("");
        txtDescripcionGenero.setText("");
        
        
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
            java.util.logging.Logger.getLogger(VentanaGenero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaGenero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaGenero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaGenero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaGenero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNombreGenero;
    private javax.swing.JList<String> lstGenerosRegistrados;
    private javax.swing.JTextField txtDescripcionGenero;
    private javax.swing.JLabel txtGenerosRegistrados;
    private javax.swing.JTextField txtNombreGenero;
    // End of variables declaration//GEN-END:variables
}