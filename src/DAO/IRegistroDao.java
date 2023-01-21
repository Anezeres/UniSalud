/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;


import Modelo.Registro;
import Modelo.Usuario;
import java.util.List;

/**
 *
 * @author RYZEN
 */
public interface IRegistroDao{
    
    public List<Registro> getAllRegistros();
    public Registro getRegistro(int registroId);
    public boolean addRegistro(Registro registro);
    public boolean updateRegistro(Registro registro, Registro nuevoRegistro);
    public boolean deleteRegistro(Registro registro);
    
}
