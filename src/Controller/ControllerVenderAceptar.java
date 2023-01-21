/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.ModeloPrincipal;
import Modelo.Registro;
import Vistas.PanelVender;
import Vistas.PanelVenderAceptar;
import Vistas.VistaDashboard;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

/**
 *
 * @author RYZEN
 */
public class ControllerVenderAceptar {
    private ModeloPrincipal modelo;
    private PanelVenderAceptar vistaVenderAceptar;
    private VistaDashboard vistaDashboard;
    
    

    public ControllerVenderAceptar(ModeloPrincipal modelo, PanelVenderAceptar vistaVenderAceptar, VistaDashboard vistaDashboard) {
        this.modelo = modelo;
        this.vistaVenderAceptar = vistaVenderAceptar;
        this.vistaDashboard = vistaDashboard;
        
        llenarTabla();
        
        agregarListenersVender();
    }
    
    private void llenarTabla(){
        List<Registro> registros = modelo.getInformacion().getRegistroVentaActual();
        String[] dato = new String[4];
        
        for (Registro registro : registros) {
            dato[0] = registro.getNombreProducto();
            dato[1] = registro.getPrecioVenta() + "$";
            dato[2] = registro.getUnidades() + " u"; 
            dato[3] = registro.getTotal() + "$";
            
            vistaVenderAceptar.agregarDatosTabla(dato);
        }
        
    }
    
    private void agregarListenersVender(){
        
        VenderAceptarListener listener = new VenderAceptarListener();
        vistaVenderAceptar.addBtnAceptarListener(listener);   
        
    }
    
    class VenderAceptarListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getSource() == vistaVenderAceptar.getBtnAceptar()){
                modelo.getInformacion().aceptarCompraRegistros();
                PanelVender vista = new PanelVender();
                vistaDashboard.realizarCambioPanelDashboard(vista);
                ControllerVender vender = new ControllerVender(modelo, vista, vistaDashboard);
                
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }
    
}
