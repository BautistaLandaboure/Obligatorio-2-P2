package interfaz.registro;

import dominio.Editorial;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import dominio.*;
import javax.swing.table.DefaultTableModel;

public class VentanaEditorial extends javax.swing.JFrame {

    private Editorial modelo;

    private DefaultTableModel modeloTabla;

    public VentanaEditorial() {
        initComponents();
        Editorial.cargarEditoriales();
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
        panelEditorial = new javax.swing.JPanel();
        lblNombreEditorial = new javax.swing.JLabel();
        txtNombreEditorial = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtPaisEditorial = new javax.swing.JTextField();
        btnAgregarEditorial = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaEditorialesRegistradas = new javax.swing.JTable();
        txtEditorialesRegistradas = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Editorial");
        getContentPane().setLayout(null);

        panelEditorial.setLayout(null);

        lblNombreEditorial.setText("Nombre de la editorial:");
        panelEditorial.add(lblNombreEditorial);
        lblNombreEditorial.setBounds(10, 30, 150, 20);
        panelEditorial.add(txtNombreEditorial);
        txtNombreEditorial.setBounds(170, 30, 140, 19);

        jLabel1.setText("Pais de la editorial:");
        panelEditorial.add(jLabel1);
        jLabel1.setBounds(10, 70, 130, 15);
        panelEditorial.add(txtPaisEditorial);
        txtPaisEditorial.setBounds(170, 70, 140, 19);

        btnAgregarEditorial.setText("Agregar");
        btnAgregarEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEditorialActionPerformed(evt);
            }
        });
        panelEditorial.add(btnAgregarEditorial);
        btnAgregarEditorial.setBounds(170, 140, 140, 25);

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

        panelEditorial.add(jScrollPane3);
        jScrollPane3.setBounds(330, 30, 210, 140);

        txtEditorialesRegistradas.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        txtEditorialesRegistradas.setText("Editoriales Registradas");
        panelEditorial.add(txtEditorialesRegistradas);
        txtEditorialesRegistradas.setBounds(330, 0, 180, 15);

        getContentPane().add(panelEditorial);
        panelEditorial.setBounds(20, 20, 570, 170);

        setBounds(0, 0, 645, 249);
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

        new Editorial(nombre, pais);

        objetoAPantalla();

        Editorial.guardarEditoriales();
    }//GEN-LAST:event_btnAgregarEditorialActionPerformed

    private void objetoAPantalla() {

        ArrayList<Editorial> listaEditoriales = Editorial.obtenerTodasLasEditoriales();
        modeloTabla = (DefaultTableModel) tablaEditorialesRegistradas.getModel();

        modeloTabla.setRowCount(0);

        for (Editorial editorial : listaEditoriales) {
            modeloTabla.addRow(new Object[]{editorial.getNombre(), editorial.getPaisOrigen()});
        }

        txtNombreEditorial.setText("");
        txtPaisEditorial.setText("");
    }

    private boolean existeEditorial(String nombre) {
        for (Editorial editorial : Editorial.obtenerTodasLasEditoriales()) {
            if (editorial.getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
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
    private javax.swing.JPanel panelEditorial;
    private javax.swing.JTable tablaEditorialesRegistradas;
    private javax.swing.JLabel txtEditorialesRegistradas;
    private javax.swing.JTextField txtNombreEditorial;
    private javax.swing.JTextField txtPaisEditorial;
    // End of variables declaration//GEN-END:variables
}
