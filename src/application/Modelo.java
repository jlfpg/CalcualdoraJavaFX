package application;

public class Modelo {
	public float Calcular(long num1, long num2, String operador){
		switch (operador) {
		case "+":
			return num1 + num2;
		case "-":
			return num1 - num2;
		case "*":
			return num1 * num2;
		case "/":
			if(num2 == 0)
				return 0;
			else{
			return num1 / num2;
			}
		default:
			return 0;
		}
		
	}
}
