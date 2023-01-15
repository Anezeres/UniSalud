/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author RYZEN
 */
public class Producto {
    
    private final int idProducto;
    private String nombre;
    private float precioProducto;
    private int unidades;
    private final int idProveedor;

    public Producto(int idProducto, String nombre, float precioProducto, int unidades, int idProveedor) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precioProducto = precioProducto;
        this.unidades = unidades;
        this.idProveedor = idProveedor;
    }
    
    
    /* Getters and Setters */

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(float precioProducto) {
        this.precioProducto = precioProducto;
    }

    public float getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", nombre=" + nombre + ", precioProducto=" + precioProducto + ", unidades=" + unidades + ", idProveedor=" + idProveedor + '}';
    }
    
    
    
    
    
    
    
    
}
