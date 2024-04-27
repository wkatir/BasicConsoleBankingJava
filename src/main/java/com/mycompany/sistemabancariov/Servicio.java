/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemabancariov;

/**
 *
 * @author Wilmer Salazar
 */
public class Servicio {
    private String nombre;
    private String descripcion;
    private double monto;

    public Servicio(String nombre, String descripcion, double monto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.monto = monto;
    }

      /**
     * Obtiene el nombre del servicio.
     *
     * @return el nombre del servicio
     */
    
    public String getNombre() {
        return nombre;
    }

    
    /**
     * Obtiene la descripción del servicio.
     *
     * @return la descripción del servicio
     */
    
    public String getDescripcion() {
        return descripcion;
    }

       /**
     * Obtiene el monto del servicio.
     *
     * @return el monto del servicio
     */
    
    public double getMonto() {
        return monto;
    }
    
    
    
    
}
