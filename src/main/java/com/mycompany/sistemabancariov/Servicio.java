/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemabancariov;

/**
 *
 * @author Wilmer Salazar
 */

/**
 * Enumeración que representa los diferentes tipos de servicios disponibles.
 */

enum TipoServicio {
    AGUA(75.0),
    TELEFONO(25.0),
    LUZ(100.0),
    CUOTA_UNIVERSITARIA(150.0);

    private double monto;

    TipoServicio(double monto) {
        this.monto = monto;
    }

    public double getMonto() {
        return monto;
    }
}

/**
 * Clase que representa un servicio a pagar.
 */

public class Servicio {
    private TipoServicio tipoServicio;
    private String descripcion;

    public Servicio(TipoServicio tipoServicio, String descripcion) {
        this.tipoServicio = tipoServicio;
        this.descripcion = descripcion;
    }

    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    public double getMonto(){
        return tipoServicio.getMonto();
    }
    
    
    
    }
    
    
    
    

