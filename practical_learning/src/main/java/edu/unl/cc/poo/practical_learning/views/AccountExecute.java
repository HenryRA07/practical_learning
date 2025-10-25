/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unl.cc.poo.practical_learning.views;

import edu.unl.cc.poo.practical_learning.problems.Account;
import java.util.Scanner;

/**
 *
 * @author henry
 */
public class AccountExecute {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        
        System.out.println("------------------------------");
        System.out.println("Escriba 1 para crear una cuenta");
        System.out.println("Escirba 2 para acceder a una cuenta");
        System.out.println("");
        System.out.println("------------------------------");
        byte num = sc.nextByte();
        switch (num) {
            case 1:
                System.out.println("Ingrese el nombre el representante de la cuenta");
                String name = sc.nextLine();
                sc.next();
                System.out.println("Ingrese el nombre el Numero de la cuenta");
                String numberAccount = sc.nextLine();
                sc.next();
                Account cuenta = new Account(name, numberAccount);
                System.out.println(cuenta.getNumberAccount());
                break;
            case 2:
                byte mun;
                Account cuenta1 = new Account("Franz", "1105527327");
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
                            cuenta1.deposit(depositar);
                            break;
                        case 2:
                            System.out.println("Ingrese la cantidad que depositara: ");
                            int retirar = sc.nextInt();
                            cuenta1.deposit(retirar);
                            break;
                        case 3:
                            System.out.println("Su saldo actual es:");
                            System.out.println(cuenta1.getBalance());
                            break;
                        default:
                            System.out.println("Escriba un numero correcto");
                    }
                } while (mun != 0);
                break;
            default:
                break;
        }
                
    }
}
