/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.ModeloPrincipal;
import Modelo.Producto;
import Modelo.Usuario;
import Vistas.PanelClientes;
import Vistas.PanelProductos;
import Vistas.PanelUsuariosCRUD;
import Vistas.VistaDashboard;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author RYZEN
 */
public class ControllerProductos {
    private PanelProductos vistaProductos;
    private VistaDashboard vistaDashboard;
    private ModeloPrincipal modelo;
    

    public ControllerProductos(ModeloPrincipal modelo, PanelProductos vista, VistaDashboard dashboard) {
        this.modelo = modelo;
        this.vistaProductos = vista;
        this.vistaDashboard = dashboard;
        
        agregarListenersBtnDashBoard();
        
        llenarTabla();
        
    }
    
    private void agregarListenersBtnDashBoard(){
        DashboardListener listener = new DashboardListener();
        
        vistaProductos.addTablaProductosListener(listener);
        vistaProductos.addBtnVerListener(listener);
        vistaProductos.addBtnEditarListener(listener);
        vistaProductos.addBtnEliminarListener(listener);
        vistaProductos.addBtnCrearListener(listener);
    }
    
    
    
    private void llenarTabla(){
        List<Producto> productos = modelo.getInformacion().getListadoProducto();
        String[] dato = new String[4];
        
        for (Producto producto : productos) {
            dato[0] = producto.getNombre();
            dato[1] =  "$" + producto.getPrecioProducto();
            dato[2] = "" + producto.getUnidades();
            dato[3] = modelo.getInformacion().getProveedor(producto.getIdProducto()).getNombreProveedor();
            
            vistaProductos.agregarDatosTabla(dato);
        }
        
    }
    
    class DashboardListener implements MouseListener{
      
        @Override
        public void mouseClicked(MouseEvent me) {
            
        }

        @Override
        public void mousePressed(MouseEvent me) {
        }

        @Override
        public void mouseReleased(MouseEvent me) {
        }

        @Override
        public void mouseEntered(MouseEvent me) {
        }

        @Override
        public void mouseExited(MouseEvent me) {
        }
        
        
        
    }
}
