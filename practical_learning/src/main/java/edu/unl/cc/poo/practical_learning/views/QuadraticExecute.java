/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unl.cc.poo.practical_learning.views;

import edu.unl.cc.poo.practical_learning.problems.QuadraticEquation;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author HenryDev (Jeam Henry Romero Aguilar)
 */
public class QuadraticExecute {

    public static QuadraticEquation readEquation(Scanner sc) {

        while (true) {            
            try {
             System.out.println("\n*************************************************");
        
        System.out.println("Ingrese los coeficientes de su ecuacion cuadratica: ");

        System.out.print("Coeficienta a (Recuerde que no puede ser cero): ");
        double a = sc.nextDouble();

        System.out.print("Coeficienta b: ");
        double b = sc.nextDouble();

        System.out.print("Coeficienta c: ");
        double c = sc.nextDouble();

        return new QuadraticEquation(a, b, c);
        } catch (IllegalArgumentException e) {
            System.out.println("\n!!!!! Error el valor del coeficiente a no puede ser cero !!!!!");
        }
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("================ QUADRATIC SOLVER ====================");
        
        QuadraticEquation equation = readEquation(sc);
        System.out.println("La ecuacion ingresada es: " + equation);
        int opcion = 0;

        while (opcion != 4) {
            try {
                System.out.println("\n----------------- OPERACIONES -----------------");
                System.out.println("Seleccione una operacion para su ecuacion:");
                System.out.println("  1. Calcular discriminante");
                System.out.println("  2. Calcular raices (x1, x2)");
                System.out.println("  3. Ingresar una nueva ecuacion cuadratica");
                System.out.println("  4. Salir");
                System.out.print("Opcion: ");

                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:

                        System.out.println("\nLa discriminante es: " + equation.getDiscriminant());
                        break;
                    case 2:
                        System.out.println("\nLas raices son: \n" + equation.getRoots());
                        break;
                    case 3:
                        equation = readEquation(sc);
                        System.out.println("\nLa ecuacion ingresada es: " + equation );
                        break;
                    case 4:
                        System.out.println("\nSaliendo del programa.... Gracias por utilizar Quadratic Solver :) ");
                        break;
                    default:

                        System.out.println("\nOpcion no valida, intente con 1, 2 o 3");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("\n ERROR: Por favor, ingrese un numero para seleccionar la opcion");
                sc.next();
                opcion = 0;
            }
        }
    }

}
