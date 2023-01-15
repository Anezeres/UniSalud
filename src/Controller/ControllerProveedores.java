/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.ModeloPrincipal;
import Modelo.Proveedor;
import Modelo.Usuario;
import Vistas.PanelClientes;
import Vistas.PanelProveedores;
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
public class ControllerProveedores {
    
    private ModeloPrincipal modelo;
    private PanelProveedores vistaProveedor;
    private VistaDashboard vistaDashboard;
    

    public ControllerProveedores(ModeloPrincipal modelo, PanelProveedores vista, VistaDashboard dashboard) {
        this.modelo = modelo;
        this.vistaProveedor = vista;
        this.vistaDashboard = dashboard;
        
        agregarListenersBtnDashBoard();
        llenarTabla();
        
    }
    
    private void agregarListenersBtnDashBoard(){
        ProveedoresListener listener = new ProveedoresListener();
        
        vistaProveedor.addTablaProveedoresListener(listener);
        vistaProveedor.addBtnVerListener(listener);
        vistaProveedor.addBtnEditarListener(listener);
        vistaProveedor.addBtnEliminarListener(listener);
        vistaProveedor.addBtnCrearListener(listener);
    }
    
     private void llenarTabla(){
        List<Proveedor> proveedores = modelo.getInformacion().getListadoProveedor();
        String[] dato = new String[6];
        
        for (Proveedor proveedor : proveedores) {
            dato[0] = proveedor.getNombreProveedor();
            dato[1] = proveedor.getTelefono();
            dato[2] = proveedor.getDireccion();
            dato[3] = proveedor.getStok();
            
            vistaProveedor.agregarDatosTabla(dato);
        }
        
    }
    
    class ProveedoresListener implements MouseListener{
        
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
