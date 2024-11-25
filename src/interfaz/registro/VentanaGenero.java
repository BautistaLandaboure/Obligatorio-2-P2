package interfaz.registro;

import dominio.*;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class VentanaGenero extends javax.swing.JFrame {

    private ArrayList<Genero> generosRegistrados = Genero.getGenerosRegistrados();

    public VentanaGenero() {
        initComponents();
        objetoAPantalla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGenero = new javax.swing.JPanel();
        lblNombreGenero = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreGenero = new javax.swing.JTextField();
        txtDescripcionGenero = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstGenerosRegistrados = new javax.swing.JList<>();
        txtGenerosRegistrados = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Género");
        getContentPane().setLayout(null);

        panelGenero.setLayout(null);

        lblNombreGenero.setText("Nombre del género:");
        panelGenero.add(lblNombreGenero);
        lblNombreGenero.setBounds(10, 60, 120, 30);

        jLabel1.setText("Descripción del género:");
        panelGenero.add(jLabel1);
        jLabel1.setBounds(10, 100, 140, 20);

        txtNombreGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreGeneroActionPerformed(evt);
            }
        });
        panelGenero.add(txtNombreGenero);
        txtNombreGenero.setBounds(220, 60, 190, 19);
        panelGenero.add(txtDescripcionGenero);
        txtDescripcionGenero.setBounds(220, 100, 190, 19);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        panelGenero.add(btnAgregar);
        btnAgregar.setBounds(260, 200, 150, 25);

        lstGenerosRegistrados.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lstGenerosRegistrados);

        panelGenero.add(jScrollPane1);
        jScrollPane1.setBounds(430, 50, 290, 180);

        txtGenerosRegistrados.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        txtGenerosRegistrados.setText("Géneros Registrados:");
        panelGenero.add(txtGenerosRegistrados);
        txtGenerosRegistrados.setBounds(430, 20, 210, 15);

        getContentPane().add(panelGenero);
        panelGenero.setBounds(20, 10, 770, 250);

        setBounds(0, 0, 825, 313);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreGeneroActionPerformed

    }//GEN-LAST:event_txtNombreGeneroActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String nombre = txtNombreGenero.getText().trim();
        String descripcion = txtDescripcionGenero.getText().trim();

        if (nombre.isEmpty() || descripcion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete tanto el nombre como la descripción del género.", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (existeGenero(nombre)) {
            JOptionPane.showMessageDialog(this, "El género ya existe.", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Genero genero = new Genero(nombre, descripcion);
        Genero.guardarGeneros();
        objetoAPantalla();
        txtNombreGenero.setText("");
        txtDescripcionGenero.setText("");
    }//GEN-LAST:event_btnAgregarActionPerformed

    private boolean existeGenero(String nombre) {
        for (Genero genero : generosRegistrados) {
            if (genero.getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }

    private String[] obtenerGeneros() {
        String[] generosArray = new String[generosRegistrados.size()];
        for (int i = 0; i < generosRegistrados.size(); i++) {
            generosArray[i] = generosRegistrados.get(i).toString();
        }
        return generosArray;
    }

    private void objetoAPantalla() {

        DefaultListModel<String> model = new DefaultListModel<>();
        for (Genero genero : Genero.getGenerosRegistrados()) {
            model.addElement(genero.toString());
        }

        lstGenerosRegistrados.setModel(model);
    }

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
    private javax.swing.JPanel panelGenero;
    private javax.swing.JTextField txtDescripcionGenero;
    private javax.swing.JLabel txtGenerosRegistrados;
    private javax.swing.JTextField txtNombreGenero;
    // End of variables declaration//GEN-END:variables
}
