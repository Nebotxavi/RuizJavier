package calculadora;

import java.util.Scanner;

/**
 * Clase para probar la clase RPN.
 * @see resultado
 */

public class TestRPN {

	public static void main(String[] args) {
		Scanner in;
		while(true) {
			in = new Scanner(System.in);
			System.out.println("Introduce expresion Postfija o teclea \"fin\".");
			String linea = in.nextLine();
			if (linea.equals("fin")) {
				System.out.println("Fin de programa");
				break;
			} else {
				RPN calc = new RPN(linea);
				System.out.printf("El resultado es %f\n", calc.resultado());
			}
		}
		in.close();
	}
}
