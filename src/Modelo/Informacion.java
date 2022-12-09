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
import java.util.List;

/**
 *
 * @author RYZEN
 */
public class Informacion {
    private ICitaDao citaDao;
    private ICuentaDao cuentaDao;
    private IUsuarioDao usuarioDao;

    public Informacion(ICitaDao citaDao, ICuentaDao cuentaDao, IUsuarioDao usuarioDao) {
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
    
}
