/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Producto;
import Modelo.Registro;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RYZEN
 */
public class RegistroDaoImplementation implements IRegistroDao{

    List<Registro> registros;
    
    public RegistroDaoImplementation() {
        this.registros = new ArrayList<>();
    }

    @Override
    public List<Registro> getAllRegistros() {
        return registros;
    }

    @Override
    public Registro getRegistro(int registroId) {
        Registro registro = null;
        
        for(Registro registroActual : registros){
            if(registroActual.getIdRegistro() == registroId){
                registro = registroActual;
                break;
            }
        }
        return registro;
    }

    @Override
    public boolean addRegistro(Registro registro) {
        registros.add(registro);
        return true;
    }

    @Override
    public boolean updateRegistro(Registro registro, Registro nuevoRegistro) {
        
        if(registros.contains(registro)){
            
            int pos = registros.indexOf(registro);
            registros.set(pos, nuevoRegistro);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteRegistro(Registro registro) {
        registros.remove(registro);
        return true;
    }
}
