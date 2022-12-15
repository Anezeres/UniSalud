/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.ModeloPrincipal;
import Vistas.PanelAfiliados;
import Vistas.PanelTrabajadores;
import Vistas.PanelUsuariosCRUD;
import Vistas.VistaDashboard;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author RYZEN
 */
public class ControllerUsuariosCRUD {
    
    private ModeloPrincipal modelo;
    private PanelUsuariosCRUD vistaUsuario;
    private VistaDashboard vistaDashboard;
    

    public ControllerUsuariosCRUD(ModeloPrincipal modelo, PanelUsuariosCRUD vista, VistaDashboard dashboard) {
        this.modelo = modelo;
        this.vistaUsuario = vista;
        this.vistaDashboard = dashboard;
        
        agregarListenersBtnDashBoard();
        
    }
    
    private void agregarListenersBtnDashBoard(){
        DashboardListener listener = new DashboardListener();
        
        vistaUsuario.addBtnEditarListener(listener);
        vistaUsuario.addBtnAceptarListener(listener);
        vistaUsuario.addBtnCancelarListener(listener);
        vistaUsuario.addBtnVolverListener(listener);
    }
    
    class DashboardListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent me) {
            
            if(me.getSource() == vistaUsuario.getBtnEditar() && vistaUsuario.isBtnEditarActivo()){
                vistaUsuario.activarBotones();
                vistaUsuario.ponerFondoCRUD("Editar");
                vistaUsuario.activarComponentes();
                
            }else if(me.getSource() == vistaUsuario.getBtnVolver()){
                /*
                PanelAfiliados panelAfiliados = new PanelAfiliados();
                vistaDashboard.realizarCambioPanelDashboard(panelAfiliados);
                ControllerAfiliados afiliados = new ControllerAfiliados(modelo, panelAfiliados,vistaDashboard);
                */
                
                regresarVentana(vistaDashboard.getTipoAccionActual());
            }else if(me.getSource() == vistaUsuario.getBtnCancelar() && vistaUsuario.isBtnCancelarActivo()){
                if (JOptionPane.showConfirmDialog(null, "¿Seguro que cancelar la edición?", "Mensaje", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    regresarVentana(vistaDashboard.getTipoAccionActual());
                }
                
            }else if(me.getSource() == vistaUsuario.getBtnAceptar() && vistaUsuario.isBtnAceptarActivo()){
                if(vistaUsuario.validarCampos()){
                    if (JOptionPane.showConfirmDialog(null, "¿Seguro que quiere crear un afiliado con la información ingresada?", "Mensaje", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        
                        String[] datos = vistaUsuario.obtenerInformacion();
                        
                        if("Crear".equals(vistaUsuario.getAccionActual())){
                            modelo.getInformacion().crearUsuario(datos, vistaDashboard.getTipoAccionActual());
                        }else if("Editar".equals(vistaUsuario.getAccionActual())){
                           modelo.getInformacion().cambiarInfoUsuario(datos, modelo.getInformacion().getUsuarioActualInfo().getId(), vistaDashboard.getTipoAccionActual());
                        }
                        
                        regresarVentana(vistaDashboard.getTipoAccionActual());
                        
                    }
                }else{
                    if (JOptionPane.showConfirmDialog(null, "Debe completar todos los campos", "Mensaje", JOptionPane.CLOSED_OPTION) == JOptionPane.YES_OPTION) {
                    }
                    
                }
                
                
            }
            
            
            
        }
        
        private void regresarVentana(String ventanaActual){
            if("Afiliado".equals(ventanaActual)){
                vistaDashboard.setTipoAccionActual("Afiliado");
                PanelAfiliados panelAfiliados = new PanelAfiliados();
                vistaDashboard.realizarCambioPanelDashboard(panelAfiliados);
                ControllerAfiliados afiliados = new ControllerAfiliados(modelo, panelAfiliados ,vistaDashboard);
            }else if(ventanaActual == "Trabajador"){
                vistaDashboard.setTipoAccionActual("Trabajador");
                PanelTrabajadores panelTrabajadores = new PanelTrabajadores();
                vistaDashboard.realizarCambioPanelDashboard(panelTrabajadores);
                ControllerTrabajadores trabajadores = new ControllerTrabajadores(modelo, panelTrabajadores ,vistaDashboard);
            
                
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
