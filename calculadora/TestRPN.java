package calculadora;

import java.util.Scanner;

/*
  Objetivo: Obtener código refactorizado a partir de otro que no lo está.
  Tarea: Para esta tarea, se refactorizará un programa mal escrito, sin 
  cambiar la forma en que funcionael programa. Este programa, RPN.java 
  es una calculadora de notación inversa polaca que utiliza una pila.  
  Reverse Polish notation (RPN) NotaciónPolacainversa, 
  por ejemplo la expresión: 4 * 5 -7 / 2 % 3 nos da 1,5 respetando la prioridad de
  los operadores en notación RPN seria: 4 5 * 7 2 / -3 % (pues no podemos 
  poner los paréntesis para alterar la prioridad)
  Se debe reorganizar este código usando almenos tres de las reglas vistas en clase.
*/

public class TestRPN {
	/* metodo main */
	public static void main(String[] args) {
		while(true) {
			Scanner in = new Scanner(System.in);
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

	}

}
