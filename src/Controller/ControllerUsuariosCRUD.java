/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.ModeloPrincipal;
import Vistas.PanelAfiliados;
import Vistas.PanelUsuariosCRUD;
import Vistas.VistaDashboard;

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
        
        //agregarListenersBtnDashBoard();
        
    }
    
}
