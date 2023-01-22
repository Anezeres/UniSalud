/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.ModeloPrincipal;
import Vistas.PanelClientes;
import Vistas.PanelProveedores;
import Vistas.PanelProveedoresCRUD;
import Vistas.PanelUsuariosCRUD;
import Vistas.VistaDashboard;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author RYZEN
 */
public class ControllerProveedoresCRUD {
    
    private ModeloPrincipal modelo;
    private PanelProveedoresCRUD vistaProveedor;
    private VistaDashboard vistaDashboard;
    

    public ControllerProveedoresCRUD(ModeloPrincipal modelo, PanelProveedoresCRUD vista, VistaDashboard dashboard) {
        this.modelo = modelo;
        this.vistaProveedor = vista;
        this.vistaDashboard = dashboard;
        
        agregarListenersBtnDashBoard();
        
    }
    
    private void agregarListenersBtnDashBoard(){
        DashboardListener listener = new DashboardListener();
        
        vistaProveedor.addBtnEditarListener(listener);
        vistaProveedor.addBtnAceptarListener(listener);
        vistaProveedor.addBtnCancelarListener(listener);
        vistaProveedor.addBtnVolverListener(listener);
    }
    
    class DashboardListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent me) {
            
            if(me.getSource() == vistaProveedor.getBtnEditar() && vistaProveedor.isBtnEditarActivo()){
                activarVentanaEditar(vistaDashboard.getTipoAccionActual());
                
            }else if(me.getSource() == vistaProveedor.getBtnVolver()){
                
                regresarVentana(vistaDashboard.getTipoAccionActual());
                
            }else if(me.getSource() == vistaProveedor.getBtnCancelar() && vistaProveedor.isBtnCancelarActivo()){
                if (JOptionPane.showConfirmDialog(null, "¿Seguro que cancelar la edición?", "Mensaje", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    regresarVentana(vistaDashboard.getTipoAccionActual());
                }
                
            }else if(me.getSource() == vistaProveedor.getBtnAceptar() && vistaProveedor.isBtnAceptarActivo()){
                if(vistaProveedor.validarCampos()){
                    if (JOptionPane.showConfirmDialog(null, "¿Seguro que quiere crear un afiliado con la información ingresada?", "Mensaje", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        
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
            
            vistaDashboard.setTipoAccionActual("Proveedor");
            PanelProveedores proveedor = new PanelProveedores();
            vistaDashboard.realizarCambioPanelDashboard(proveedor);
            ControllerProveedores proveedores = new ControllerProveedores(modelo, proveedor, vistaDashboard);
            
        }
        
        private void activarVentanaEditar(String ventanaActual){
            vistaProveedor.activarBotones();
            vistaProveedor.ponerFondoCRUD("Editar");
            vistaProveedor.activarComponentes();
            
        }
        
        private void accionAceptar(String ventanaActual){
            String[] datos = new String[0];
            datos = vistaProveedor.obtenerInformacion();

               
            if("Crear".equals(vistaProveedor.getAccionActual())){
                modelo.getInformacion().crearUsuario(datos);
            }else if("Editar".equals(vistaProveedor.getAccionActual())){
                modelo.getInformacion().cambiarInfoProveedor(datos, modelo.getInformacion().getProveedorActualInfo().getIdProveedor());
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
