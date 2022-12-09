/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package UniSaludPrincipal;

import Modelo.ModeloPrincipal;
import Modelo.Usuario;
import java.util.List;

/**
 *
 * @author RYZEN
 */
public class UniSalud {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ModeloPrincipal modelo = new ModeloPrincipal();
        
        modelo.getInformacion().cargarUsuarios();
        
        List<Usuario> usuarios = modelo.getInformacion().getListadoUsuario();
        
        for (Usuario usuario : usuarios) {
            System.out.println(usuario.toString());
        }
        
    }
    
}
