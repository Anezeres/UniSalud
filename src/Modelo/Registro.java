/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author RYZEN
 */
public class Registro {
    private static int numero;
    private int idRegistro;
    private String nombreProducto;
    private float precioVenta;
    private int unidades;
    private float total;

    public Registro(int idRegistro, String nombreProducto, float precioVenta, int unidades, float total) {
        this.idRegistro = idRegistro;
        this.nombreProducto = nombreProducto;
        this.precioVenta = precioVenta;
        this.unidades = unidades;
        this.total = total;
        numero++;
    }

    public Registro(String nombreProducto, float precioVenta, int unidades, float total) {
        this.nombreProducto = nombreProducto;
        this.precioVenta = precioVenta;
        this.unidades = unidades;
        this.total = total;
        this.idRegistro = numero++;
    }
    
    /* Getters and Setters */

    public static int getNumero() {
        return numero;
    }

    public static void setNumero(int numero) {
        Registro.numero = numero;
    }

    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
    
    
    
    
    
    
}
