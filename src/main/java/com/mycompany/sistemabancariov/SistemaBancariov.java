/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistemabancariov;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Wilmer Salazar
 */
public class SistemaBancariov {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco banco = new Banco();
        int opcion;
        do{
            mostrarMenu();
            opcion = obtenerOpcionValida(scanner);
            
            switch (opcion) {
                case 1:
                    agregarCliente(banco, scanner);
                    break;
                case 2:
                    agregarCuenta(banco, scanner);
                    break;
                case 3:
                    realizarTransferencia(banco, scanner);
                    break;
                case 4:
                    actualizarCuenta(banco, scanner);
                    break;
                case 5:
                    pagarServicio(banco, scanner);
                    break;
                case 6:
                    consultarDatos(banco);
                    break;
                case 7:
                    eliminarCuenta(banco, scanner);
                    break;
                case 8:
                    System.out.println("Saliendo del programa ...");
                    break;
    
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
            
        }while(opcion != 8);
        
        scanner.close();
    }
    
       /**
    * Muestra el menú del sistema bancario.
    */
    
       private static void mostrarMenu() {
       System.out.println("\nMenú del Sistema Bancario");
       System.out.println("1. Agregar cliente");
       System.out.println("2. Agregar cuenta");
       System.out.println("3. Realizar transferencia");
       System.out.println("4. Actualizar cuenta");
       System.out.println("5. Pagar servicio");
       System.out.println("6. Consultar datos");
       System.out.println("7. Eliminar cuenta");
       System.out.println("8. Salir");
       System.out.print("Ingrese una opción: ");
   }
 
         /**
    * Obtiene una opción válida del usuario.
    *
    * @param scanner el objeto Scanner para leer la entrada del usuario
    * @return la opción válida ingresada por el usuario
    */
       
       private static int obtenerOpcionValida(Scanner scanner) {
       int opcion;
       boolean opcionValida = false;

       do {
           try {
               opcion = scanner.nextInt();
               scanner.nextLine(); 
               opcionValida = opcion >= 1 && opcion <= 8;
           } catch (InputMismatchException e) {
               System.out.println("Debe ingresar un número válido.");
               scanner.nextLine();
               opcion = 0;
               opcionValida = false;
           }
       } while (!opcionValida);

       return opcion;
   }
       
         /**
    * Obtiene un número válido y positivo del usuario.
    *
    * @param scanner el objeto Scanner para leer la entrada del usuario
    * @return el número válido y positivo ingresado por el usuario
    */
       
      private static double obtenerNumeroValidoPositivo(Scanner scanner){
          double numero;
          boolean numeroValido = false;
          
          do{
              
              try{
                  numero = scanner.nextDouble();
                  scanner.nextLine();
                  numeroValido = numero >= 0;
              }catch(InputMismatchException e){
                  System.out.println("Debe ingresar un número válido.");
                  scanner.nextLine();
                  numero = -1;
                  numeroValido = false;
              }
              
              
          }while(!numeroValido);
          return numero;
      }
       
       
       
         /**
    * Agrega un nuevo cliente al banco.
    *
    * @param banco   el banco al que se agregará el cliente
    * @param scanner el objeto Scanner para leer la entrada del usuario
    */
       
       private static void agregarCliente(Banco banco, Scanner scanner){
           System.out.println("Ingrese el nombre del cliente");
           String nombre = scanner.nextLine();
           int numeroCuenta;
           do{
               System.out.println("Ingrese el número de cuenta (debe ser un valor positivo): ");
               numeroCuenta = (int) obtenerNumeroValidoPositivo(scanner);
           }while(numeroCuenta < 0);
           Cliente cliente = new Cliente(nombre, numeroCuenta);
           banco.agregarCliente(cliente);
           System.out.println("Cliente agregado correctamente.");
       }


          /**
    * Agrega una nueva cuenta al banco.
    *
    * @param banco   el banco al que se agregará la cuenta
    * @param scanner el objeto Scanner para leer la entrada del usuario
    */
       
       private static void agregarCuenta(Banco banco, Scanner scanner){
           int numeroCuenta;
           do{
               System.out.println("Ingrese el número de cuenta (debe ser un valor positivo): ");
               numeroCuenta = (int) obtenerNumeroValidoPositivo(scanner);
           }while(numeroCuenta < 0);
           double saldoInicial;
           do{
               System.out.println("Ingrese el saldo inicial (debe ser un valor positivo): ");
               saldoInicial = obtenerNumeroValidoPositivo(scanner);
           }while(saldoInicial < 0);
           Cuenta cuenta = new Cuenta(numeroCuenta, saldoInicial);
           banco.agregarCuenta(cuenta);
           System.out.println("Cuenta agregada correctamente.");
       }
       
