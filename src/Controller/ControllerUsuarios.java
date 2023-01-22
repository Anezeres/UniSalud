/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.ModeloPrincipal;
import Modelo.Usuario;
import Vistas.PanelClientes;
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
public class ControllerUsuarios {private ModeloPrincipal modelo;
    private PanelClientes vistaClientes;
    private VistaDashboard vistaDashboard;
    

    public ControllerUsuarios(ModeloPrincipal modelo, PanelClientes vista, VistaDashboard dashboard) {
        this.modelo = modelo;
        this.vistaClientes = vista;
        this.vistaDashboard = dashboard;
        
        agregarListenersBtnDashBoard();
        
        llenarTabla();
        
    }
    
    private void agregarListenersBtnDashBoard(){
        DashboardListener listener = new DashboardListener();
        
        vistaClientes.addTablaClientesListener(listener);
        vistaClientes.addBtnVerListener(listener);
        vistaClientes.addBtnEditarListener(listener);
        vistaClientes.addBtnEliminarListener(listener);
        vistaClientes.addBtnCrearListener(listener);
    }
    
    
    
    private void llenarTabla(){
        List<Usuario> afiliados = modelo.getInformacion().getListadoUsuario();
        String[] dato = new String[6];
        
        for (Usuario afiliado : afiliados) {
            dato[0] = afiliado.getCedula();
            dato[1] = afiliado.getNombre();
            dato[2] = afiliado.getTelefono();
            dato[3] = afiliado.getEmail();
            dato[4] = afiliado.getDireccion();
            dato[5] = afiliado.getSexo();
            
            vistaClientes.agregarDatosTabla(dato);
        }
        
    }
    
    class DashboardListener implements MouseListener{
        
        private boolean elementoSeleccionado = false; 
        private int valorSeleccionado;
        
        private void enviarInformacion(Usuario usuarioSeleccionado, PanelUsuariosCRUD panel){
            String[] dato = new String[6];
                    
                    dato[0] = usuarioSeleccionado.getNombre();
                    dato[1] = usuarioSeleccionado.getCedula();
                    dato[2] = usuarioSeleccionado.getTelefono();
                    dato[3] = usuarioSeleccionado.getEmail();
                    dato[4] = usuarioSeleccionado.getDireccion();
                    dato[5] = usuarioSeleccionado.getSexo();
                    
                    panel.ingresarInformacion(dato);
                    panel.setDatosActuales(dato);
        }

        @Override
        public void mouseClicked(MouseEvent me) {
            if(me.getSource() == vistaClientes.getTablaClientes()){
                vistaClientes.activarBotones();
                valorSeleccionado = vistaClientes.getTablaClientes().getSelectedRow();
                elementoSeleccionado = vistaClientes.getTablaClientes().getRowSelectionAllowed();
            }
            
            if(elementoSeleccionado){
                if(me.getSource() == vistaClientes.getBtnVer()){
                    PanelUsuariosCRUD panelAfiliadosVer = new PanelUsuariosCRUD();
                    vistaDashboard.realizarCambioPanelDashboard(panelAfiliadosVer);
                    panelAfiliadosVer.ponerFondoCRUD("Ver");
                    panelAfiliadosVer.activarBtnEditar();
                    
                    List<Usuario> datosClientes = modelo.getInformacion().getListadoUsuario();
                    Usuario afiliadoSeleccionado =  datosClientes.get(valorSeleccionado);
                    modelo.getInformacion().setUsuarioActualInfo(afiliadoSeleccionado);
                    
                    enviarInformacion(afiliadoSeleccionado, panelAfiliadosVer);
                    
                    ControllerUsuariosCRUD afiliados = new ControllerUsuariosCRUD(modelo, panelAfiliadosVer, vistaDashboard);
                    
                }else if(me.getSource() == vistaClientes.getBtnEditar()){
                    
                    PanelUsuariosCRUD panelAfiliadosEditar = new PanelUsuariosCRUD();
                    vistaDashboard.realizarCambioPanelDashboard(panelAfiliadosEditar);
                    panelAfiliadosEditar.ponerFondoCRUD("Editar");
                    panelAfiliadosEditar.activarBotones();
                    panelAfiliadosEditar.activarComponentes();
                    
                    List<Usuario> datosAfiliados = modelo.getInformacion().getListadoUsuario();
                    Usuario afiliadoSeleccionado =  datosAfiliados.get(valorSeleccionado);
                    modelo.getInformacion().setUsuarioActualInfo(afiliadoSeleccionado);
                    
                    enviarInformacion(afiliadoSeleccionado, panelAfiliadosEditar);
                    
                    ControllerUsuariosCRUD afiliados = new ControllerUsuariosCRUD(modelo, panelAfiliadosEditar, vistaDashboard);
                    
                }else if(me.getSource() == vistaClientes.getBtnEliminar()){
                    
                    if (JOptionPane.showConfirmDialog(null, "¿Seguro que quieres eliminar este usuario?", "Mensaje", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        List<Usuario> datosAfiliados = modelo.getInformacion().getListadoUsuario();
                        Usuario afiliadoSeleccionado =  datosAfiliados.get(valorSeleccionado);
                        modelo.getInformacion().eliminarUsuario(afiliadoSeleccionado);
                        
                        PanelClientes panelClientes = new PanelClientes();
                        vistaDashboard.realizarCambioPanelDashboard(panelClientes);
                        ControllerUsuarios clientes = new ControllerUsuarios(modelo, panelClientes,vistaDashboard);
                    }
                }
            }
            if(me.getSource() == vistaClientes.getBtnCrear()){
                    
                PanelUsuariosCRUD panelAfiliadosCrear = new PanelUsuariosCRUD();
                vistaDashboard.realizarCambioPanelDashboard(panelAfiliadosCrear);
                panelAfiliadosCrear.ponerFondoCRUD("Crear");
                panelAfiliadosCrear.activarBotones();
                panelAfiliadosCrear.activarComponentes();
                panelAfiliadosCrear.limpiarCampos();
                    
                ControllerUsuariosCRUD afiliados = new ControllerUsuariosCRUD(modelo, panelAfiliadosCrear, vistaDashboard);
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
