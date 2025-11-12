/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unl.cc.poo.practical_learning.views;

import edu.unl.cc.poo.practical_learning.problems.Account;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Franz Ismael Ludeña Arevalo
 */
public class AccountExecute {
    public static void mostrar (Account cuenta){
        cuenta.getMovimiento().forEach(movimiento->System.out.println(movimiento));
    }
    public static Account buscarCuenta(ArrayList<Account> cuenta, String numero) {
        for (Account c : cuenta) {
            if (c.getNumberAccount().equals(numero)) {
                return c;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Account> cuenta = new ArrayList<>();
        byte opcionmenu;
        do {
            System.out.println("------------------------------------------------------------------------");
            System.out.println("Escriba 1 para crear una cuenta");
            System.out.println("Escirba 2 para acceder a una cuenta");
            System.out.println("Escriba 0 para salir del programa");
            System.out.println("------------------------------------------------------------------------");
            opcionmenu = sc.nextByte();
            switch (opcionmenu) {
                case 1:
                    System.out.println("Ingrese el nombre del representante de la cuenta");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.println("Ingrese un numero para la cuenta");
                    String numberAccount = sc.next();
                    if (buscarCuenta(cuenta, numberAccount) == null) {
                        cuenta.add(new Account(name, numberAccount));
                        System.out.println("Cuentra registrada");
                    } else {
                        System.out.println("Cuenta existente");
                    }
                    break;
                case 2:
                    byte opcioncuenta;
                    System.out.println("Ingrese el numero de cuenta: ");
                    String numero = sc.next();
                    Account cuentaActual = buscarCuenta(cuenta, numero);
                    if (cuentaActual == null) {
                        System.out.println("Cuenta no encontrada");
                        break;
                    }
                    do {
                        System.out.println("------------------------------------------------------------------------");
                        System.out.println("Escriba 1 para Deposita ");
                        System.out.println("Escriba 2 para Retirar ");
                        System.out.println("Escriba 3 para Consultar Saldo ");
                        System.out.println("Escirba 0 para Salir de la cuenta ");
                        System.out.println("------------------------------------------------------------------------");
                        opcioncuenta = sc.nextByte();
                        switch (opcioncuenta) {
                            case 1:
                                try {
                                    System.out.println("Ingrese la cantidad que depositara: ");
                                    int depositar = sc.nextInt();
                                    cuentaActual.deposit(depositar);
                                } catch (IllegalArgumentException iae) {
                                    System.out.println(iae.getMessage());
                                }
                                break;
                            case 2:
                                try {
                                    System.out.println("Ingrese la cantidad que desea retirar: ");
                                    int retirar = sc.nextInt();
                                    cuentaActual.withdraw(retirar);
                                } catch (IllegalArgumentException iae) {
                                    System.out.println(iae.getMessage());
                                }
                                break;
                            case 3:
                                System.out.println("------------------------------------------------------------------------");
                                cuentaActual.presentDat();
                                System.out.println("------------------------------------------------------------------------");
                                break;
                            case 0:
                                System.out.println("Salio de su cuenta");
                                break;
                            default:
                                System.out.println("Escriba un numero correcto");
                        }
                    } while (opcioncuenta != 0);
                    break;
            }
        } while (opcionmenu != 0);
        sc.close();
    }
}
