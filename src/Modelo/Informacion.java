/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import DAO.IProductoDao;
import DAO.IProveedorDao;
import DAO.IUsuarioDao;
import DAO.ProductoDaoImplementation;
import DAO.ProveedorDaoImplementation;
import DAO.UsuarioDaoImplementation;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/* Date date1=new SimpleDateFormat("dd-MM-yyyy").parse(contacto.getFechaNacimiento());   */

/**
 *
 * @author RYZEN
 */
public class Informacion {
    private IUsuarioDao usuarioDao;
    private IProductoDao productoDao;
    private IProveedorDao proveedorDao;
    private Usuario usuarioActualInfo;
    private Proveedor proveedorActualInfo;
    private Producto productoActualInfo;

    public Informacion() {
        this.usuarioDao = new UsuarioDaoImplementation();
        this.productoDao = new ProductoDaoImplementation();
        this.proveedorDao = new ProveedorDaoImplementation();
    }
    
    /* Getters and Setters */
    
    
    /* Usuarios */
    
    public Usuario getUsuario(int idUsuario){
        return this.usuarioDao.getUsuario(idUsuario);
    }
    
    public boolean agregarUsuario(Usuario usuario){
        return this.usuarioDao.addUsuario(usuario);
    }
    
    public List<Usuario> getListadoUsuario(){
        return  this.usuarioDao.getAllUsuarios();
    }  
    
    public boolean eliminarUsuario(Usuario usuario){
        return this.usuarioDao.deleteUsuario(usuario);
    }
    
    public boolean actualizarUsuario(Usuario usuario, Usuario nuevoUsuario){
        return this.usuarioDao.updateUsuario(usuario,  nuevoUsuario);
    }
    
    public void crearUsuarios(String[] usuarios){
        int idUsuario = (int) Integer.parseInt(usuarios[0]);
        String cedula = usuarios[1];
        String nombre = usuarios[2];
        String telefono = usuarios[3];
        String email = usuarios[4];
        String direccion = usuarios[5];
        String sexo = usuarios[6];
        
        Usuario nuevoUsuario = new Usuario(idUsuario ,cedula, nombre, telefono, email, direccion, sexo);
        
        agregarUsuario(nuevoUsuario);
    }
    
    public void crearUsuario(String[] usuario){
        String nombre = usuario[0];
        String cedula = usuario[1];
        String telefono = usuario[2]; 
        String email = usuario[3];
        String direccion = usuario[4];
        String sexo = usuario[5];
        
        Usuario nuevoUsuario = new Usuario(cedula, nombre, telefono, email, direccion, sexo);
        
        agregarUsuario(nuevoUsuario);
    }
    
    public void cambiarInfoUsuario(String[] datos, int idUsuario, String rol){
        String nombre = datos[0];
        String cedula = datos[1];
        String telefono = datos[2];
        String email = datos[3];
        String direccion = datos[4];
        String sexo = datos[5];
        
        Usuario nuevoUsuario = new Usuario(idUsuario ,cedula, nombre, telefono, email, direccion, sexo);
        
        actualizarUsuario(usuarioActualInfo, nuevoUsuario);
    }
    
    /* Proveedores */
    
    public Proveedor getProveedor(int idProveedor){
        return this.proveedorDao.getProveedor(idProveedor);
    }
    
    public boolean agregarProveedor(Proveedor proveedor){
        return this.proveedorDao.addProveedor(proveedor);
    }
    
    public List<Proveedor> getListadoProveedor(){
        return  this.proveedorDao.getAllProveedores();
    }  
    
    public boolean eliminarProveedor(Proveedor proveedor){
        return this.proveedorDao.deleteProveedor(proveedor);
    }
    
    public boolean actualizarProveedor(Proveedor proveedor, Proveedor nuevoProveedor){
        return this.proveedorDao.updateProveedor(proveedor, nuevoProveedor);
    }
    
    public void crearProveedores(String[] proveedores){
        int idProveedor = (int) Integer.parseInt(proveedores[0]);
        String nombre = proveedores[1];
        String telefono = proveedores[2];
        String direccion = proveedores[3];
        String stok = proveedores[4];
   
        
        Proveedor nuevoProveedor = new Proveedor(idProveedor, nombre, telefono, direccion, stok);
        
        agregarProveedor(nuevoProveedor);
    }
    
