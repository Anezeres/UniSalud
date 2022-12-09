package UniSaludPrincipal;

import Modelo.Cita;
import Modelo.ModeloPrincipal;
import Modelo.Usuario;
import java.util.List;

/**
 *
 * @author RYZEN
 */
public class UniSalud {

    public static void main(String[] args) {
        
        ModeloPrincipal modelo = new ModeloPrincipal();
        
        modelo.getInformacion().cargarUsuarios();
        modelo.getInformacion().cargarCitas();
        
        List<Usuario> usuarios = modelo.getInformacion().getListadoUsuario();
        List<Cita> citas = modelo.getInformacion().getListadoCitas();
        
        
        for (Usuario usuario : usuarios) {
            System.out.println(usuario.toString());
        }
        
        for (Cita cita : citas) {
            System.out.println(cita.toString());
        }
        
    }
    
}
