/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author RYZEN
 */
public class Proveedor {
    private static int numero;
    private final int idProveedor;
    private String nombreProveedor;
    private String telefono;
    private String direccion;
    private String stok;

    public Proveedor(int idProveedor, String nombreProveedor, String telefono, String direccion, String stok) {
        this.idProveedor = idProveedor;
        this.nombreProveedor = nombreProveedor;
        this.telefono = telefono;
        this.direccion = direccion;
        this.stok = stok;
        numero++;
    }

    public Proveedor(String nombreProveedor, String telefono, String direccion, String stok) {
        this.nombreProveedor = nombreProveedor;
        this.telefono = telefono;
        this.direccion = direccion;
        this.stok = stok;
        this.idProveedor = numero++;
    }
    
    
    
    /* Getters and Setters */

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public static int getNumero() {
        return numero;
    }

    public static void setNumero(int numero) {
        Proveedor.numero = numero;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getStok() {
        return stok;
    }

    public void setStok(String stok) {
        this.stok = stok;
    }
    
    

    @Override
    public String toString() {
        return "Proveedor{" + "idProveedor=" + idProveedor + ", nombreProveedor=" + nombreProveedor + ", telefono=" + telefono + ", direccion=" + direccion + ", stok=" + stok + '}';
    }

    
    
    
    
    
    
}
