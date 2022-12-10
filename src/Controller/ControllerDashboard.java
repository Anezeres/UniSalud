/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.ModeloPrincipal;
import Vistas.VistaDashboard;

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
        
        //agregarListenersBtnDashBoard();
        
    }
    
}
