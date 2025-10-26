package edu.unl.cc.poo.practical_learning.views;

import java.util.Scanner;
import edu.unl.cc.poo.practical_learning.problems.Fraction;
import java.util.InputMismatchException;

/**
 *
 * @author Usuario iTC
 */
public class Fraction_executor {

    private Fraction readFraction(Scanner sc) {
        while (true) {
            try {
                System.out.println("Ingrese  el numerador");
                Integer num = sc.nextInt();
                System.out.println("Ingrese  el denominador(No puede ser 0)");
                Integer den = sc.nextInt();
                sc.nextLine();
                return new Fraction(num, den);
            } catch (InputMismatchException ime) {
                sc.nextLine();

                System.out.println("¡ERROR: Entrada no válida, NO es el tipo de dato esperado (debe ser un número)!.");

            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
                System.out.println("Ingrese nuevamente los valores ..........");

            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Fraction_executor executor = new Fraction_executor();

        Fraction f1, f2;
       
            System.out.println("\n---  FRACCION 1 (F1) ---");
            f1 = executor.readFraction(sc);
            System.out.println("\n---  FRACCIÓN 2 (F2) ---");
            f2 = executor.readFraction(sc);

            System.out.println("Las fracciones son: " + f1 + " y " + f2);

            try{
            Fraction sumResult = f1.addition(f2);
            System.out.println(" SUMA: " + f1.toString() + " + " + f2.toString() + " = " + sumResult.toString());
            sumResult.simplify();
            System.out.println("   Resultado Simplificado: " + sumResult.toString());

          
            Fraction subResult = f1.subtraction(f2);
            System.out.println("\n RESTA: " + f1.toString() + " - " + f2.toString() + " = " + subResult.toString());
            subResult.simplify();
            System.out.println("   Resultado Simplificado: " + subResult.toString());

            
            Fraction multResult = f1.multiplication(f2);
            System.out.println("\n MULTIPLICACION: " + f1.toString() + " * " + f2.toString() + " = " + multResult.toString());
            multResult.simplify();
            System.out.println("   Resultado Simplificado: " + multResult.toString());

         
            Fraction divResult = f1.division(f2);
            System.out.println("\n DIVISION: " + f1.toString() + " / " + f2.toString() + " = " + divResult.toString());
            divResult.simplify();
            System.out.println("   Resultado Simplificado: " + divResult.toString());

            System.out.println("\n-------------------------------------------------");
             
            System.out.println("INFORMACION DE F1:");
            System.out.printf("Valor Decimal: %.4f\n", f1.Decimal());
            System.out.println("Fraccion Invertida: " + f1.Investor().toString());

        } catch (IllegalArgumentException e) {
            System.err.println("\n ¡ERROR!: " + e.getMessage());
        }
            sc.close();
    }
}
