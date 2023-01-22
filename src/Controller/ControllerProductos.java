/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.ModeloPrincipal;
import Modelo.Producto;
import Modelo.Proveedor;
import Modelo.Usuario;
import Vistas.PanelClientes;
import Vistas.PanelProductos;
import Vistas.PanelProductosCRUD;
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
        
        private boolean elementoSeleccionado = false; 
        private int valorSeleccionado;
        
        private void enviarInformacion(Producto productoSeleccionado, PanelProductosCRUD panel){
            String[] dato = new String[6];
                    
            dato[0] = productoSeleccionado.getNombre();
            dato[1] = productoSeleccionado.getPrecioProducto() + "";
            dato[2] = productoSeleccionado.getUnidades() + "";
            dato[3] = modelo.getInformacion().getProveedor(productoSeleccionado.getIdProveedor()).getNombreProveedor();
                    
            panel.ingresarInformacion(dato);
            panel.setDatosActuales(dato);
        }
      
        @Override
        public void mouseClicked(MouseEvent me) {
            if(me.getSource() == vistaProductos.getTablaProductos()){
                vistaProductos.activarBotones();
                valorSeleccionado = vistaProductos.getTablaProductos().getSelectedRow();
                elementoSeleccionado = vistaProductos.getTablaProductos().getRowSelectionAllowed();
            }
            
            if(elementoSeleccionado){
                if(me.getSource() == vistaProductos.getBtnVer()){
                    PanelProductosCRUD panelProductosVer = new PanelProductosCRUD();
                    vistaDashboard.realizarCambioPanelDashboard(panelProductosVer);
                    panelProductosVer.ponerFondoCRUD("Ver");
                    panelProductosVer.activarBtnEditar();
                    
                    List<Producto> datosProductos = modelo.getInformacion().getListadoProducto();
                    Producto productoSeleccionado =  datosProductos.get(valorSeleccionado);
                    modelo.getInformacion().setProductoActualInfo(productoSeleccionado);
                    
                    enviarInformacion(productoSeleccionado, panelProductosVer);
                    
                    ControllerProductosCRUD producto = new ControllerProductosCRUD(modelo, panelProductosVer, vistaDashboard, "");
                    
                }else if(me.getSource() == vistaProductos.getBtnEditar()){
                    
                    PanelProductosCRUD panelProductoEditar = new PanelProductosCRUD();
                    vistaDashboard.realizarCambioPanelDashboard(panelProductoEditar);
                    panelProductoEditar.ponerFondoCRUD("Editar");
                    panelProductoEditar.activarBotones();
                    panelProductoEditar.activarComponentes();
                    
                    List<Producto> datosProductos = modelo.getInformacion().getListadoProducto();
                    Producto proveedorSeleccionado = datosProductos.get(valorSeleccionado);
                    modelo.getInformacion().setProductoActualInfo(proveedorSeleccionado);
                    
                    enviarInformacion(proveedorSeleccionado, panelProductoEditar);
                    
                    ControllerProductosCRUD producto = new ControllerProductosCRUD(modelo, panelProductoEditar, vistaDashboard);
                    
                }else if(me.getSource() == vistaProductos.getBtnEliminar()){
                    
                    if (JOptionPane.showConfirmDialog(null, "¿Seguro que quieres eliminar este usuario?", "Mensaje", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        List<Producto> datosProductos = modelo.getInformacion().getListadoProducto();
                        Producto productoSeleccionado = datosProductos.get(valorSeleccionado);
                        
                        modelo.getInformacion().eliminarProducto(productoSeleccionado);
                        
                        PanelProductos panelProductos = new PanelProductos();
                        vistaDashboard.realizarCambioPanelDashboard(panelProductos);
                        ControllerProductos productos = new ControllerProductos(modelo, panelProductos, vistaDashboard);
                    }
                }
            }if(me.getSource() == vistaProductos.getBtnCrear()){
                    
                PanelProductosCRUD panelProductosCrear = new PanelProductosCRUD();
                vistaDashboard.realizarCambioPanelDashboard(panelProductosCrear);
                panelProductosCrear.ponerFondoCRUD("Crear");
                panelProductosCrear.activarBotones();
                panelProductosCrear.activarComponentes();
                panelProductosCrear.limpiarCampos();
                
                ControllerProductosCRUD productos = new ControllerProductosCRUD(modelo, panelProductosCrear, vistaDashboard);
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
