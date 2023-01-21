/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas;

import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author RYZEN
 */
public class PanelVender extends javax.swing.JPanel {

    DefaultListModel modelo;
    DefaultListModel modeloCompra;
    
    private boolean btnAgregarActivo = false;
    private boolean btnEliminarActivo = false;
    private boolean btnVenderActivo = false;
    
    private boolean selecionoProductoCompra = false;
    
    private float precio = 0;
    
    private List<Float> preciosAgregados;
    private List<Integer> cantidadesAgregades;
    /**
     * Creates new form PanelDashboard
     */
    public PanelVender() {
        initComponents();
        
        setVisible(true);
        setSize(1086, 503);
        
        modelo = new DefaultListModel();
        listaProductos.setModel(modelo);
        modeloCompra = new DefaultListModel();
        listaCompras.setModel(modeloCompra);
        
        preciosAgregados = new LinkedList<>();
        cantidadesAgregades = new LinkedList<>();
        
    }
    
    
    public void cambiarEstadoBotonAgregar(boolean estado){
        if(!estado){
            btnAgregarActivo = true;
            setBotonInactivo("Agregar", btnAgregar);   
        }else{
            btnAgregarActivo = false;
            setBotonDesactivado("Agregar", btnAgregar);
        }
        
        
    }
    
    public void cambiarEstadoBotonesInferiores(){
        btnEliminarActivo = true;
        btnVenderActivo = true;
        
        setBotonInactivo("Eliminar", btnEliminar);
        setBotonInactivo("Vender", btnVender);
    }
    
    public void DesactivarBotonesInferiores(){
        btnEliminarActivo = false;
        btnVenderActivo = false;
        
        setBotonDesactivado("Eliminar", btnEliminar);
        setBotonDesactivado("Vender", btnVender);
    }
    
    public void llenarListaProductos(String[] datos){
        //modelo.removeAllElements();
        
        String producto = datos[0] + " | " + datos[1] + " | " + datos[2] + ".";
        
        modelo.addElement(producto);
    }
    
    public void llenarListaCompras(String[] datos){
        //modelo.removeAllElements();
        
        int cantidad = Integer.parseInt(datos[2]);
        float precioProducto = Float.parseFloat(datos[1]);
        
        indicarPrecio(cantidad, precioProducto);
        
        String producto = datos[0] + " | " + datos[1] + "$ | " + datos[2] + " u.";
        
        modeloCompra.addElement(producto);
    }
    
    public void indicarPrecio(int cantidad, float precioProducto){
        preciosAgregados.add(precioProducto);
        cantidadesAgregades.add(cantidad);
        
        float precioTotal = 0;
        
        for(int i=0; i<preciosAgregados.size();i++){
            precioTotal = precioTotal + (cantidadesAgregades.get(i)*preciosAgregados.get(i));
        }
        setTxtPrecioTotal(precioTotal);
    }
    
    public void actualizarPrecio(){
        float precioTotal = 0;
        
        for(int i=0; i<preciosAgregados.size();i++){
            precioTotal = precioTotal + (cantidadesAgregades.get(i)*preciosAgregados.get(i));
        }
        setTxtPrecioTotal(precioTotal);
    }
    
    public void eliminarElementoLista(int index){
        preciosAgregados.remove(index);
        cantidadesAgregades.remove(index);
        modeloCompra.removeElementAt(index);
        actualizarPrecio();
    }
    
    public ArrayList<String> getListaDeCompras()
    {
        ArrayList<String> auxLista = new ArrayList<String>();
        int size = modeloCompra.size();
        for (int i = 0; i < size; i++)
        {
            auxLista.add((String) modeloCompra.elementAt(i));
        }
        return auxLista;
    }
    
    public String getItemListaDeProductos(int _index)
    {
        return (String) modelo.getElementAt(_index);
    }
    
    public ArrayList<String> getListaDeProductos()
    {
        ArrayList<String> auxLista = new ArrayList<String>();
        int size = modelo.size();
        for (int i = 0; i < size; i++)
        {
            auxLista.add((String) modelo.elementAt(i));
        }
        return auxLista;
    }
    
    
    
    public String getProductoSeleccionado(){
        return listaProductos.getSelectedValue();
    }
    
    public int getCantidadProductosCompra()
    {
        return modeloCompra.size();
    }
    
    public void quitarElementoCompras(int _index)
    {
        modeloCompra.remove(_index);
    }
    
    public String getCompraSeleccionada()
    {
        return listaCompras.getSelectedValue();
    }
    
    public void setItemProducto(String _item, int _index)
    {
        modelo.setElementAt(_item, _index);
    }
    
    public void setItemCompra(String _item, int _index)
    {
        modeloCompra.setElementAt(_item, _index);
    }
    
    public int getIndexProducto(String elementoSeleccionado){
        return modelo.indexOf(elementoSeleccionado);
    }
    
    public int getIndexCompra(String elementoSeleccionado){
        return modeloCompra.indexOf(elementoSeleccionado);
    }
    
    
    
    /*
    public void activarBotonAgregar(boolean estado){
        btnAgregarCantidad.setEnabled(estado); 
    }
    */
    
    public int getCantidadProductos(){
        return Integer.parseInt(txtCantidadProducto.getText());
    }
    
    public void setTxtPrecioTotal(float precioTotal){
        txtPrecio.setText(String.valueOf(precioTotal));
    }
    
    public void setTxtNumeroTotalDeProductos(int numeroTotalProductos){
        txtCantidadProducto.setText(String.valueOf(numeroTotalProductos));
    }
    
    
    public void addItemListaCompras(String _item)
    {
        modeloCompra.addElement(_item);
    }        
     
    
 
