package calculadora;

class NodoPila {
	protected NodoPila abajo;
	protected double dato;
	
	public NodoPila(double dato, NodoPila abajo) {
		this.dato = dato;
		this.abajo = abajo;
	}
}

/**
 * Paquete para calcular el resultado de una operación cuyos parametros vienen dados en Reverse Polish notation.
 * Reverse Polish notation (RPN) Notación Polaca inversa, por ejemplo
 * la expresión: 5 + 5 nos da 10 respetando la prioridad de
 * los operadores en notación RPN seria: 5 5 +
 */

public class RPN {

	private String commando;
	private NodoPila arriba;
	/**
	 * Clase principal para el cálculo del resultado de una operación con parametros RPN.
	 * @param commando. Un string con los valores y el símbolo que define la operación. Ejemplo: "5 5 +". 
	 */	
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
	
	/**
	 * Principal método que llama al resto de métodos privados. Estos procesan la variable commando para devolver un valor.
	 * @return val. Número resultado de la operación introducida en el constructor.
	 */	
	public double resultado() {

		String[] inputItems = commando.split(" ");
		pusher(inputItems);
		double val = popPila();
		
		if (arriba != null) {
			throw new IllegalArgumentException();
		}
		
		return val;
	}
}
