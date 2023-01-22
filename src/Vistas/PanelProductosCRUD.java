/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas;

import java.awt.Color;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author RYZEN
 */
public class PanelProductosCRUD extends javax.swing.JPanel {
    
    DefaultTableModel modelo;
    private boolean btnAceptarActivo = false;
    private boolean btnCancelarActivo = false;
    private boolean btnEditarActivo = false;
    private boolean textoEditables;
    private String[] datosActuales;
    private String accionActual;

    /**
     * Creates new form PanelDashboard
     */
    public PanelProductosCRUD() {
        initComponents();
        setSize(1086, 503);

    }
    
    public void ponerFondoCRUD(String accion){
        Icon fondoCRUD = new ImageIcon("src//Imagenes//ProductoCRUD//00-"+accion+"Producto-img.png"); 
        fondoAfiliados.setIcon(fondoCRUD);     
        accionActual = accion;
    }
    
    public void addBtnEditarListener(MouseListener listener){
        btnEditar.addMouseListener(listener);
    }
    
    public void addBtnVolverListener(MouseListener listener){
        btnVolver.addMouseListener(listener);
    }
    
    public void addBtnAceptarListener(MouseListener listener){
        btnAceptar.addMouseListener(listener);
    }
    
    public void addBtnCancelarListener(MouseListener listener){
        btnCancelar.addMouseListener(listener);
    }
    
    public void activarBotones(){
        btnAceptarActivo = true;
        btnCancelarActivo = true;
        setBotonInactivo("Cancelar", btnCancelar);
        setBotonInactivo("Aceptar", btnAceptar);
    }
    
    public void activarBtnEditar(){
        btnEditarActivo = true;
        setBotonInactivo("Editar", btnEditar);
    }
    
    public void limpiarCampos(){
        limpiarComponenteTexto(txtNombre);
        limpiarComponenteTexto(txtPrecio);
        limpiarComponenteTexto(txtUnidades);
        cbxProveedores.setSelectedIndex(0);
    }
    
    public boolean validarCampos(){
        boolean camposValidos = false;
        if(!"".equals(txtNombre.getText()) && !"".equals(txtPrecio.getText()) && !"".equals(txtUnidades.getText()) && cbxProveedores.getSelectedIndex() != 0){
            camposValidos = true;
        }
        return camposValidos;
    }
     
    public void activarComponentes(){
        textoEditables = true;
        txtNombre.setEnabled(true);
        txtNombre.setForeground(Color.BLACK);
        txtPrecio.setEnabled(true);
        txtPrecio.setForeground(Color.BLACK);
        txtUnidades.setEnabled(true);
        txtUnidades.setForeground(Color.BLACK);
        cbxProveedores.setEnabled(true);
        cbxProveedores.setForeground(Color.BLACK);
        txtUnidades.setEnabled(true);
        txtUnidades.setForeground(Color.BLACK);
    }
    
    public void ingresarInformacion(String[] datos){
        txtNombre.setText(datos[0]);
        txtPrecio.setText(datos[1]);
        txtUnidades.setText(datos[2]);
        cbxProveedores.addItem(datos[3]);
        
    }
    
    public String[] obtenerInformacion(){
        String[] datos = new String[6];
        
        datos[0] = txtNombre.getText();
        datos[1] = txtPrecio.getText();
        datos[2] = txtUnidades.getText();
        datos[3] = cbxProveedores.getSelectedItem().toString();
        
        return datos;
    }
    
    public void llenarComboProveedores(String[] proveedores){
        cbxProveedores.removeAllItems();
        cbxProveedores.addItem(". . .");
        for (String pr: proveedores)
            {
                cbxProveedores.addItem(pr + "");
            }
    }
    
    private void setBotonActivo(String boton, JLabel imagenBoton){
        if(imagenBoton == btnEditar && btnEditarActivo){
            Icon btnActivo = new ImageIcon("src//Imagenes//BotonesCRUD//00-"+boton+"Activo.png"); 
            imagenBoton.setIcon(btnActivo);
        }else if(imagenBoton != btnEditar && (btnAceptarActivo || btnCancelarActivo)){
            Icon btnActivo = new ImageIcon("src//Imagenes//BotonesCRUD//00-"+boton+"Activo.png"); 
            imagenBoton.setIcon(btnActivo);
        }else if(imagenBoton != btnEditar && ("Volver".equals(boton) || "Editar".equals(boton))){
            Icon btnActivo = new ImageIcon("src//Imagenes//BotonesCRUD//00-"+boton+"Activo.png"); 
            imagenBoton.setIcon(btnActivo);
        }
        
        
    }
    
