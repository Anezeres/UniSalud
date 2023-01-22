/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author RYZEN
 */
public class VistaDashboard extends javax.swing.JFrame {

    private PanelVender panelDashboard = new PanelVender();
    private PanelProductos panelAfiliados = new PanelProductos();
    private PanelProveedores panelTrabajadores = new PanelProveedores();
    private PanelClientes panelCitas = new PanelClientes();
    
    
    private boolean btnVenderActivo = false;
    private boolean btnProductosActivo = false;
    private boolean btnProveedoresActivo = false;
    private boolean btnClientesActivo = false;
    private boolean btnRegistrosActivo = false;
    
    private String tipoAccionActual;
    
    
    public VistaDashboard() {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        setSize(1363, 765);
    }
    
    public void addBtnProductosListener(MouseListener listener){
        btnProductos.addMouseListener(listener);
    }
    
    public void addBtnProveedoresListener(MouseListener listener){
        btnProveedores.addMouseListener(listener);
    }
    
    public void addBtnClientesListener(MouseListener listener){
        btnClientes.addMouseListener(listener);
    }
    
    public void addBtnVenderListener(MouseListener listener){
        btnVender.addMouseListener(listener);
    }
    
    public void addBtnRegistrosListener(MouseListener listener){
        btnRegistros.addMouseListener(listener);
    }
    
    public void realizarCambioPanelDashboard(JPanel contenidoPanel){
        ubicarPanelEnDashboard(contenidoPanel);
        agregarPanelSeleccionado(contenidoPanel);
    }
    
    private void agregarPanelSeleccionado(JPanel contenidoPanel){
        jPanel1.removeAll();
        jPanel1.add(contenidoPanel, BorderLayout.CENTER);
        jPanel1.revalidate();
        jPanel1.repaint();
    }
    
    private void ubicarPanelEnDashboard(JPanel panel){
        panel.setSize(1086, 503);
        panel.setLocation(0,0);
    }
    
    
    private void setColorNaranja(String boton, JLabel imagenBoton){
        Icon btnNaranja = new ImageIcon("src//Imagenes//BotonesDashboard//00-Btn"+boton+"Naranja-img.png"); 
        imagenBoton.setIcon(btnNaranja);
        activarEstadoBoton(boton);
    }
    
    private void setColorAmarillo(String boton, JLabel imagenBoton){
        Icon btnAmarillo = new ImageIcon("src//Imagenes//BotonesDashboard//00-Btn"+boton+"Amarillo-img.png");  
        imagenBoton.setIcon(btnAmarillo);
        desactivarEstadoBoton(boton);
    }
    
    private void activarEstadoBoton(String boton){
        if(null != boton)
            switch (boton) {
                case "Vender":
                    btnVenderActivo = true;
                    break;
                case "Productos":
                    btnProductosActivo = true;
                    break;
                case "Proveedores":
                    btnProveedoresActivo = true;
                    break;
                case "Clientes":
                    btnClientesActivo = true;
                    break;
                case "Registros":
                    btnRegistrosActivo = true;
                    break;
                default:
                    break;
        }
    }
    
    private void desactivarEstadoBoton(String boton){
        if(null != boton)
            switch (boton) {
                case "Vender":
                    btnVenderActivo = false;
                    break;
                case "Productos":
                    btnProductosActivo = false;
                    break;
                case "Proveedores":
                    btnProveedoresActivo = false;
                    break;
                case "Clientes":
                    btnClientesActivo = false;
                    break;
                case "Registros":
                    btnRegistrosActivo = false;
                    break;
                default:
                    break;
        }
    }
    
    private void mostrarBotonVenderActivado(){
        setColorNaranja("Vender",btnVender);
        setColorAmarillo("Productos", btnProductos);
        setColorAmarillo("Proveedores", btnProveedores);
        setColorAmarillo("Clientes", btnClientes);
        setColorAmarillo("Registros", btnRegistros);
    }
    
    private void mostrarBotonProductosActivado(){
        setColorAmarillo("Vender",btnVender);
        setColorNaranja("Productos", btnProductos);
        setColorAmarillo("Proveedores", btnProveedores);
        setColorAmarillo("Clientes", btnClientes);
        setColorAmarillo("Registros", btnRegistros);
    }
    
