/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;


import Modelo.Producto;
import Modelo.Usuario;
import java.util.List;

/**
 *
 * @author RYZEN
 */
public interface IProductoDao{
    
    public List<Producto> getAllProductos();
    public Producto getProducto(int productoId);
    public boolean addProducto(Producto producto);
    public boolean updateProducto(Producto producto, Producto nuevoProducto);
    public boolean deleteProducto(Producto producto);
    
}
