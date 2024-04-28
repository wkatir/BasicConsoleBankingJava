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
 * Clase que representa a un cliente del banco.
 */

public class Cliente {
    private String nombre;
    private int numeroCuenta;

     
    /**
     * Crea un nuevo cliente con el nombre y número de cuenta especificados.
     *
     * @param nombre       el nombre del cliente
     * @param numeroCuenta el número de cuenta del cliente
     */
    
    public Cliente(String nombre, int numeroCuenta) {
        this.nombre = nombre;
        this.numeroCuenta = numeroCuenta;
    }
    
     /**
     * Obtiene el nombre del cliente.
     *
     * @return el nombre del cliente
     */
    
      public String getNombre() {
        return nombre;
    }
    
      /**
     * Obtiene el número de cuenta del cliente.
     *
     * @return el número de cuenta del cliente
     */  
      
      /**
    * Obtiene el nombre del cliente asociado a este objeto.
    *
    * @return El nombre del cliente.
    */
      
     public int getNumeroCuenta() {
        return numeroCuenta;
    }
    
}
