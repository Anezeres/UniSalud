/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RYZEN
 */
public class ProductoDaoImplementation implements IProductoDao{

    List<Producto> productos;
    
    public ProductoDaoImplementation() {
        this.productos = new ArrayList<>();
    }
    
 
    @Override
    public List<Producto> getAllProductos() {
        return productos;
    }

    @Override
    public Producto getProducto(int productoId) {
        Producto producto = null;
        
        for(Producto productoActual : productos){
            if(productoActual.getIdProducto() == productoId){
                producto = productoActual;
                break;
            }
        }
        return producto;
    }

    @Override
    public boolean addProducto(Producto producto) {
        productos.add(producto);
        return true;
    }

    @Override
    public boolean updateProducto(Producto producto, Producto nuevoProducto) {
        
        if(productos.contains(producto)){
            
            int pos = productos.indexOf(producto);
            productos.set(pos, nuevoProducto);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteProducto(Producto producto) {
        productos.remove(producto);
        return true;
    }
}
