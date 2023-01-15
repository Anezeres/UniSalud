/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Producto;
import Modelo.Proveedor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RYZEN
 */
public class ProveedorDaoImplementation implements IProveedorDao{

    List<Proveedor> proveedores;
    
    public ProveedorDaoImplementation() {
        this.proveedores = new ArrayList<>();
    }
    
 
    @Override
    public List<Proveedor> getAllProveedores() {
        return proveedores;
    }

    @Override
    public Proveedor getProveedor(int proveedorId) {
        Proveedor proveedor = null;
        
        for(Proveedor proveedorActual : proveedores){
            if(proveedorActual.getIdProveedor() == proveedorId){
                proveedor = proveedorActual;
                break;
            }
        }
        return proveedor;
    }

    @Override
    public boolean addProveedor(Proveedor proveedor) {
        proveedores.add(proveedor);
        return true;
    }

    @Override
    public boolean updateProveedor(Proveedor proveedor, Proveedor nuevoProveedor) {
        
        if(proveedores.contains(proveedor)){
            
            int pos = proveedores.indexOf(proveedor);
            proveedores.set(pos, nuevoProveedor);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteProveedor(Proveedor proveedor) {
        proveedores.remove(proveedor);
        return true;
    }
}
