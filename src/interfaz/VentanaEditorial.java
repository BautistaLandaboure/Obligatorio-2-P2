package interfaz;

import dominio.Editorial;
import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import dominio.*;
import javax.swing.table.DefaultTableModel;

public class VentanaEditorial extends javax.swing.JFrame {

    private Editorial modelo;

    private DefaultTableModel modeloTabla;

    public VentanaEditorial() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        lblNombreEditorial = new javax.swing.JLabel();
        txtNombreEditorial = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtPaisEditorial = new javax.swing.JTextField();
        btnAgregarEditorial = new javax.swing.JButton();
        txtEditorialesRegistradas = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaEditorialesRegistradas = new javax.swing.JTable();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Vemtana Registro Editorial");
        getContentPane().setLayout(null);

        lblNombreEditorial.setText("Nombre de la editorial:");
        getContentPane().add(lblNombreEditorial);
        lblNombreEditorial.setBounds(30, 50, 150, 20);
        getContentPane().add(txtNombreEditorial);
        txtNombreEditorial.setBounds(190, 50, 140, 19);

        jLabel1.setText("Pais de la editorial:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 130, 130, 15);
        getContentPane().add(txtPaisEditorial);
        txtPaisEditorial.setBounds(190, 130, 140, 19);

        btnAgregarEditorial.setText("Agregar");
        btnAgregarEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEditorialActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregarEditorial);
        btnAgregarEditorial.setBounds(190, 180, 140, 25);

        txtEditorialesRegistradas.setText("Editoriales Registradas");
        getContentPane().add(txtEditorialesRegistradas);
        txtEditorialesRegistradas.setBounds(350, 20, 180, 15);

        tablaEditorialesRegistradas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Editorial", "Pais"
            }
        ));
        jScrollPane3.setViewportView(tablaEditorialesRegistradas);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(350, 50, 210, 270);

        setBounds(0, 0, 645, 412);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEditorialActionPerformed
        String nombre = txtNombreEditorial.getText().trim();
        String pais = txtPaisEditorial.getText().trim();

        if (nombre.isEmpty() || pais.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos requeridos.", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (existeEditorial(nombre)) {
            JOptionPane.showMessageDialog(this, "La editorial ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Crear y agregar la nueva editorial
        Editorial nuevaEditorial = new Editorial(nombre, pais);

        // Llamar a objetoAPantalla para actualizar la tabla con la nueva lista de editoriales
        objetoAPantalla();

    }//GEN-LAST:event_btnAgregarEditorialActionPerformed

    private void objetoAPantalla() {
        // Obtener la lista de todas las editoriales y llenar la tabla si es necesario
        ArrayList<Editorial> listaEditoriales = Editorial.obtenerTodasLasEditoriales();
        modeloTabla = (DefaultTableModel) tablaEditorialesRegistradas.getModel(); // Obtener el modelo de la tabla

        // Limpiar la tabla antes de añadir los datos
        modeloTabla.setRowCount(0);

        for (Editorial editorial : listaEditoriales) {
            modeloTabla.addRow(new Object[]{editorial.getNombre(), editorial.getPaisOrigen()}); // Añadir filas
        }

        // Limpiar los campos de texto
        txtNombreEditorial.setText("");
        txtPaisEditorial.setText("");
    }

    private boolean existeEditorial(String nombre) {
        for (Editorial editorial : Editorial.obtenerTodasLasEditoriales()) {
            if (editorial.getNombre().equalsIgnoreCase(nombre)) {
                return true; // La editorial ya existe
            }
        }
        return false; // La editorial no existe
    }

    private ArrayList<String> listaEditorialesRegistradas = new ArrayList<>();

    public static void main(String args[]) {

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
            java.util.logging.Logger.getLogger(VentanaEditorial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaEditorial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaEditorial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaEditorial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaEditorial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarEditorial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblNombreEditorial;
    private javax.swing.JTable tablaEditorialesRegistradas;
    private javax.swing.JLabel txtEditorialesRegistradas;
    private javax.swing.JTextField txtNombreEditorial;
    private javax.swing.JTextField txtPaisEditorial;
    // End of variables declaration//GEN-END:variables
}
