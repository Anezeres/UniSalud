/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.ModeloPrincipal;
import Vistas.PanelProductos;
import Vistas.PanelClientes;
import Vistas.PanelProveedores;
import Vistas.PanelVender;
import Vistas.VistaDashboard;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author RYZEN
 */
public class ControllerDashboard {
    
    private ModeloPrincipal modelo;
    private VistaDashboard vistaDashboard;

    public ControllerDashboard(ModeloPrincipal modelo, VistaDashboard vista) {
        this.modelo = modelo;
        this.vistaDashboard = vista;
        
        agregarListenersBtnDashBoard();
        
    }
    
    private void agregarListenersBtnDashBoard(){
        DashboardListener listener = new DashboardListener();
        
        vistaDashboard.addBtnProductosListener(listener);
        vistaDashboard.addBtnProveedoresListener(listener);
        vistaDashboard.addBtnClientesListener(listener);
        vistaDashboard.addBtnVenderListener(listener);
        vistaDashboard.addBtnRegistrosListener(listener);
    }
    
    
    class DashboardListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent me) {
            if(me.getSource() == vistaDashboard.getBtnProductos()){
                vistaDashboard.setTipoAccionActual("Producto");
                PanelProductos panelProductos = new PanelProductos();
                vistaDashboard.realizarCambioPanelDashboard(panelProductos);
                ControllerProductos productos = new ControllerProductos(modelo, panelProductos, vistaDashboard);
            }else if(me.getSource() == vistaDashboard.getBtnProveedores()){
                
                vistaDashboard.setTipoAccionActual("Proveedor");
                PanelProveedores panelProveedores = new PanelProveedores();
                vistaDashboard.realizarCambioPanelDashboard(panelProveedores);
                ControllerProveedores proveedores = new ControllerProveedores(modelo, panelProveedores, vistaDashboard);
            }else if(me.getSource() == vistaDashboard.getBtnClientes()){
                vistaDashboard.setTipoAccionActual("Clientes");
                PanelClientes panelClientes = new PanelClientes();
                vistaDashboard.realizarCambioPanelDashboard(panelClientes);
                ControllerUsuarios clientes  = new ControllerUsuarios(modelo, panelClientes ,vistaDashboard);
            }else if(me.getSource() == vistaDashboard.getBtnVender()){
                vistaDashboard.setTipoAccionActual("Vender");
                PanelVender panelVender = new PanelVender();
                vistaDashboard.realizarCambioPanelDashboard(panelVender);
                //ControllerCitas citas = new ControllerCitas(modelo, panelCitas ,vistaDashboard);
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
