/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.ModeloPrincipal;
import Vistas.PanelAfiliados;
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
        
        vistaDashboard.addBtnAfiliadosListener(listener);
    }
    
    
    class DashboardListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent me) {
            if(me.getSource() == vistaDashboard.getBtnAfiliados()){
                PanelAfiliados panelAfiliados = new PanelAfiliados();
                vistaDashboard.realizarCambioPanelDashboard(panelAfiliados);
                ControllerAfiliados afiliados = new ControllerAfiliados(modelo, panelAfiliados);
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
