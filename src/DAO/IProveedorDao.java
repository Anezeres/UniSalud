/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;



import Modelo.Proveedor;
import java.util.List;

/**
 *
 * @author RYZEN
 */
public interface IProveedorDao{
    
    public List<Proveedor> getAllProveedores();
    public Proveedor getProveedor(int proveedorId);
    public boolean addProveedor(Proveedor proveedor);
    public boolean updateProveedor(Proveedor proveedor, Proveedor nuevoProveedor);
    public boolean deleteProveedor(Proveedor proveedor);
    
}
