/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas;

import java.awt.Color;
import java.awt.event.MouseListener;
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
public class PanelUsuariosCRUD extends javax.swing.JPanel {
    
    DefaultTableModel modelo;
    private boolean btnAceptarActivo = false;
    private boolean btnCancelarActivo = false;
    private boolean textoEditables;
    private String[] datosActuales;

    /**
     * Creates new form PanelDashboard
     */
    public PanelUsuariosCRUD() {
        initComponents();
        setSize(1086, 503);

    }
    
    public void ponerFondoCRUD(String accion){
        Icon fondoCRUD = new ImageIcon("src//Imagenes//UsuariosCRUD//00-"+accion+"Usuario-img.png"); 
        fondoAfiliados.setIcon(fondoCRUD);     
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
     
    public void activarComponentes(){
        textoEditables = true;
        txtNombre.setEnabled(true);
        txtNombre.setForeground(Color.BLACK);
        txtCedula.setEnabled(true);
        txtCedula.setForeground(Color.BLACK);
        txtTelefono.setEnabled(true);
        txtTelefono.setForeground(Color.BLACK);
        txtCorreo.setEnabled(true);
        txtCorreo.setForeground(Color.BLACK);
        txtDireccion.setEnabled(true);
        txtDireccion.setForeground(Color.BLACK);
        cbxSexo.setEnabled(true);
        cbxSexo.setForeground(Color.BLACK);
    }
    
    public void ingresarInformacion(String[] datos){
        txtNombre.setText(datos[0]);
        txtCedula.setText(datos[1]);
        txtTelefono.setText(datos[2]);
        txtCorreo.setText(datos[3]);
        txtDireccion.setText(datos[4]);
        
        if("Male".equals(datos[5])){
            cbxSexo.setSelectedIndex(1);
        }else if ("Female".equals(datos[5])){
            cbxSexo.setSelectedIndex(2);
        }
        
    }
    
    private void setBotonActivo(String boton, JLabel imagenBoton){
        if(btnAceptarActivo || btnCancelarActivo){
            Icon btnActivo = new ImageIcon("src//Imagenes//BotonesCRUD//00-"+boton+"Activo.png"); 
            imagenBoton.setIcon(btnActivo);
        }
        
        if("Volver".equals(boton) || "Editar".equals(boton)){
            Icon btnActivo = new ImageIcon("src//Imagenes//BotonesCRUD//00-"+boton+"Activo.png"); 
            imagenBoton.setIcon(btnActivo);
        }
        
        
    }
    
    private void setBotonInactivo(String boton, JLabel imagenBoton){
        if(btnAceptarActivo || btnCancelarActivo){
            Icon btnInactivo = new ImageIcon("src//Imagenes//BotonesCRUD//00-"+boton+"Inactivo.png"); 
            imagenBoton.setIcon(btnInactivo);
        }
        
        if("Volver".equals(boton) || "Editar".equals(boton)){
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

        cbxSexo = new javax.swing.JComboBox<>();
        txtDireccion = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtCedula = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        btnEditar = new javax.swing.JLabel();
        btnVolver = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JLabel();
        fondoAfiliados = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1086, 503));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbxSexo.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        cbxSexo.setForeground(new java.awt.Color(255, 0, 0));
        cbxSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un valor...", "Masculino", "Femenino" }));
        cbxSexo.setBorder(null);
        cbxSexo.setEnabled(false);
        add(cbxSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(602, 237, 211, 28));

        txtDireccion.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        txtDireccion.setForeground(new java.awt.Color(255, 0, 0));
        txtDireccion.setBorder(null);
        txtDireccion.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        txtDireccion.setEnabled(false);
        txtDireccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDireccionMouseClicked(evt);
            }
        });
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });
        add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(603, 175, 210, 26));

        txtCorreo.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        txtCorreo.setForeground(new java.awt.Color(255, 0, 0));
        txtCorreo.setBorder(null);
        txtCorreo.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        txtCorreo.setEnabled(false);
        txtCorreo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCorreoMouseClicked(evt);
            }
        });
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });
        add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 381, 210, 26));

        txtTelefono.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(255, 0, 0));
        txtTelefono.setBorder(null);
        txtTelefono.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        txtTelefono.setEnabled(false);
        txtTelefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTelefonoMouseClicked(evt);
            }
        });
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 307, 210, 26));

        txtCedula.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        txtCedula.setForeground(new java.awt.Color(255, 0, 0));
        txtCedula.setBorder(null);
        txtCedula.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        txtCedula.setEnabled(false);
        txtCedula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCedulaMouseClicked(evt);
            }
        });
        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });
        add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 241, 210, 26));

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
        add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 175, 210, 26));

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonesCRUD/00-EditarInactivo.png"))); // NOI18N
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

        fondoAfiliados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/UsuariosCRUD/00-VerUsuario-img.png"))); // NOI18N
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

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtCedulaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCedulaMouseClicked
        //limpiarComponenteTexto(txtCedula);
    }//GEN-LAST:event_txtCedulaMouseClicked

    private void txtTelefonoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTelefonoMouseClicked
        //limpiarComponenteTexto(txtTelefono);
    }//GEN-LAST:event_txtTelefonoMouseClicked

    private void txtCorreoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCorreoMouseClicked
        //limpiarComponenteTexto(txtCorreo);
    }//GEN-LAST:event_txtCorreoMouseClicked

    private void txtDireccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDireccionMouseClicked
        //limpiarComponenteTexto(txtDireccion);
    }//GEN-LAST:event_txtDireccionMouseClicked

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
    
    
    
    
    
    
    

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAceptar;
    private javax.swing.JLabel btnCancelar;
    private javax.swing.JLabel btnEditar;
    private javax.swing.JLabel btnVolver;
    private javax.swing.JComboBox<String> cbxSexo;
    private javax.swing.JLabel fondoAfiliados;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}