    private void setBotonInactivo(String boton, JLabel imagenBoton){
        
        if(imagenBoton == btnEditar && btnEditarActivo){
            Icon btnInactivo = new ImageIcon("src//Imagenes//BotonesCRUD//00-"+boton+"Inactivo.png"); 
            imagenBoton.setIcon(btnInactivo);
        }else if(imagenBoton != btnEditar && (btnAceptarActivo || btnCancelarActivo)){
            Icon btnInactivo = new ImageIcon("src//Imagenes//BotonesCRUD//00-"+boton+"Inactivo.png"); 
            imagenBoton.setIcon(btnInactivo);
        }else if(imagenBoton != btnEditar && ("Volver".equals(boton) || "Editar".equals(boton))){
            Icon btnInactivo = new ImageIcon("src//Imagenes//BotonesCRUD//00-"+boton+"Inactivo.png"); 
            imagenBoton.setIcon(btnInactivo);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUnidades = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        cbxProveedores = new javax.swing.JComboBox<>();
        btnEditar = new javax.swing.JLabel();
        btnVolver = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JLabel();
        fondoAfiliados = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1086, 503));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUnidades.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        txtUnidades.setForeground(new java.awt.Color(255, 0, 0));
        txtUnidades.setBorder(null);
        txtUnidades.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        txtUnidades.setEnabled(false);
        txtUnidades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtUnidadesMouseClicked(evt);
            }
        });
        txtUnidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUnidadesActionPerformed(evt);
            }
        });
        add(txtUnidades, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 303, 210, 26));

        txtPrecio.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        txtPrecio.setForeground(new java.awt.Color(255, 0, 0));
        txtPrecio.setBorder(null);
        txtPrecio.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        txtPrecio.setEnabled(false);
        txtPrecio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPrecioMouseClicked(evt);
            }
        });
        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });
        add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 238, 210, 26));

        txtNombre.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(255, 0, 0));
        txtNombre.setBorder(null);
        txtNombre.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        txtNombre.setEnabled(false);
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 172, 210, 26));

        cbxProveedores.setEnabled(false);
        add(cbxProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 378, 210, 26));

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonesCRUD/00-EditarDesactivado.png"))); // NOI18N
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEditarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditarMouseExited(evt);
            }
        });
        add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 140, 144, 55));

        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonesCRUD/00-VolverInactivo.png"))); // NOI18N
        btnVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnVolverMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVolverMouseExited(evt);
            }
        });
        add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 350, 144, 55));

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonesCRUD/00-CancelarDesactivado.png"))); // NOI18N
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelarMouseExited(evt);
            }
        });
        add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 280, 144, 55));

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonesCRUD/00-AceptarDesactivado.png"))); // NOI18N
        btnAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAceptarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAceptarMouseExited(evt);
            }
        });
        add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 210, 144, 55));

        fondoAfiliados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ProductoCRUD/00-VerProducto-img.png"))); // NOI18N
        add(fondoAfiliados, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, -4, 1090, 510));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseEntered
        setBotonActivo("Aceptar", btnAceptar);
    }//GEN-LAST:event_btnAceptarMouseEntered

    private void btnAceptarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseExited
        setBotonInactivo("Aceptar", btnAceptar);
    }//GEN-LAST:event_btnAceptarMouseExited

    private void btnCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseEntered
        setBotonActivo("Cancelar", btnCancelar);
    }//GEN-LAST:event_btnCancelarMouseEntered

    private void btnCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseExited
        setBotonInactivo("Cancelar", btnCancelar);
    }//GEN-LAST:event_btnCancelarMouseExited

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtUnidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUnidadesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUnidadesActionPerformed

    private void txtPrecioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPrecioMouseClicked
        
    }//GEN-LAST:event_txtPrecioMouseClicked

    private void txtUnidadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUnidadesMouseClicked
        
    }//GEN-LAST:event_txtUnidadesMouseClicked

    private void btnVolverMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverMouseEntered
        setBotonActivo("Volver", btnVolver);
    }//GEN-LAST:event_btnVolverMouseEntered

    private void btnVolverMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverMouseExited
        setBotonInactivo("Volver", btnVolver);
    }//GEN-LAST:event_btnVolverMouseExited

    private void btnEditarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarMouseEntered
        setBotonActivo("Editar", btnEditar);
    }//GEN-LAST:event_btnEditarMouseEntered

    private void btnEditarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarMouseExited
        setBotonInactivo("Editar", btnEditar);
    }//GEN-LAST:event_btnEditarMouseExited

    private void limpiarComponenteTexto(JTextField texto){
        if(textoEditables){
            texto.setText("");
            texto.setForeground(Color.black);
        }
    }

    public String[] getDatosActuales() {
        return datosActuales;
    }

    public void setDatosActuales(String[] datosActuales) {
        this.datosActuales = datosActuales;
    }

    public JLabel getBtnAceptar() {
        return btnAceptar;
    }

    public JLabel getBtnCancelar() {
        return btnCancelar;
    }

    public JLabel getBtnEditar() {
        return btnEditar;
    }

    public JLabel getBtnVolver() {
        return btnVolver;
    }

    public String getAccionActual() {
        return accionActual;
    }

    public boolean isBtnEditarActivo() {
        return btnEditarActivo;
    }

    public boolean isBtnAceptarActivo() {
        return btnAceptarActivo;
    }

    public boolean isBtnCancelarActivo() {
        return btnCancelarActivo;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAceptar;
    private javax.swing.JLabel btnCancelar;
    private javax.swing.JLabel btnEditar;
    private javax.swing.JLabel btnVolver;
    private javax.swing.JComboBox<String> cbxProveedores;
    private javax.swing.JLabel fondoAfiliados;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtUnidades;
    // End of variables declaration//GEN-END:variables
}