    private void mostrarBotonProveedoresActivado(){
        setColorAmarillo("Vender",btnVender);
        setColorAmarillo("Productos", btnProductos);
        setColorNaranja("Proveedores", btnProveedores);
        setColorAmarillo("Clientes", btnClientes);
        setColorAmarillo("Registros", btnRegistros);
    }
    
    private void mostrarBotonClientesActivado(){
        setColorAmarillo("Vender",btnVender);
        setColorAmarillo("Productos", btnProductos);
        setColorAmarillo("Proveedores", btnProveedores);
        setColorNaranja("Clientes", btnClientes);
        setColorAmarillo("Registros", btnRegistros);
    }
    
    private void mostrarBotonRegistrosActivado(){
        setColorAmarillo("Vender",btnVender);
        setColorAmarillo("Productos", btnProductos);
        setColorAmarillo("Proveedores", btnProveedores);
        setColorAmarillo("Clientes", btnClientes);
        setColorNaranja("Registros", btnRegistros);
    }
    
    private void cambiarImagenPrincipal(String titulo){
        fondoDashboard.setIcon(new ImageIcon("src//Imagenes//ImagenesDashboard//00-" + titulo + "-img.png"));
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnRegistros = new javax.swing.JLabel();
        btnClientes = new javax.swing.JLabel();
        btnProveedores = new javax.swing.JLabel();
        btnProductos = new javax.swing.JLabel();
        btnVender = new javax.swing.JLabel();
        fondoDashboard = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(1366, 768));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ImagenesPaneles/00-PanelIniciarFondo-img.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(277, 262, 1086, 503));

        btnRegistros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonesDashboard/00-BtnRegistrosAmarillo-img.png"))); // NOI18N
        btnRegistros.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegistros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegistrosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegistrosMouseExited(evt);
            }
        });
        jPanel2.add(btnRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, -1, -1));

        btnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonesDashboard/00-BtnClientesAmarillo-img.png"))); // NOI18N
        btnClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClientesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnClientesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnClientesMouseExited(evt);
            }
        });
        jPanel2.add(btnClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, -1, -1));

        btnProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonesDashboard/00-BtnProveedoresAmarillo-img.png"))); // NOI18N
        btnProveedores.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProveedoresMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnProveedoresMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnProveedoresMouseExited(evt);
            }
        });
        jPanel2.add(btnProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 400, -1, -1));

        btnProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonesDashboard/00-BtnProductosAmarillo-img.png"))); // NOI18N
        btnProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProductosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnProductosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnProductosMouseExited(evt);
            }
        });
        jPanel2.add(btnProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 330, -1, -1));

        btnVender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonesDashboard/00-BtnVenderAmarillo-img.png"))); // NOI18N
        btnVender.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnVender.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVenderMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnVenderMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVenderMouseExited(evt);
            }
        });
        jPanel2.add(btnVender, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 262, -1, -1));

        fondoDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ImagenesDashboard/00-Vender-img.png"))); // NOI18N
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

    private void btnVenderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVenderMouseEntered
        if(btnVenderActivo == true){
            setColorNaranja("Vender", btnVender);
        }
    }//GEN-LAST:event_btnVenderMouseEntered

    private void btnProductosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductosMouseEntered
        if(btnProductosActivo == true){
            setColorNaranja("Productos", btnProductos);
        } 
    }//GEN-LAST:event_btnProductosMouseEntered

    private void btnProveedoresMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProveedoresMouseEntered
        if(btnProveedoresActivo == true){
            setColorNaranja("Proveedores", btnProveedores);
        }   
    }//GEN-LAST:event_btnProveedoresMouseEntered

    private void btnClientesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClientesMouseEntered
        if(btnClientesActivo == true){
            setColorNaranja("Clientes", btnClientes);
        }  
    }//GEN-LAST:event_btnClientesMouseEntered

    private void btnProductosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductosMouseExited
        if(validarEstadoBotones("Productos")){
            setColorAmarillo("Productos", btnProductos);
        }
    }//GEN-LAST:event_btnProductosMouseExited

    private void btnVenderMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVenderMouseExited
        if(validarEstadoBotones("Vender")){
            setColorAmarillo("Vender", btnVender);
        }
    }//GEN-LAST:event_btnVenderMouseExited

    private void btnProveedoresMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProveedoresMouseExited
        if(validarEstadoBotones("Proveedores")){
            setColorAmarillo("Proveedores", btnProveedores);
        }
    }//GEN-LAST:event_btnProveedoresMouseExited

    private void btnClientesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClientesMouseExited
        if(validarEstadoBotones("Clientes")){
            setColorAmarillo("Clientes", btnClientes);
        }
    }//GEN-LAST:event_btnClientesMouseExited

    private void btnVenderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVenderMouseClicked
        mostrarBotonVenderActivado();
        //realizarCambioPanelDashboard(panelDashboard);
        cambiarImagenPrincipal("Vender");
    }//GEN-LAST:event_btnVenderMouseClicked

    private void btnProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductosMouseClicked
        mostrarBotonProductosActivado();
        /*realizarCambioPanelDashboard(panelAfiliados);*/
        cambiarImagenPrincipal("Productos");
    }//GEN-LAST:event_btnProductosMouseClicked

    private void btnProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProveedoresMouseClicked
        mostrarBotonProveedoresActivado();
        //realizarCambioPanelDashboard(panelTrabajadores);
        cambiarImagenPrincipal("Proveedores");
    }//GEN-LAST:event_btnProveedoresMouseClicked

    private void btnClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClientesMouseClicked
        mostrarBotonClientesActivado();
        //realizarCambioPanelDashboard(panelCitas);
        cambiarImagenPrincipal("Clientes");
    }//GEN-LAST:event_btnClientesMouseClicked

    private void btnRegistrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrosMouseClicked
        mostrarBotonRegistrosActivado();
        cambiarImagenPrincipal("Registros");
    }//GEN-LAST:event_btnRegistrosMouseClicked

    private void btnRegistrosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrosMouseEntered
        if(btnRegistrosActivo == true){
            setColorNaranja("Registros", btnRegistros);
        } 
    }//GEN-LAST:event_btnRegistrosMouseEntered

    private void btnRegistrosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrosMouseExited
        if(validarEstadoBotones("Registros")){
            setColorAmarillo("Registros", btnRegistros);
        }
    }//GEN-LAST:event_btnRegistrosMouseExited

    
    private boolean validarEstadoBotones(String boton){
        boolean respuesta = false;
        if(null != boton)
            switch (boton) {
                case "Vender":
                    respuesta = btnProductosActivo || btnRegistrosActivo || btnProveedoresActivo || btnClientesActivo;
                    break;
                case "Productos":
                    respuesta = btnVenderActivo || btnRegistrosActivo || btnProveedoresActivo || btnClientesActivo;
                    break;
                case "Proveedores":
                    respuesta = btnVenderActivo || btnRegistrosActivo || btnProductosActivo || btnClientesActivo;
                    break;
                case "Clientes":
                    respuesta = btnVenderActivo || btnProveedoresActivo || btnProductosActivo || btnRegistrosActivo;
                    break;
                case "Registros":
                    respuesta = btnVenderActivo || btnProveedoresActivo || btnProductosActivo || btnClientesActivo;
                    break;
                default:
                    break;
        }
        return respuesta;
    }
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

    public JLabel getBtnProductos() {
        return btnProductos;
    }

    public JLabel getBtnProveedores() {
        return btnProveedores;
    }  

    public JLabel getBtnClientes() {
        return btnClientes;
    }

    public JLabel getBtnRegistros() {
        return btnRegistros;
    }

    public JLabel getBtnVender() {
        return btnVender;
    }
    
    

    public String getTipoAccionActual() {
        return tipoAccionActual;
    }

    public void setTipoAccionActual(String tipoAccionActual) {
        this.tipoAccionActual = tipoAccionActual;
    }
    
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnClientes;
    private javax.swing.JLabel btnProductos;
    private javax.swing.JLabel btnProveedores;
    private javax.swing.JLabel btnRegistros;
    private javax.swing.JLabel btnVender;
    private javax.swing.JLabel fondoDashboard;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
