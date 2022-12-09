/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author RYZEN
 */
public class Cita {
    private String fecha;
    private String hora;
    private String servicio;
    private String piso;
    private String sala;
    private final int idCita;

    public Cita(int idCita, String fecha, String hora, String servicio, String piso, String sala) {
        this.fecha = fecha;
        this.hora = hora;
        this.servicio = servicio;
        this.piso = piso;
        this.sala = sala;
        this.idCita = idCita;
    }
    
    /* Getters And Setters */

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public int getIdCita() {
        return idCita;
    }
    
    
    
    
    
}
