/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI.gestion;

import Controlador.ControladorClientes;
import Exceptions.ErrorListadoClientesException;
import GUI.Utiles.Vistas;
import GUI.pantallaPpal;
import gestionPeliculas.dto.Cliente;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

/**
 *
 * @author Miguelañez-PC
 */
public class EliminarCliente extends javax.swing.JDialog {
    pantallaPpal padre;
    /**
     * Creates new form EliminarCliente
     */
    public EliminarCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        padre = (pantallaPpal) parent;
        initComponents();
        
        DefaultComboBoxModel modeloCB = new DefaultComboBoxModel();
        rellenarModeloComboBox(modeloCB);
        jComboBoxListaUsers.setModel(modeloCB);
        
        if (modeloCB.getSize() == 0) {
            this.jButtonEliminar.setEnabled(false);
        }
        
        this.setLocationRelativeTo(null);
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
        jPanel2 = new javax.swing.JPanel();
        jButtonEliminar = new javax.swing.JButton();
        jComboBoxListaUsers = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Eliminar cliente...");
        setMinimumSize(new java.awt.Dimension(366, 128));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jKeyReleasedHandlerATRAS(evt);
            }
        });

        jPanel1.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jButtonEliminar.setForeground(new java.awt.Color(255, 102, 51));
        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jComboBoxListaUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEliminar)
                    .addComponent(jComboBoxListaUsers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jLabel1.setText("¿Qué usuario desea eliminar?");
        getContentPane().add(jLabel1, java.awt.BorderLayout.CENTER);

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, java.awt.BorderLayout.LINE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        if (JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar el usuario " + (String)jComboBoxListaUsers.getSelectedItem() + "?") == 0) {
            //Eliminar en la lista del Controlador y en BBDD
            String dni = jComboBoxListaUsers.getSelectedItem().toString().substring(0, 9);
            
            ControladorClientes.eliminarClienteByNIF(dni);
            this.setVisible(false);
            dispose();
        }
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jKeyReleasedHandlerATRAS(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jKeyReleasedHandlerATRAS
        if (evt.getKeyCode() == KeyEvent.VK_V) {
            this.setVisible(false);
            this.dispose();
        }
    }//GEN-LAST:event_jKeyReleasedHandlerATRAS

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
            java.util.logging.Logger.getLogger(EliminarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EliminarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EliminarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EliminarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EliminarCliente dialog = new EliminarCliente(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JComboBox<String> jComboBoxListaUsers;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    private void rellenarModeloComboBox(DefaultComboBoxModel modeloCB) {
        modeloCB.removeAllElements();
        try {
            List<Cliente> clientes = ControladorClientes.getListaCliente();
            for (Cliente c: clientes) {
                modeloCB.addElement(c.toStringLista());
            }
        } catch (ErrorListadoClientesException errListadoClientes) {
            Vistas.mostrarErrorGUI(rootPane, "ERROR LISTANDO CLIENTES (ELIMINAR)!", errListadoClientes.getMessage());
        }
        
    }
}
