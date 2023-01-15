package MaketPlacePrincipal;

import Controller.ControllerPrincipal;
import Modelo.ModeloPrincipal;
import Modelo.Producto;
import Modelo.Proveedor;
import Modelo.Usuario;
import Vistas.VistaLogin;
import java.util.List;

/**
 *
 * @author RYZEN
 */
public class MarketPlace {

    public static void main(String[] args) {
        
        ModeloPrincipal modelo = new ModeloPrincipal();
        VistaLogin vista = new VistaLogin();
        
        
        ControllerPrincipal controller = new ControllerPrincipal(modelo, vista);
        
        modelo.getInformacion().cargarUsuarios();
        modelo.getInformacion().cargarProductos();
        modelo.getInformacion().cargarProveedores();
        
        List<Usuario> usuarios = modelo.getInformacion().getListadoUsuario();
        List<Proveedor> proveedores = modelo.getInformacion().getListadoProveedor();
        List<Producto> productos = modelo.getInformacion().getListadoProducto();
        
        System.out.println("Usuarios...");
        for (Usuario usuario : usuarios) {
            System.out.println(usuario.toString());
        }
        System.out.println("Proveedores...");
        for (Proveedor proveedor : proveedores) {
            System.out.println(proveedor.toString());
        }
        System.out.println("Productos...");
        for (Producto producto : productos) {
            System.out.println(producto.toString());
        }
        
    }
    
}
