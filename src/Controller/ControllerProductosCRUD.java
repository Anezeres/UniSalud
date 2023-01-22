/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.ModeloPrincipal;
import Modelo.Proveedor;
import Vistas.PanelClientes;
import Vistas.PanelProductos;
import Vistas.PanelProductosCRUD;
import Vistas.PanelProveedores;
import Vistas.PanelProveedoresCRUD;
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
public class ControllerProductosCRUD {
    
    private ModeloPrincipal modelo;
    private PanelProductosCRUD vistaProductos;
    private VistaDashboard vistaDashboard;
    

    public ControllerProductosCRUD(ModeloPrincipal modelo, PanelProductosCRUD vista, VistaDashboard dashboard) {
        this.modelo = modelo;
        this.vistaProductos = vista;
        this.vistaDashboard = dashboard;
        
        agregarListenersBtnDashBoard();
        llenarComboBoxProveedores();
        
    }
    
    public ControllerProductosCRUD(ModeloPrincipal modelo, PanelProductosCRUD vista, VistaDashboard dashboard, String dato) {
        this.modelo = modelo;
        this.vistaProductos = vista;
        this.vistaDashboard = dashboard;
        
        agregarListenersBtnDashBoard();
        
    }
    
    public void llenarComboBoxProveedores(){
        List<Proveedor> proveedores = modelo.getInformacion().getListadoProveedor();
        String[] dato = new String[proveedores.size()];
        
        int i = 0;
        for (Proveedor proveedor : proveedores) {
            dato[i] = proveedor.getNombreProveedor() + "";
            i++;
            
        }
                
        vistaProductos.llenarComboProveedores(dato);
    }
    
    private void agregarListenersBtnDashBoard(){
        DashboardListener listener = new DashboardListener();
        
        vistaProductos.addBtnEditarListener(listener);
        vistaProductos.addBtnAceptarListener(listener);
        vistaProductos.addBtnCancelarListener(listener);
        vistaProductos.addBtnVolverListener(listener);
    }
    
    class DashboardListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent me) {
            
            if(me.getSource() == vistaProductos.getBtnEditar() && vistaProductos.isBtnEditarActivo()){
                activarVentanaEditar(vistaDashboard.getTipoAccionActual());
                
            }else if(me.getSource() == vistaProductos.getBtnVolver()){
                
                regresarVentana(vistaDashboard.getTipoAccionActual());
                
            }else if(me.getSource() == vistaProductos.getBtnCancelar() && vistaProductos.isBtnCancelarActivo()){
                if (JOptionPane.showConfirmDialog(null, "¿Seguro que cancelar la edición?", "Mensaje", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    regresarVentana(vistaDashboard.getTipoAccionActual());
                }
                
            }else if(me.getSource() == vistaProductos.getBtnAceptar() && vistaProductos.isBtnAceptarActivo()){
                if(vistaProductos.validarCampos()){
                    if (JOptionPane.showConfirmDialog(null, "¿Seguro que quiere crear un producto con la información ingresada?", "Mensaje", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        
                        accionAceptar(vistaDashboard.getTipoAccionActual());
                        
                        regresarVentana(vistaDashboard.getTipoAccionActual());
                        
                    }
                }else{
                    if (JOptionPane.showConfirmDialog(null, "Debe completar todos los campos", "Mensaje", JOptionPane.CLOSED_OPTION) == JOptionPane.YES_OPTION) {
                    }
                    
                }
                
                
            }
            
            
            
        }
        
        private void regresarVentana(String ventanaActual){
            
            vistaDashboard.setTipoAccionActual("Producto");
            PanelProductos producto = new PanelProductos();
            vistaDashboard.realizarCambioPanelDashboard(producto);
            ControllerProductos productos = new ControllerProductos(modelo, producto, vistaDashboard);
            
        }
        
        private void activarVentanaEditar(String ventanaActual){
            vistaProductos.activarBotones();
            vistaProductos.ponerFondoCRUD("Editar");
            vistaProductos.activarComponentes();
            
        }
        
        private void accionAceptar(String ventanaActual){
            String[] datos = new String[0];
            datos = vistaProductos.obtenerInformacion();

               
            if("Crear".equals(vistaProductos.getAccionActual())){
                modelo.getInformacion().crearUsuario(datos);
            }else if("Editar".equals(vistaProductos.getAccionActual())){
                modelo.getInformacion().cambiarInfoProducto(datos, modelo.getInformacion().getProductoActualInfo().getIdProducto());
            }
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
