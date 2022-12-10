/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author RYZEN
 */
public class VistaDashboard extends javax.swing.JFrame {

    /**
     * Creates new form VistaLogin
     */
    public VistaDashboard() {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        setSize(1363, 765);
    }

    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnCitas = new javax.swing.JLabel();
        btnTrabajadores = new javax.swing.JLabel();
        btnAfiliados = new javax.swing.JLabel();
        btnDashboard = new javax.swing.JLabel();
        fondoDashboard = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(1366, 768));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCitas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonesDashboard/00-BtnCitasGris-img.png"))); // NOI18N
        btnCitas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCitas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCitasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCitasMouseExited(evt);
            }
        });
        jPanel2.add(btnCitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 460, -1, -1));

        btnTrabajadores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonesDashboard/00-BtnTrabajadoresGris-img.png"))); // NOI18N
        btnTrabajadores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTrabajadores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTrabajadoresMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTrabajadoresMouseExited(evt);
            }
        });
        jPanel2.add(btnTrabajadores, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 400, -1, -1));

        btnAfiliados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonesDashboard/00-BtnAfiliadosGris-img.png"))); // NOI18N
        btnAfiliados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAfiliados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAfiliadosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAfiliadosMouseExited(evt);
            }
        });
        jPanel2.add(btnAfiliados, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 330, -1, -1));

        btnDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonesDashboard/00-BtnDashboardGris-img.png"))); // NOI18N
        btnDashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDashboardMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDashboardMouseExited(evt);
            }
        });
        jPanel2.add(btnDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 262, -1, -1));

        fondoDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ImagenesDashboard/00-Dashboard-img.png"))); // NOI18N
        jPanel2.add(fondoDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, -4, 1370, 770));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDashboardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDashboardMouseEntered
        Icon btnDashboardAzul = new ImageIcon("src\\Imagenes\\BotonesDashboard\\00-BtnDashboardAzul-img.png");
        btnDashboard.setIcon(btnDashboardAzul);
    }//GEN-LAST:event_btnDashboardMouseEntered

    private void btnDashboardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDashboardMouseExited
        Icon btnDashboardGris = new ImageIcon("src\\Imagenes\\BotonesDashboard\\00-BtnDashboardGris-img.png");
        btnDashboard.setIcon(btnDashboardGris);
    }//GEN-LAST:event_btnDashboardMouseExited

    private void btnAfiliadosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAfiliadosMouseEntered
        Icon btnAfiliadosAzul = new ImageIcon("src\\Imagenes\\BotonesDashboard\\00-BtnAfiliadosAzul-img.png");
        btnAfiliados.setIcon(btnAfiliadosAzul);
    }//GEN-LAST:event_btnAfiliadosMouseEntered

    private void btnAfiliadosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAfiliadosMouseExited
        Icon btnAfiliadosGris = new ImageIcon("src\\Imagenes\\BotonesDashboard\\00-BtnAfiliadosGris-img.png");
        btnAfiliados.setIcon(btnAfiliadosGris);
    }//GEN-LAST:event_btnAfiliadosMouseExited

    private void btnTrabajadoresMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrabajadoresMouseEntered
        Icon btnTrabajadoresAzul = new ImageIcon("src\\Imagenes\\BotonesDashboard\\00-BtnTrabajadoresAzul-img.png");
        btnTrabajadores.setIcon(btnTrabajadoresAzul);
    }//GEN-LAST:event_btnTrabajadoresMouseEntered

    private void btnTrabajadoresMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrabajadoresMouseExited
        Icon btnTrabajadoresGris = new ImageIcon("src\\Imagenes\\BotonesDashboard\\00-BtnTrabajadoresGris-img.png");
        btnTrabajadores.setIcon(btnTrabajadoresGris);
    }//GEN-LAST:event_btnTrabajadoresMouseExited

    private void btnCitasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCitasMouseEntered
        Icon btnCitasAzul = new ImageIcon("src\\Imagenes\\BotonesDashboard\\00-BtnCitasAzul-img.png");
        btnCitas.setIcon(btnCitasAzul);
    }//GEN-LAST:event_btnCitasMouseEntered

    private void btnCitasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCitasMouseExited
        Icon btnCitasGris = new ImageIcon("src\\Imagenes\\BotonesDashboard\\00-BtnCitasGris-img.png");
        btnCitas.setIcon(btnCitasGris);
    }//GEN-LAST:event_btnCitasMouseExited

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
            java.util.logging.Logger.getLogger(VistaDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAfiliados;
    private javax.swing.JLabel btnCitas;
    private javax.swing.JLabel btnDashboard;
    private javax.swing.JLabel btnTrabajadores;
    private javax.swing.JLabel fondoDashboard;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
