/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.Cita;
import Modelo.ModeloPrincipal;
import Modelo.Usuario;
import Vistas.PanelAfiliados;
import Vistas.PanelCitas;
import Vistas.PanelTrabajadores;
import Vistas.PanelUsuariosCRUD;
import Vistas.VistaDashboard;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author evalab
 */
public class ControllerCitas {
    
    private ModeloPrincipal modelo;
    private PanelCitas vistaCitas;
    private VistaDashboard vistaDashboard;
    

    public ControllerCitas(ModeloPrincipal modelo, PanelCitas vista, VistaDashboard dashboard) {
        this.modelo = modelo;
        this.vistaCitas = vista;
        this.vistaDashboard = dashboard;
        
        agregarListenersBtnDashBoard();
        
        llenarTabla();
        
    }
    
    private void agregarListenersBtnDashBoard(){
        DashboardListener listener = new DashboardListener();
        
        vistaCitas.addTablaTrabajadoresListener(listener);
        vistaCitas.addBtnVerListener(listener);
        vistaCitas.addBtnEditarListener(listener);
        vistaCitas.addBtnEliminarListener(listener);
        vistaCitas.addBtnCrearListener(listener);
    }
    
    
    
    private void llenarTabla(){
        List<Cita> citas = modelo.getInformacion().getListadoCitas();
        
        String[] dato = new String[7];
        for (Cita cita : citas) {
            dato[0] = cita.getFecha();
            dato[1] = cita.getHora();
            dato[2] = modelo.getInformacion().getUsuario(cita.getIdTrabajador()).getNombre();
            dato[3] = modelo.getInformacion().getUsuario(cita.getIdAfiliado()).getNombre();
            dato[4] = modelo.getInformacion().getUsuario(cita.getIdTrabajador()).getRolUsuario();
            dato[5] = cita.getPiso();
            dato[6] = cita.getSala();
            vistaCitas.agregarDatosTabla(dato);
        }
        
    }
    
    class DashboardListener implements MouseListener{
        
        private boolean elementoSeleccionado = false; 
        private int valorSeleccionado;
        
        private void enviarInformacion(Usuario usuarioSeleccionado, PanelUsuariosCRUD panel){
            String[] dato = new String[7];
                    
                    dato[0] = usuarioSeleccionado.getNombre();
                    dato[1] = usuarioSeleccionado.getCedula();
                    dato[2] = usuarioSeleccionado.getTelefono();
                    dato[3] = usuarioSeleccionado.getEmail();
                    dato[4] = usuarioSeleccionado.getDireccion();
                    dato[5] = usuarioSeleccionado.getSexo();
                    dato[6] = usuarioSeleccionado.getRolUsuario();
                    
                    panel.ingresarInformacionTrabajador(dato);
                    panel.setDatosActuales(dato);
        }

        @Override
        public void mouseClicked(MouseEvent me) {
            if(me.getSource() == vistaCitas.getTablaTrabajadores()){
                vistaCitas.activarBotones();
                valorSeleccionado = vistaCitas.getTablaTrabajadores().getSelectedRow();
                elementoSeleccionado = vistaCitas.getTablaTrabajadores().getRowSelectionAllowed();
            }
            
            if(elementoSeleccionado){
                if(me.getSource() == vistaCitas.getBtnVer()){
                    PanelUsuariosCRUD panelAfiliadosVer = new PanelUsuariosCRUD();
                    vistaDashboard.realizarCambioPanelDashboard(panelAfiliadosVer);
                    panelAfiliadosVer.ponerFondoCRUDTrabajadores("Ver");
                    panelAfiliadosVer.activarBtnEditar();
                    
                    List<Usuario> datosAfiliados = modelo.getInformacion().getTrabajadores();
                    Usuario afiliadoSeleccionado =  datosAfiliados.get(valorSeleccionado);
                    modelo.getInformacion().setUsuarioActualInfo(afiliadoSeleccionado);
                    
                    enviarInformacion(afiliadoSeleccionado, panelAfiliadosVer);
                    
                    ControllerUsuariosCRUD afiliados = new ControllerUsuariosCRUD(modelo, panelAfiliadosVer, vistaDashboard);
                    
                }else if(me.getSource() == vistaCitas.getBtnEditar()){
                    
                    PanelUsuariosCRUD panelAfiliadosEditar = new PanelUsuariosCRUD();
                    vistaDashboard.realizarCambioPanelDashboard(panelAfiliadosEditar);
                    panelAfiliadosEditar.ponerFondoCRUDTrabajadores("Editar");
                    panelAfiliadosEditar.activarBotones();
                    panelAfiliadosEditar.activarComponentes();
                    
                    List<Usuario> datosAfiliados = modelo.getInformacion().getTrabajadores();
                    Usuario afiliadoSeleccionado =  datosAfiliados.get(valorSeleccionado);
                    modelo.getInformacion().setUsuarioActualInfo(afiliadoSeleccionado);
                    
                    enviarInformacion(afiliadoSeleccionado, panelAfiliadosEditar);
                    
                    ControllerUsuariosCRUD afiliados = new ControllerUsuariosCRUD(modelo, panelAfiliadosEditar, vistaDashboard);
                }else if(me.getSource() == vistaCitas.getBtnEliminar()){
                    
                    if (JOptionPane.showConfirmDialog(null, "¿Seguro que quieres eliminar este afiliado?", "Mensaje", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        List<Usuario> datosAfiliados = modelo.getInformacion().getTrabajadores();
                        Usuario afiliadoSeleccionado =  datosAfiliados.get(valorSeleccionado);
                        modelo.getInformacion().eliminarUsuario(afiliadoSeleccionado);
                        
                        PanelTrabajadores panelTrabajadores = new PanelTrabajadores();
                        vistaDashboard.realizarCambioPanelDashboard(panelTrabajadores);
                        ControllerCitas afiliados = new ControllerCitas(modelo, vistaCitas,vistaDashboard);
                    }
                }
            }
            if(me.getSource() == vistaCitas.getBtnCrear()){
                    
                PanelUsuariosCRUD panelTrabajadoresCrear = new PanelUsuariosCRUD();
                vistaDashboard.realizarCambioPanelDashboard(panelTrabajadoresCrear);
                panelTrabajadoresCrear.ponerFondoCRUDTrabajadores("Crear");
                panelTrabajadoresCrear.activarBotones();
                panelTrabajadoresCrear.activarComponentes();
                panelTrabajadoresCrear.limpiarCampos();
                    
                ControllerUsuariosCRUD afiliados = new ControllerUsuariosCRUD(modelo, panelTrabajadoresCrear, vistaDashboard);
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
