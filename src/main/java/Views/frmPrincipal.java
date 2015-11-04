/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Entitys.Usuario;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

/**
 *
 * @author Gabriel
 */
public class frmPrincipal extends javax.swing.JFrame {
    
    public JFrame padre;
    public static Usuario tipousuario;
    private static frmPrincipal instancia; 
    /**
     * Creates new form frmPrincipal
     * @param padre
     */
    public frmPrincipal(JFrame padre) {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);       
        initComponents();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize((int)screenSize.getWidth(), (int)screenSize.getHeight());
        this.padre = padre;
    }  
    
    public static frmPrincipal getInstancia(JFrame padre) {
        if (instancia == null) {
            instancia = new frmPrincipal(padre);
        }        
        return instancia;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemOrdenCompra = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItemMantPrestamistas = new javax.swing.JMenuItem();
        jMenuItemMantProveedores = new javax.swing.JMenuItem();
        jMenuItemMantContactos = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItemReporteOC = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 515, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 321, Short.MAX_VALUE)
        );

        jMenu1.setText("Archivo");

        jMenuItemSalir.setText("Salir");
        jMenuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSalirActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemSalir);

        jMenuBar1.add(jMenu1);

        jMenu2.setMnemonic('A');
        jMenu2.setText("Adquisiciones");

        jMenuItemOrdenCompra.setMnemonic('G');
        jMenuItemOrdenCompra.setText("Generar Orden de Compra");
        jMenuItemOrdenCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemOrdenCompraActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemOrdenCompra);

        jMenuBar1.add(jMenu2);

        jMenu3.setMnemonic('M');
        jMenu3.setText("Mantenimientos");

        jMenuItemMantPrestamistas.setText("Mantenimiento Prestamistas");
        jMenuItemMantPrestamistas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMantPrestamistasActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItemMantPrestamistas);

        jMenuItemMantProveedores.setText("Mantenimiento Proveedores");
        jMenuItemMantProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMantProveedoresActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItemMantProveedores);

        jMenuItemMantContactos.setText("Mantenimiento Contactos");
        jMenuItemMantContactos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMantContactosActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItemMantContactos);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Reportes");

        jMenuItemReporteOC.setText("Ordenes Compra");
        jMenuItemReporteOC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemReporteOCActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItemReporteOC);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemMantPrestamistasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMantPrestamistasActionPerformed
        // TODO add your handling code here:
        frmMantPrestamista mp = frmMantPrestamista.getInstancia();
        this.centrarJInternalDialog(mp);        
        if (!this.jDesktopPane1.isAncestorOf(mp)) {
            this.jDesktopPane1.add(mp);
            mp.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItemMantPrestamistasActionPerformed

    private void jMenuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSalirActionPerformed
        // TODO add your handling code here:
         this.dispose(); 
         this.padre.dispose();
        //frmRegistroOrdenCompra.instancia = null;
        //frmMantUsuarios.instancia = null;
        
        
    }//GEN-LAST:event_jMenuItemSalirActionPerformed

    private void jMenuItemOrdenCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemOrdenCompraActionPerformed
        // TODO add your handling code here:       
//        frmRegistroOrdenCompra roc = frmRegistroOrdenCompra.getInstancia();
//       this.centrarJInternalDialog(roc);        
//        if (!this.jDesktopPane1.isAncestorOf(roc)) {
//            this.jDesktopPane1.add(roc);
//            roc.setVisible(true);
//        }
    }//GEN-LAST:event_jMenuItemOrdenCompraActionPerformed

    private void jMenuItemReporteOCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemReporteOCActionPerformed
        // TODO add your handling code here:
//        frmReportesOrdenesC roc = frmReportesOrdenesC.getInstancia();
//        this.jDesktopPane1.add(roc);
//        roc.setVisible(true);
    }//GEN-LAST:event_jMenuItemReporteOCActionPerformed

    private void jMenuItemMantProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMantProveedoresActionPerformed
        // TODO add your handling code here:
//        frmMantProveedores mp = frmMantProveedores.getInstancia(); 
//        this.centrarJInternalDialog(mp);
//        if (!this.jDesktopPane1.isAncestorOf(mp)) {
//            this.jDesktopPane1.add(mp);
//            mp.setVisible(true);
//        }
    }//GEN-LAST:event_jMenuItemMantProveedoresActionPerformed

    private void jMenuItemMantContactosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMantContactosActionPerformed
        // TODO add your handling code here:
//        frmMantContactos mC = frmMantContactos.getInstancia();
//        this.centrarJInternalDialog(mC);
//        if (!this.jDesktopPane1.isAncestorOf(mC)) {
//            this.jDesktopPane1.add(mC);
//            mC.setVisible(true);
//        }
    }//GEN-LAST:event_jMenuItemMantContactosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new frmPrincipal(null).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemMantContactos;
    private javax.swing.JMenuItem jMenuItemMantPrestamistas;
    private javax.swing.JMenuItem jMenuItemMantProveedores;
    private javax.swing.JMenuItem jMenuItemOrdenCompra;
    private javax.swing.JMenuItem jMenuItemReporteOC;
    private javax.swing.JMenuItem jMenuItemSalir;
    // End of variables declaration//GEN-END:variables

public void centrarJInternalDialog(JInternalFrame Jinternal){
     Dimension desktopsize = jDesktopPane1.getSize();
     Dimension jInternal = Jinternal.getSize();
     Jinternal.setLocation((desktopsize.width-jInternal.width)/2,(desktopsize.height-jInternal.height)/2);
}

public void centrarJDialog(javax.swing.JDialog Jdialog){
     Dimension desktopsize = jDesktopPane1.getSize();
     Dimension jDialog = Jdialog.getSize(); 
     Jdialog.setLocation((desktopsize.width-jDialog.width)/2,(desktopsize.height-jDialog.height)/2);
}

}