    public void setTxtCantidad(String _text)
    {
        txtCantidadProducto.setText(_text);
    }
    
    public String getTxtCantidad()
    {
        return txtCantidadProducto.getText();
    }
    
    public String getTxtPrecioTotal()
    {
        return txtPrecio.getText();
    }
    
    
    private void setBotonActivo(String boton, JLabel imagenBoton){
        if(btnAgregarActivo){
            Icon btnActivo = new ImageIcon("src//Imagenes//BotonesVender//00-"+boton+"Activo.png"); 
            imagenBoton.setIcon(btnActivo);
        }
        
       
    }
    
    private void setBotonInactivo(String boton, JLabel imagenBoton){
        if(btnAgregarActivo){
            Icon btnInactivo = new ImageIcon("src//Imagenes//BotonesVender//00-"+boton+"Inactivo.png"); 
            imagenBoton.setIcon(btnInactivo);    
        }
        
        
    }
    
    private void setBotonDesactivado(String boton, JLabel imagenBoton){
        
        Icon btnDesactivado = new ImageIcon("src//Imagenes//BotonesVender//00-"+boton+"Desactivado.png"); 
        imagenBoton.setIcon(btnDesactivado);    

        
        
    }
    
    public void addListaProductosListener(ListSelectionListener listenSelectionController){
        listaProductos.addListSelectionListener(listenSelectionController);
    }
    
    public void addListaComprasListener(ListSelectionListener listenSelectionController){
        listaCompras.addListSelectionListener(listenSelectionController);
    }
    
    public void activarTxtCantidad(){
        txtCantidadProducto.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPrecio = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JLabel();
        btnVender = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JLabel();
        txtCantidadProducto = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaCompras = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaProductos = new javax.swing.JList<>();
        fondoVentas = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1086, 503));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPrecio.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtPrecio.setEnabled(false);
        add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(936, 235, 130, 27));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonesVender/00-EliminarDesactivado.png"))); // NOI18N
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarMouseExited(evt);
            }
        });
        add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 430, 144, 55));

        btnVender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonesVender/00-VenderDesactivado.png"))); // NOI18N
        btnVender.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnVender.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnVenderMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVenderMouseExited(evt);
            }
        });
        add(btnVender, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 430, 144, 55));

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BotonesVender/00-AgregarDesactivado.png"))); // NOI18N
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAgregarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAgregarMouseExited(evt);
            }
        });
        add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, 144, 55));

        txtCantidadProducto.setEnabled(false);
        add(txtCantidadProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, 130, 30));

        listaCompras.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaCompras.setMinimumSize(new java.awt.Dimension(45, 93));
        jScrollPane2.setViewportView(listaCompras);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 90, 330, 300));

        listaProductos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaProductos.setMaximumSize(new java.awt.Dimension(45, 93));
        listaProductos.setMinimumSize(new java.awt.Dimension(45, 93));
        listaProductos.setPreferredSize(new java.awt.Dimension(48, 90));
        jScrollPane1.setViewportView(listaProductos);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 330, 390));

        fondoVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ImagenesPaneles/00-PanelDashboardFondo-img.png"))); // NOI18N
        add(fondoVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1086, 503));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseEntered
        setBotonActivo("Agregar", btnAgregar);
    }//GEN-LAST:event_btnAgregarMouseEntered

    private void btnAgregarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseExited
        setBotonInactivo("Agregar", btnAgregar);
    }//GEN-LAST:event_btnAgregarMouseExited

    private void btnVenderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVenderMouseEntered
        setBotonActivo("Vender", btnVender);
    }//GEN-LAST:event_btnVenderMouseEntered

    private void btnVenderMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVenderMouseExited
        setBotonInactivo("Vender", btnVender);
    }//GEN-LAST:event_btnVenderMouseExited

    private void btnEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseEntered
        setBotonActivo("Eliminar", btnEliminar);
    }//GEN-LAST:event_btnEliminarMouseEntered

    private void btnEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseExited
        setBotonInactivo("Eliminar", btnEliminar);
    }//GEN-LAST:event_btnEliminarMouseExited

    
    
    public void addBtnAgregarListener(MouseListener listener){
        btnAgregar.addMouseListener(listener);
    }
    
    public void addBtnEliminarListener(MouseListener listener){
        btnEliminar.addMouseListener(listener);
    }
    
    public void addBtnVenderListener(MouseListener listener){
        btnVender.addMouseListener(listener);
    }

    public boolean isBtnAgregarActivo() {
        return btnAgregarActivo;
    }

    public boolean isBtnEliminarActivo() {
        return btnEliminarActivo;
    }

    public boolean isBtnVenderActivo() {
        return btnVenderActivo;
    }
    
    

    public JLabel getBtnAgregar() {
        return btnAgregar;
    }

    public JLabel getBtnEliminar() {
        return btnEliminar;
    }

    public JLabel getBtnVender() {
        return btnVender;
    }

    public JList<String> getListaCompras() {
        return listaCompras;
    }

    public List<Float> getPreciosAgregados() {
        return preciosAgregados;
    }

    public boolean isSelecionoProductoCompra() {
        return selecionoProductoCompra;
    }

    public void setSelecionoProductoCompra(boolean selecionoProductoCompra) {
        this.selecionoProductoCompra = selecionoProductoCompra;
    }
    
    
    
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAgregar;
    private javax.swing.JLabel btnEliminar;
    private javax.swing.JLabel btnVender;
    private javax.swing.JLabel fondoVentas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listaCompras;
    private javax.swing.JList<String> listaProductos;
    private javax.swing.JTextField txtCantidadProducto;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
