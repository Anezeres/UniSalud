/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.ModeloPrincipal;
import Modelo.Producto;
import Modelo.Proveedor;
import Modelo.Registro;
import Vistas.PanelVender;
import Vistas.PanelVenderAceptar;
import Vistas.VistaDashboard;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author RYZEN
 */
public class ControllerVender {
    
    private ModeloPrincipal modelo;
    private PanelVender vistaVender;
    private VistaDashboard vistaDashboard;
    
    

    public ControllerVender(ModeloPrincipal modelo, PanelVender vistaVender, VistaDashboard vistaDashboard) {
        this.modelo = modelo;
        this.vistaVender = vistaVender;
        this.vistaDashboard = vistaDashboard;
        
        llenarListaProductos();
        
        agregarListenersVender();
    }
    
    private void agregarListenersVender(){
        
        VenderListener listener = new VenderListener();
        
        vistaVender.addListaProductosListener(new JListProductosListener());
        vistaVender.addListaComprasListener(new JListComprasListener());
        vistaVender.addBtnAgregarListener(listener);
        vistaVender.addBtnEliminarListener(listener);
        vistaVender.addBtnVenderListener(listener);
        
        
    }
    
    
    private void llenarListaProductos(){
        List<Producto> productos = modelo.getInformacion().getListadoProducto();
        String[] dato = new String[3];
        
        for (Producto producto : productos) {
            dato[0] = producto.getNombre();
            dato[1] = producto.getPrecioProducto() + "$";
            dato[2] = producto.getUnidades() + " u";
            
            vistaVender.llenarListaProductos(dato);
        }

    }
    
    private void agregarCompra(int index, int cantidad){
        List<Producto> productos = modelo.getInformacion().getListadoProducto();
        String[] dato = new String[3];
        
        if(cantidad > 0){
            for(int i = 0; i<productos.size();i++){
                if(i == index){
                    dato[0] = productos.get(i).getNombre();
                    dato[1] = productos.get(i).getPrecioProducto() + "";
                    
                    if(cantidad < productos.get(i).getUnidades()){
                        dato[2] = cantidad + "";
                    }else{
                        if (JOptionPane.showConfirmDialog(null, "No tenemos suficientes productos, ingrese otro valor", "Mensaje", JOptionPane.CLOSED_OPTION) == JOptionPane.YES_OPTION) {
                            
                        }
                        //dato[2] = cantidad + "";
                    }
                    

                    vistaVender.llenarListaCompras(dato);
                    Registro nuevoRegistro = modelo.getInformacion().crearRegistro(dato);
                    modelo.getInformacion().agregarDatoRegistroActual(nuevoRegistro);
                }
            }
            
        }else{
            if (JOptionPane.showConfirmDialog(null, "Ingrese una cantidad positiva", "Mensaje", JOptionPane.CLOSED_OPTION) == JOptionPane.YES_OPTION) {
                        
            } 
        }
        
        
    }
    
    
    
    class JListProductosListener implements ListSelectionListener
    {

        @Override
        public void valueChanged(ListSelectionEvent e) 
        {
            
            if (vistaVender.getCompraSeleccionada() != null)
            {
               vistaVender.cambiarEstadoBotonAgregar(true); 
                System.out.println("Afuera");
            }
            else
            {
                vistaVender.cambiarEstadoBotonAgregar(false); 
                System.out.println("Adentro");
                vistaVender.activarTxtCantidad();
                
            }
            System.out.println("Index Seleccionado: " + vistaVender.getIndexProducto(vistaVender.getProductoSeleccionado()));
            System.out.println("Seleccionó: "+vistaVender.getProductoSeleccionado());
        }
    }
    /*
    public void vaciarListaCompra()
    {
        vistaVender.vaciarListaCompras();
    }
*/
    
    class JListComprasListener implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent e) 
        {
            
            if (vistaVender.getCompraSeleccionada() != null)
            {
               //vistaVender.cambiarEstadoBotones(true); 
                int indexSelecionado = vistaVender.getIndexCompra(vistaVender.getCompraSeleccionada());
                System.out.println("Index: " + indexSelecionado);
                vistaVender.cambiarEstadoBotonesInferiores();
                vistaVender.setSelecionoProductoCompra(true);
            }
            else
            {
                
            }
            
            //System.out.println("Cambio");


        }
    }
    
    class VenderListener implements MouseListener{
        
        @Override
        public void mouseClicked(MouseEvent me) {
            if(me.getSource() == vistaVender.getBtnAgregar()){
                if(!"".equals(vistaVender.getTxtCantidad())){
                    System.out.println("Producto Agregado");
                    int indexSelecionado = vistaVender.getIndexProducto(vistaVender.getProductoSeleccionado());
                    
                    try {
                        int cantidad = Integer.parseInt(vistaVender.getTxtCantidad());
                        agregarCompra(indexSelecionado, cantidad);
                        vistaVender.cambiarEstadoBotonesInferiores();
                        vistaVender.setTxtCantidad("");
                    } catch (Exception e) {
                        if (JOptionPane.showConfirmDialog(null, "Ingrese una cantidad valida", "Mensaje", JOptionPane.CLOSED_OPTION) == JOptionPane.YES_OPTION) {
                            System.out.println(e);
                        }   

                    }
                    
                    
                }
            }else if(me.getSource() == vistaVender.getBtnEliminar()){
                if(vistaVender.isBtnEliminarActivo() && vistaVender.isSelecionoProductoCompra()){
                    int indexSelecionado = vistaVender.getIndexCompra(vistaVender.getCompraSeleccionada());
                    if (JOptionPane.showConfirmDialog(null, "¿Seguro que quiere eliminar esta compra?", "Mensaje", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                            vistaVender.eliminarElementoLista(indexSelecionado);
                            
                            if(vistaVender.getPreciosAgregados().size() == 0 ){
                                vistaVender.DesactivarBotonesInferiores();
                            }
                    }
                }
            }else if(me.getSource() == vistaVender.getBtnVender()){
                if(vistaVender.isBtnVenderActivo()){
                    if (JOptionPane.showConfirmDialog(null, "¿Seguro que quiere ya terminó de comprar productos?", "Mensaje", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        
                        PanelVenderAceptar aceptar = new PanelVenderAceptar();
                        vistaDashboard.realizarCambioPanelDashboard(aceptar);
                        ControllerVenderAceptar aceptarController = new ControllerVenderAceptar(modelo, aceptar, vistaDashboard);
                        
                    }
                }
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
