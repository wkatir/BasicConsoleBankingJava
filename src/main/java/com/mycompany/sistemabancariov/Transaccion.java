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
 * Clase que representa una transacción bancaria.
 */

public class Transaccion {
    
        /**
     * Transfiere una cantidad de dinero de una cuenta de origen a una cuenta de destino.
     *
     * @param cuentaOrigen  la cuenta de origen
     * @param cuentaDestino la cuenta de destino
     * @param cantidad      la cantidad a transferir
     * @return true si la transferencia fue exitosa, false en caso contrario
     */
    
    public static boolean transferir(Cuenta origen, Cuenta destino, double cantidad){
        if(origen.retirar(cantidad)){
            destino.depositar(cantidad);
            return true;
        }else{
            return false;
        }
    }
}