         /**
    * Realiza una transferencia entre cuentas.
    *
    * @param banco   el banco en el cual se realizará la transferencia
    * @param scanner el objeto Scanner para leer la entrada del usuario
    */
       private static void realizarTransferencia(Banco banco, Scanner scanner){
           int cuentaOrigenNumero;
           do{
               System.out.println("Ingrese el número de cuenta de origen (debe ser un valor positivo): ");
               cuentaOrigenNumero  = (int) obtenerNumeroValidoPositivo(scanner);
           }while(cuentaOrigenNumero < 0);
           int cuentaDestinoNumero;
           do{
               System.out.println("Ingrese el número de cuenta de destino (debe ser un valor positivo): ");
               cuentaDestinoNumero = (int) obtenerNumeroValidoPositivo(scanner);
           }while(cuentaDestinoNumero < 0);
           double cantidad;
           do{
               System.out.println("Ingrese la cantidad a transferir (debe ser un valor positivo): ");
               cantidad = obtenerNumeroValidoPositivo(scanner);
           }while(cantidad < 0);
           
           try{
               boolean transferencia = banco.transferir(cuentaOrigenNumero, cuentaDestinoNumero, cantidad);
               if(transferencia){
                   System.out.println("Transferencia exitosa.");
               }
           }catch(Exception e){
               System.out.println("Error en la transferencia.");
           }
           
       }
       
        /**
    * Actualiza el saldo de una cuenta específica.
    *
    * @param banco   el banco en el cual se actualizará la cuenta
    * @param scanner el objeto Scanner para leer la entrada del usuario
    */
       
       private static void actualizarCuenta(Banco banco, Scanner scanner){
           int numeroCuenta;
           do{
               System.out.println("Ingrese el número de cuenta a actualizar (debe ser un valor positivo): ");
               numeroCuenta = (int) obtenerNumeroValidoPositivo(scanner);
           }while(numeroCuenta < 0);
           double nuevoSaldo;
           do{
               System.out.println("Ingrese el nuevo saldo (debe ser un valor positivo): ");
               nuevoSaldo = obtenerNumeroValidoPositivo(scanner);
           }while(nuevoSaldo < 0);
           if(banco.actualizarCuenta(numeroCuenta, nuevoSaldo)){
               System.out.println("Cuenta actualizada correctamente.");
           }else{
               System.out.println("No se encontro la cuenta especificada.");
           }
       }
       
       /**
    * Realiza el pago de un servicio desde una cuenta específica.
    *
    * @param banco   el banco desde el cual se realizará el pago
    * @param scanner el objeto Scanner para leer la entrada del usuario
    */
       
       private static void pagarServicio(Banco banco, Scanner scanner){
           int numeroCuenta;
           do{
               System.out.print("Ingrese el número de cuenta desde la cual realizar el pago (debe ser un valor positivo): ");
               numeroCuenta = (int) obtenerNumeroValidoPositivo(scanner);
           }while(numeroCuenta < 0);
           scanner.nextLine();
           
           System.out.println("Selecciona el tipo de servicio: ");
           for (TipoServicio tipoServicio : TipoServicio.values()) {
               System.out.println(tipoServicio.ordinal() + 1 + ". " + tipoServicio.name() + " - Monto: $" + tipoServicio.getMonto());
           }
           System.out.println("Ingrese el número correspondiente al servicio: ");
           int opcion = (int) obtenerNumeroValidoPositivo(scanner);
           if(opcion < 1 || opcion > TipoServicio.values().length){
               System.out.println("Opción no válida.");
               return;
           }
           TipoServicio tipoServicio = TipoServicio.values()[opcion - 1];
           System.out.println("Ingrese la descripción del servicio: ");
           String descripcionServicio = scanner.nextLine();
           
           Servicio servicio = new Servicio(tipoServicio, descripcionServicio);
           try{
               if(banco.pagarServicio(numeroCuenta, servicio)){
                   System.out.println("Pago realizado correctamente.");
               }
               
           }catch(Exception e){
               System.out.println("Error al realizar el pago.");
           }
           
       }
       
         /**
    * Consulta y muestra los datos de clientes y cuentas del banco.
    *
    * @param banco el banco del cual se consultarán los datos
    */
       
        private static void consultarDatos(Banco banco) {
       System.out.println("Clientes:");
       for (Cliente cliente : banco.obtenerClientes()) {
           System.out.println("Nombre: " + cliente.getNombre() + ", Número de cuenta: " + cliente.getNumeroCuenta());
       }
       System.out.println("\nCuentas:");
       for (Cuenta cuenta : banco.obtenerCuentas()) {
           System.out.println("Número de cuenta: " + cuenta.getNumeroCuenta() + ", Saldo: " + cuenta.getSaldo());
       }
   }
       
        /**
    * Elimina una cuenta específica del banco.
    *
    * @param banco   el banco del cual se eliminará la cuenta
    * @param scanner el objeto Scanner para leer la entrada del usuario
    */
   private static void eliminarCuenta(Banco banco, Scanner scanner) {
       int numeroCuenta;
       do {
           System.out.print("Ingrese el número de cuenta a eliminar (debe ser un valor positivo): ");
           numeroCuenta = (int) obtenerNumeroValidoPositivo(scanner);
       } while (numeroCuenta < 0);
       if (banco.eliminarCuenta(numeroCuenta)) {
           System.out.println("Cuenta eliminada correctamente.");
       } else {
           System.out.println("No se encontró la cuenta especificada.");
       }
   }








}

    
