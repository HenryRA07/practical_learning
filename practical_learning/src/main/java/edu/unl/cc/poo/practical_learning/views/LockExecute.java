
package edu.unl.cc.poo.practical_learning.views;

import edu.unl.cc.poo.practical_learning.problems.Lock;
import java.util.Scanner;

/**
 *
 * @author Xander(Rodorfo Alexander Gallo Guarniso).
 */
public class LockExecute {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Lock myLock = new Lock();

        boolean configured = false;
        while (!configured) {
            System.out.println("Ingrese un pin de 4 dígitos para configurar la cerradura: ");
            String input = sc.nextLine();

            if (!input.matches("\\d{4}")) {
                System.out.println("!PIN INVALIDO! \nEl pin debe tener 4 dígitos");
                continue;
            }
            try {
                Integer newPin = Integer.parseInt(input);
                configured = myLock.configurePin(newPin);
                if (configured) {
                    System.out.printf("Pin configurado exitosamente. \n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error al procesar el pin.");
            }
        }

        boolean unlocked = false;
        while (!unlocked && !myLock.isLocked()) {
            System.out.println("Ingrese el pin para desbloquear: ");
            String attemptStr = sc.nextLine();

            if (!attemptStr.matches("\\d{4}")) {
                System.out.println("Pin invalido\nEl pin debe tener 4 digitos.");
                continue;
            }
            try {
                Integer attempt = Integer.parseInt(attemptStr);
                unlocked = myLock.validatePin(attempt);
                if (unlocked) {
                    System.out.println("Cerradura desbloqueada exitosamente.");
                } else {
                    if (myLock.isLocked()) {
                        System.out.println("Demasiados intentos fallidos. \nLa cerradura se ha bloqueado.");
                    } else {
                        System.out.println("Pin incorrecto ---> Intentos Fallidos: " + myLock.getFailedAttempts());
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Error al procesar el pin.");
            }
        }
        sc.close();
    }
}
