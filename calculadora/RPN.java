package calculadora;

class NodoPila {
	public NodoPila abajo;
	public double dato;
	
	public NodoPila(double dato, NodoPila abajo) {
		this.dato = dato;
		this.abajo = abajo;
	}
}

public class RPN {
	private String commando;
	private NodoPila arriba;
	
	public RPN(String commando) {
		arriba = null;
		this.commando = commando;
	}
	
	public void pushPila(double nuevo_dato) {
		NodoPila nuevo_nodo = new NodoPila(nuevo_dato, arriba);
		arriba = nuevo_nodo;
	}
	
	public double popPila() {
		double dato_arriba = arriba.dato;
		arriba = arriba.abajo;
		return dato_arriba;
	}
	
	public void pusher(String[] inputItems) {
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
		String[] inputItems = commando.split(" ");
		pusher(inputItems);
		double val = popPila();
		
		if (arriba != null) {
			throw new IllegalArgumentException();
		}
		
		return val;
	}
}
