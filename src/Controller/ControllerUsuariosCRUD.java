/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.ModeloPrincipal;
import Vistas.PanelAfiliados;
import Vistas.PanelUsuariosCRUD;
import Vistas.VistaDashboard;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author RYZEN
 */
public class ControllerUsuariosCRUD {
    
    private ModeloPrincipal modelo;
    private PanelUsuariosCRUD vistaAfiliados;
    private VistaDashboard vistaDashboard;
    

    public ControllerUsuariosCRUD(ModeloPrincipal modelo, PanelUsuariosCRUD vista, VistaDashboard dashboard) {
        this.modelo = modelo;
        this.vistaAfiliados = vista;
        this.vistaDashboard = dashboard;
        
        agregarListenersBtnDashBoard();
        
    }
    
    private void agregarListenersBtnDashBoard(){
        DashboardListener listener = new DashboardListener();
        
        vistaAfiliados.addBtnEditarListener(listener);
        vistaAfiliados.addBtnAceptarListener(listener);
        vistaAfiliados.addBtnCancelarListener(listener);
        vistaAfiliados.addBtnVolverListener(listener);
    }
    
    class DashboardListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent me) {
            if(me.getSource() == vistaAfiliados.getBtnEditar()){
                vistaAfiliados.activarBotones();
                vistaAfiliados.ponerFondoCRUD("Editar");
                vistaAfiliados.activarComponentes();
            }else if(me.getSource() == vistaAfiliados.getBtnVolver()){
                PanelAfiliados panelAfiliados = new PanelAfiliados();
                vistaDashboard.realizarCambioPanelDashboard(panelAfiliados);
                ControllerAfiliados afiliados = new ControllerAfiliados(modelo, panelAfiliados,vistaDashboard);
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
