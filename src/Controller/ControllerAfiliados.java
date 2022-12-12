/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.ModeloPrincipal;
import Modelo.Usuario;
import Vistas.PanelAfiliados;
import Vistas.VistaDashboard;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

/**
 *
 * @author evalab
 */
public class ControllerAfiliados {
    
    private ModeloPrincipal modelo;
    private PanelAfiliados vistaAfiliados;

    public ControllerAfiliados(ModeloPrincipal modelo, PanelAfiliados vista) {
        this.modelo = modelo;
        this.vistaAfiliados = vista;
        
        agregarListenersBtnDashBoard();
        
        llenarTabla();
        
    }
    
    private void agregarListenersBtnDashBoard(){
        DashboardListener listener = new DashboardListener();
        
        vistaAfiliados.addTablaAfiliadosListener(listener);
    }
    
    
    
    private void llenarTabla(){
        List<Usuario> afiliados = modelo.getInformacion().getAfiliados();
        String[] dato = new String[6];
        
        for (Usuario afiliado : afiliados) {
            dato[0] = afiliado.getCedula();
            dato[1] = afiliado.getNombre();
            dato[2] = afiliado.getTelefono();
            dato[3] = afiliado.getEmail();
            dato[4] = afiliado.getDireccion();
            dato[5] = afiliado.getSexo();
            
            vistaAfiliados.agregarDatosTabla(dato);
        }
        
    }
    
    class DashboardListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent me) {
            if(me.getSource() == vistaAfiliados.getTablaAfiliados()){
                vistaAfiliados.activarBotones();
                System.out.println("Hola mundo");
                
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
