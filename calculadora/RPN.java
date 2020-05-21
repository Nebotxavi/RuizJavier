package calculadora;

/**
 * Paquete para calcular el resultado de una operación cuyos parametros vienen dados en Reverse Polish notation.
 * Reverse Polish notation (RPN) Notación Polaca inversa, por ejemplo
 * la expresión: 5 + 5 nos da 10 respetando la prioridad de
 * los operadores en notación RPN seria: 5 5 +
 */

class NodoPila {
	/**
	 * Clase que gestiona los atributos de la pila.
	 */
	protected NodoPila abajo;
	protected double dato;
	
	public NodoPila(double dato, NodoPila abajo) {
		this.dato = dato;
		this.abajo = abajo;
	}
}

public class RPN {
	/**
	 * Clase principal para el cálculo del resultado de una operación con parametros RPN.
	 * @param String commando. Un string con los valores y el símbolo que define la operación. Ejemplo: "5 5 +". 
	 */	
	private String commando;
	private NodoPila arriba;
	
	public RPN(String commando) {

		arriba = null;
		this.commando = commando;
	}
	
	private void pushPila(double nuevo_dato) {
		NodoPila nuevo_nodo = new NodoPila(nuevo_dato, arriba);
		arriba = nuevo_nodo;
	}
	
	private double popPila() {
		double dato_arriba = arriba.dato;
		arriba = arriba.abajo;
		return dato_arriba;
	}
	
	private void pusher(String[] inputItems) {
		/**
		 * Método que separa los diferentes items contenidos en el string que recibe el constructor y envía como parámetros a los métodos correspondientes.
		 * @param String[] 
		 * @return void
		 */
		double a, b;
				  
        for (String item : inputItems) {
        	if (Character.isDigit(item.charAt(0))) {
        		double numero = Double.parseDouble(item);
        		pushPila(numero);
        	} else {
				b = popPila();
				a = popPila();
				if (item.equals("+")) {
					pushPila(a + b);
				} else if (item.equals("-")) {
					pushPila(a - b);
				} else if (item.equals("*")) {
					pushPila(a * b);
				} else if (item.equals("/")) {
					pushPila(a / b);
				} else if (item.equals("^")) {
					pushPila(Math.pow(a,  b));
				} else if (item.equals("%")) {
					pushPila(a%b);
				} else if (item != " ") {
					throw new IllegalArgumentException();
				}	
        	}
        }
	}
	
	
	public double resultado() {
		/**
		 * Método publico que llama al resto de métodos.
		 * @params none
		 * @return double val. Número resultado de la operación introducida en el constructor.
		 */
		String[] inputItems = commando.split(" ");
		pusher(inputItems);
		double val = popPila();
		
		if (arriba != null) {
			throw new IllegalArgumentException();
		}
		
		return val;
	}
}
