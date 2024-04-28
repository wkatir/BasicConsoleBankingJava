/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemabancariov;

import java.util.ArrayList;

/**
 *
 * @author Wilmer Salazar
 */

/**
 * Clase que representa un banco.
 */

public class Banco {
    private ArrayList<Cliente> clientes;
    private ArrayList<Cuenta> cuentas;

      /**
     * Crea una nueva instancia de Banco.
     */
    
    public Banco() {
    clientes = new ArrayList<>();
    cuentas = new ArrayList<>();
    }
    
    
    /**
     * Agrega un nuevo cliente al banco.
     *
     * @param cliente el cliente a agregar
     */
    
    public void agregarCliente(Cliente cliente){
        clientes.add(cliente);
    }
    
      /**
     * Agrega una nueva cuenta al banco.
     *
     * @param cuenta la cuenta a agregar
     */
    
    public void agregarCuenta(Cuenta cuenta){
        cuentas.add(cuenta);
    }
    
        /**
     * Busca una cuenta por su número de cuenta.
     *
     * @param numeroCuenta el número de cuenta a buscar
     * @return la cuenta encontrada, o null si no se encuentra
     */
    
      private Cuenta buscarCuenta(int numeroCuenta) {
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getNumeroCuenta() == numeroCuenta) {
                return cuenta;
            }
        }
        return null;
    }

      
         /**
     * Transfiere una cantidad de dinero de una cuenta de origen a una cuenta de destino.
     *
     * @param cuentaOrigenNum  el número de cuenta de origen
     * @param cuentaDestinoNum el número de cuenta de destino
     * @param cantidad         la cantidad a transferir
     * @return true si la transferencia fue exitosa, false en caso contrario
     */
      
       public boolean transferir(int cuentaOrigenNum, int cuentaDestinoNum, double cantidad) {
        Cuenta cuentaOrigen = buscarCuenta(cuentaOrigenNum);
        Cuenta cuentaDestino = buscarCuenta(cuentaDestinoNum);

        if (cuentaOrigen != null && cuentaDestino != null) {
            return Transaccion.transferir(cuentaOrigen, cuentaDestino, cantidad);
        } else {
            return false;
        }
       }
    
          /**
     * Actualiza el saldo de una cuenta específica.
     *
     * @param numeroCuenta el número de cuenta a actualizar
     * @param nuevoSaldo   el nuevo saldo de la cuenta
     * @return true si la actualización fue exitosa, false en caso contrario
     */
       
       public boolean actualizarCuenta(int numeroCuenta, double nuevoSaldo){
           Cuenta cuenta = buscarCuenta(numeroCuenta);
           if(cuenta != null){
               cuenta.setSaldo(nuevoSaldo);
               return true;
           }
           return false;
           
       }
       
          /**
     * Realiza el pago de un servicio desde una cuenta específica.
     *
     * @param numeroCuenta el número de cuenta desde la cual se realizará el pago
     * @param servicio     el servicio a pagar
     * @return true si el pago fue exitoso, false en caso contrario
     */
       
      public boolean pagarServicio(int numeroCuenta, Servicio servicio) {
        Cuenta cuenta = buscarCuenta(numeroCuenta);
        if (cuenta != null) {
            try {
                if (cuenta.retirar(servicio.getMonto())) {
                    System.out.println("Pago de " + servicio.getTipoServicio().name() + " realizado correctamente.");
                    return true;
                }
            } catch (Exception e) {
                System.out.println("Dato incorrecto ingresado.");
            }
        }
        System.out.println("No se pudo realizar el pago del servicio.");
        return false;
    }
    
       /**
     * Obtiene una lista de todos los clientes del banco.
     *
     * @return una lista de clientes
     */
      
      public ArrayList<Cliente> obtenerClientes() {
       return clientes;
             
}
      
      /**
    * Obtiene una lista de todas las cuentas del banco.
    *
    * @return una lista de cuentas
    */
      
       public ArrayList<Cuenta> obtenerCuentas(){
           return cuentas;
       }    
       
       /**
    * Obtiene una cuenta específica por su número de cuenta.
    *
    * @param numeroCuenta el número de cuenta a buscar
    * @return la cuenta encontrada, o null si no se encuentra
    */
       
       public Cuenta obtenerCuenta(int numeroCuenta) {
        return buscarCuenta(numeroCuenta);
    }
       
       /**
    * Elimina una cuenta específica del banco.
    *
    * @param numeroCuenta el número de cuenta a eliminar
    * @return true si la eliminación fue exitosa, false en caso contrario
    */
       
      public boolean eliminarCuenta(int numeroCuenta){
          Cuenta cuenta = buscarCuenta(numeroCuenta);
          if(cuenta != null){
              cuentas.remove(cuenta);
              return true;
          }
          return false;
      } 
}
