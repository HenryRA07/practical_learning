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
 * @author henry
 */
public class AccountExecute {
    public static Account buscarCuenta(ArrayList<Account> cuenta, String numero) {
    for (Account c : cuenta) {
        if (c.getNumberAccount().equals(numero)) {
            return c;
        }
    }
    return null;
}
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        ArrayList<Account> cuenta = new ArrayList<>();
        byte num;
        do {
            System.out.println("------------------------------");
            System.out.println("Escriba 1 para crear una cuenta");
            System.out.println("Escirba 2 para acceder a una cuenta");
            System.out.println("Escriba cualquier numero para salir del programa");
            System.out.println("------------------------------");
            num = sc.nextByte();
            switch (num) {
                case 1:
                    System.out.println("Ingrese el nombre el representante de la cuenta");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.println(name);
                    System.out.println("Ingrese el nombre el Numero de la cuenta");
                    String numberAccount = sc.next();
                    System.out.println(numberAccount);
                    cuenta.add(new Account(name, numberAccount));
                    break;
                case 2:
                    byte mun;
                    
                    System.out.println("Ingrese el número de cuenta: ");
                    String numero = sc.next();
                    Account cuentaActual = buscarCuenta(cuenta, numero);
                    
                    do {
                        System.out.println("------------------------------");
                        System.out.println("Escriba 1 para Deposita ");
                        System.out.println("Escriba 2 para Retirar ");
                        System.out.println("Escriba 3 para Consultar Saldo ");
                        System.out.println("Escirba 0 para Salir ");
                        System.out.println("------------------------------");
                        mun = sc.nextByte();
                        switch (mun) {
                            case 1:
                                System.out.println("Ingrese la cantidad que depositara: ");
                                int depositar = sc.nextInt();
                                cuentaActual.deposit(depositar);
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
                                System.out.println("------------------------------");
                                cuentaActual.presentDat();
                                System.out.println("------------------------------");
                                break;
                            default:
                                System.out.println("Escriba un numero correcto");
                        }
                    } while (mun != 0);
                    break;
                default:
                    break;
            }
        } while (num!=0);
    }
}
