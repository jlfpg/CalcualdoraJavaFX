package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controlador {

	@FXML
	private Label resultado;
	private long num1 = 0;
	private String operador = "";
	private boolean iniciar = true;
	private Modelo modelo;

	
	public Controlador(){
		
		modelo = new Modelo();
	}
	
	@FXML
	public void cogerNum(ActionEvent evento) {
		if (iniciar) {
			resultado.setText("");
			iniciar = false;
		}
		String valor = ((Button)evento.getSource()).getText();
		resultado.setText(resultado.getText() + valor);
	}

	@FXML
	public void cogerOpe(ActionEvent evento) {
		String valor = ((Button)evento.getSource()).getText();
		if (!valor.equals("=")) {
			if (!operador.isEmpty()) 
				return;
			
			operador = valor;
			num1 = Long.parseLong(resultado.getText());
			resultado.setText("");
		} else {
			if (operador.isEmpty()) {
				return;
			}
			long num2 = Long.parseLong(resultado.getText());
			/*if(modelo==null){
				System.out.println("NO ESTA CREADO EL MODELO");
				System.exit(-1);
			}*/
			//System.out.println(num1 + " " + num2);
			float salida = modelo.Calcular(num1, num2, operador);
			resultado.setText(String.valueOf(salida));
			operador = "";
			iniciar = true;
		}

	}

}