    public void cambiarInfoProveedor(String[] datos, int idProveedor){
        String nombre = datos[0];
        String telefono = datos[1];
        String direccion = datos[2];
        String stok = datos[3];
        
        Proveedor nuevoProveedor = new Proveedor(idProveedor, nombre, telefono, direccion, stok);
        actualizarProveedor(proveedorActualInfo, nuevoProveedor);
    }
    
    
    /* Productos */
    
    public Proveedor getProducto(int idProveedor){
        return this.proveedorDao.getProveedor(idProveedor);
    }
    
    public boolean agregarProducto(Producto producto){
        return this.productoDao.addProducto(producto);
    }
    
    public List<Producto> getListadoProducto(){
        return  this.productoDao.getAllProductos();
    }  
    
    public boolean eliminarProducto(Producto producto){
        return this.productoDao.deleteProducto(producto);
    }
    
    public boolean actualizarProducto(Producto producto, Producto nuevoProducto){
        return this.productoDao.updateProducto(producto, nuevoProducto);
    }
    
    public void crearProductos(String[] productos){
        int idProducto = (int) Integer.parseInt(productos[0]);
        String nombre = productos[1];
        float precio = (float) Float.parseFloat(productos[2]);
        int unidades = (int) Integer.parseInt(productos[3]);
        int idProveedor = (int) Integer.parseInt(productos[4]);
        
        Producto nuevoProducto = new Producto(idProducto, nombre, precio, unidades, idProveedor);
        
        agregarProducto(nuevoProducto);
    }
    
    public void cambiarInfoProducto(String[] datos, int idProducto){
        String nombre = datos[0];
        float precio = (float) Float.parseFloat(datos[1]);
        int unidades = (int) Integer.parseInt(datos[2]);
        int idProveedor = (int) Integer.parseInt(datos[3]);
        
        Producto nuevoProducto = new Producto(idProducto, nombre, precio, unidades, idProveedor);
        actualizarProducto(productoActualInfo, nuevoProducto);
    }
    
    /* Cargado de Datos */
    
    public void cargarUsuarios(){
        cargarDatos("Usuarios");
    }
    
    public void cargarProveedores(){
        cargarDatos("Proveedores");
    }
    
    public void cargarProductos(){
        cargarDatos("Productos");
    }
    
    /* Cargar Datos */
    
    public void cargarDatos(String datosArchivo){
        File archivo = null;
        FileReader reader = null;
        BufferedReader buffered = null;
     
        try {
          archivo = new File ("src//Archivos//"+datosArchivo+".txt");
          reader = new FileReader (archivo);
          buffered = new BufferedReader(reader);
          String linea="";

          while((linea=buffered.readLine())!= null){
              StringTokenizer tokens = new StringTokenizer(linea, ";");
              int nDatos=tokens.countTokens();

              String[] datos = new String[nDatos];

              int i=0;
              while(tokens.hasMoreTokens()){
                  String str = tokens.nextToken();
                  datos[i]= String.valueOf(str);
                  i++;
              }


              if("Usuarios".equals(datosArchivo)){
                  crearUsuarios(datos);
              }else if("Productos".equals(datosArchivo)){
                  crearProductos(datos);
              }else if("Proveedores".equals(datosArchivo)){
                  crearProveedores(datos);
              }

              System.out.println(linea);

              System.out.println("EMPIEZA OTRO DATO");
        }

        }catch(IOException ioe){
            System.out.println(ioe);
        }finally{
           try{                   
              if( null != reader ){  
                 reader.close();    
              }                 
           }catch (IOException e2){
               System.out.println(e2);
           }
        }
    }

    public Usuario getUsuarioActualInfo() {
        return usuarioActualInfo;
    }

    public void setUsuarioActualInfo(Usuario usuarioActualInfo) {
        this.usuarioActualInfo = usuarioActualInfo;
    }

    public Proveedor getProveedorActualInfo() {
        return proveedorActualInfo;
    }

    public void setProveedorActualInfo(Proveedor proveedorActualInfo) {
        this.proveedorActualInfo = proveedorActualInfo;
    }

    public Producto getProductoActualInfo() {
        return productoActualInfo;
    }

    public void setProductoActualInfo(Producto productoActualInfo) {
        this.productoActualInfo = productoActualInfo;
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
