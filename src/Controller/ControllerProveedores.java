/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.ModeloPrincipal;
import Modelo.Proveedor;
import Vistas.PanelProveedores;
import Vistas.PanelProveedoresCRUD;
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
        
        private boolean elementoSeleccionado = false; 
        private int valorSeleccionado;
        
        private void enviarInformacion(Proveedor proveedorSeleccionado, PanelProveedoresCRUD panel){
            String[] dato = new String[6];
                    
            dato[0] = proveedorSeleccionado.getNombreProveedor();
            dato[1] = proveedorSeleccionado.getTelefono();
            dato[2] = proveedorSeleccionado.getDireccion();
            dato[3] = proveedorSeleccionado.getStok();
                    
            panel.ingresarInformacion(dato);
            panel.setDatosActuales(dato);
        }
        
        @Override
        public void mouseClicked(MouseEvent me) {
            if(me.getSource() == vistaProveedor.getTablaProveedores()){
                vistaProveedor.activarBotones();
                valorSeleccionado = vistaProveedor.getTablaProveedores().getSelectedRow();
                elementoSeleccionado = vistaProveedor.getTablaProveedores().getRowSelectionAllowed();
            }
            
            if(elementoSeleccionado){
                if(me.getSource() == vistaProveedor.getBtnVer()){
                    PanelProveedoresCRUD panelProveedorVer = new PanelProveedoresCRUD();
                    vistaDashboard.realizarCambioPanelDashboard(panelProveedorVer);
                    panelProveedorVer.ponerFondoCRUD("Ver");
                    panelProveedorVer.activarBtnEditar();
                    
                    List<Proveedor> datosProveedores = modelo.getInformacion().getListadoProveedor();
                    Proveedor proveedorSeleccionado =  datosProveedores.get(valorSeleccionado);
                    modelo.getInformacion().setProveedorActualInfo(proveedorSeleccionado);
                    
                    enviarInformacion(proveedorSeleccionado, panelProveedorVer);
                    
                    ControllerProveedoresCRUD proveedor = new ControllerProveedoresCRUD(modelo, panelProveedorVer, vistaDashboard);
                    
                }else if(me.getSource() == vistaProveedor.getBtnEditar()){
                    
                    PanelProveedoresCRUD panelProveedorEditar = new PanelProveedoresCRUD();
                    vistaDashboard.realizarCambioPanelDashboard(panelProveedorEditar);
                    panelProveedorEditar.ponerFondoCRUD("Editar");
                    panelProveedorEditar.activarBotones();
                    panelProveedorEditar.activarComponentes();
                    
                    List<Proveedor> datosProveedor = modelo.getInformacion().getListadoProveedor();
                    Proveedor proveedorSeleccionado = datosProveedor.get(valorSeleccionado);
                    modelo.getInformacion().setProveedorActualInfo(proveedorSeleccionado);
                    
                    enviarInformacion(proveedorSeleccionado, panelProveedorEditar);
                    
                    ControllerProveedoresCRUD proveedor = new ControllerProveedoresCRUD(modelo, panelProveedorEditar, vistaDashboard);
                    
                }else if(me.getSource() == vistaProveedor.getBtnEliminar()){
                    
                    if (JOptionPane.showConfirmDialog(null, "¿Seguro que quieres eliminar este usuario?", "Mensaje", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        List<Proveedor> datosProveedores = modelo.getInformacion().getListadoProveedor();
                        Proveedor proveedorSeleccionado = datosProveedores.get(valorSeleccionado);
                        
                        modelo.getInformacion().eliminarProveedor(proveedorSeleccionado);
                        
                        PanelProveedores panelProveedores = new PanelProveedores();
                        vistaDashboard.realizarCambioPanelDashboard(panelProveedores);
                        ControllerProveedores proveedores = new ControllerProveedores(modelo, panelProveedores, vistaDashboard);
                    }
                }
            }if(me.getSource() == vistaProveedor.getBtnCrear()){
                    
                PanelProveedoresCRUD panelProveedoresCrear = new PanelProveedoresCRUD();
                vistaDashboard.realizarCambioPanelDashboard(panelProveedoresCrear);
                panelProveedoresCrear.ponerFondoCRUD("Crear");
                panelProveedoresCrear.activarBotones();
                panelProveedoresCrear.activarComponentes();
                panelProveedoresCrear.limpiarCampos();
                
                ControllerProveedoresCRUD proveedores = new ControllerProveedoresCRUD(modelo, panelProveedoresCrear, vistaDashboard);
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
