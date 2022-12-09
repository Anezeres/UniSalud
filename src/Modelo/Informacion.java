/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import DAO.CitaDaoImplementation;
import DAO.CuentaDaoImplementation;
import DAO.ICitaDao;
import DAO.ICuentaDao;
import DAO.IUsuarioDao;
import DAO.UsuarioDaoImplementation;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

/* Date date1=new SimpleDateFormat("dd-MM-yyyy").parse(contacto.getFechaNacimiento());   */

/**
 *
 * @author RYZEN
 */
public class Informacion {
    private ICitaDao citaDao;
    private ICuentaDao cuentaDao;
    private IUsuarioDao usuarioDao;

    public Informacion() {
        this.citaDao = new CitaDaoImplementation();
        this.cuentaDao = new CuentaDaoImplementation();
        this.usuarioDao = new UsuarioDaoImplementation();
    }
    
    /* Getters and Setters */
    
    /* Citas */
    
    public boolean agregarCita(Cita cita){
        return this.citaDao.addCita(cita);
    }
    
    public List<Cita> getListadoCitas(){
        return   this.citaDao.getAllCitas();
    }  
    
    public boolean eliminarCita(Cita cita){
        return this.citaDao.deleteCita(cita);
    }
    
    public boolean actualizarCita(Cita cita){
        return this.citaDao.updateCita(cita);
    }
    
    /* Usuarios */
    
    public boolean agregarUsuario(Usuario usuario){
        return this.usuarioDao.addUsuario(usuario);
    }
    
    public List<Usuario> getListadoUsuario(){
        return  this.usuarioDao.getAllUsuarios();
    }  
    
    public boolean eliminarUsuario(Usuario usuario){
        return this.usuarioDao.deleteUsuario(usuario);
    }
    
    public boolean actualizarUsuario(Usuario usuario){
        return this.usuarioDao.updateUsuario(usuario);
    }
    
    /* Cuentas */
    
    public boolean agregarCuenta(Cuenta cuenta){
        return this.cuentaDao.addCuenta(cuenta);
    }
    
    public List<Cuenta> getListadoCuentas(){
        return  this.cuentaDao.getAllCuentas();
    }  
    
    public boolean eliminarUsuario(Cuenta cuenta){
        return this.cuentaDao.deleteCuenta(cuenta);
    }
    
    public boolean actualizarUsuario(Cuenta cuenta){
        return this.cuentaDao.updateCuenta(cuenta);
    }
    
    public void cargarUsuarios(){
        cargarDatos("Usuarios");
    }
    
    public void crearUsuarios(String[] usuarios){
        int idUsuario = (int) Integer.parseInt(usuarios[0]);
        String cedula = usuarios[1];
        String nombre = usuarios[2];
        String telefono = usuarios[3];
        String email = usuarios[4];
        String direccion = usuarios[5];
        String sexo = usuarios[6];
        String rol = usuarios[7];
        
        Usuario nuevoUsuario = new Usuario(idUsuario ,cedula, nombre, telefono, email, direccion, sexo, rol);
        
        agregarUsuario(nuevoUsuario);
    }
     
    /* Cargar Datos */
    
    public void cargarDatos(String datosArchivo){
        File archivo = null;
        FileReader reader = null;
        BufferedReader buffered = null;
     
      try {
        archivo = new File ("src\\Archivos\\"+datosArchivo+".txt");
        reader = new FileReader (archivo);
        buffered = new BufferedReader(reader);
                 
        String linea="";
        
        while((linea=buffered.readLine())!= null){
            StringTokenizer tokens = new StringTokenizer(linea, ";");
            int nDatos=tokens.countTokens();
            
            String[] datos =new String[nDatos];
            
            int i=0;
            while(tokens.hasMoreTokens()){
                String str=tokens.nextToken();
                datos[i]= String.valueOf(str);
                i++;
            }

            
            if("Usuarios".equals(datosArchivo)){
                crearUsuarios(datos);
            }
            
            System.out.println(linea);
            
            System.out.println("EMPIEZA OTRO DATO");
      }
       
      }catch(IOException ioe){
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
    
    
    
    
}
