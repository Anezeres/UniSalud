/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.ModeloPrincipal;
import Modelo.Registro;
import Vistas.PanelRegistros;
import Vistas.VistaDashboard;
import java.util.List;

/**
 *
 * @author RYZEN
 */
public class ControllerRegistros {
    private ModeloPrincipal modelo;
    private PanelRegistros vistaRegistro;
    private VistaDashboard vistaDashboard;

    public ControllerRegistros(ModeloPrincipal modelo, PanelRegistros vistaRegistro, VistaDashboard vistaDashboard) {
        this.modelo = modelo;
        this.vistaRegistro = vistaRegistro;
        this.vistaDashboard = vistaDashboard;
        
        llenarTabla();
    }
    
    private void llenarTabla(){
        List<Registro> registros = modelo.getInformacion().getListadoRegistro();
        String[] dato = new String[4];
        
        for (Registro registro : registros) {
            dato[0] = registro.getNombreProducto();
            dato[1] = registro.getPrecioVenta() + "$";
            dato[2] = registro.getUnidades() + " u"; 
            dato[3] = registro.getTotal() + "$";
            
            vistaRegistro.agregarDatosTabla(dato);
        }
        
    }
    
    

    

    
    
}
