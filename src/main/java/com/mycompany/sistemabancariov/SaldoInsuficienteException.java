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
 * Excepción que se lanza cuando el saldo es insuficiente para realizar un retiro.
 */

public class SaldoInsuficienteException extends Exception{

    public SaldoInsuficienteException(String mensaje) {
        super(mensaje);  
    }
    
}
