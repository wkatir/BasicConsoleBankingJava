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
    CUOTA_UNIVERSITARIA(150.0),
    PAGADO(0.0);

    private double monto;

     /**
     * Crea una nueva instancia de TipoServicio con el monto especificado.
     *
     * @param monto el monto del servicio
     */
    
    TipoServicio(double monto) {
        this.monto = monto;
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


/**
 * Clase que representa un servicio a pagar.
 */

public class Servicio {
    private TipoServicio tipoServicio;
    private String descripcion;
    private double monto;

    
      /**
     * Crea un nuevo servicio con el tipo de servicio y la descripción especificados.
     *
     * @param tipoServicio el tipo de servicio
     * @param descripcion  la descripción del servicio
     */
    
    public Servicio(TipoServicio tipoServicio, String descripcion) {
        this.tipoServicio = tipoServicio;
        this.descripcion = descripcion;
        this.monto = tipoServicio.getMonto();
    }

      /**
     * Obtiene el tipo de servicio.
     *
     * @return el tipo de servicio
     */
    
    public TipoServicio getTipoServicio() {
        return tipoServicio;
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
    
    public double getMonto(){
    if (tipoServicio == TipoServicio.PAGADO) {
        return 0.0;
    } else {
        return tipoServicio.getMonto();
    }
}
    
        /**
     * Marca el servicio como pagado, estableciendo su monto en cero.
     */
    
     public void pagarServicio() {
        tipoServicio = TipoServicio.PAGADO;
        // Establecer el monto en 0.0 cuando se marca como pagado
        this.monto = 0.0;
    }
    
      public void setTipoServicio(TipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }
     
    }