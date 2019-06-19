package nidhizare;

import java.net.URL;
import java.util.ResourceBundle;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller implements Initializable{

	@FXML
	public Label welcomeLabel;
	
	@FXML
	public ChoiceBox<String> cBox;
	
	@FXML
	public TextField userInputField;
	
	@FXML
	public Button convertButton;
	
	private static final String C_F = "Celsius to Fahrenheit";
	private static final String F_C = "Fahrenheit to Celsius";
	
	private boolean isC_F = true;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		cBox.getItems().add(C_F);
		cBox.getItems().add(F_C);
		cBox.setValue(C_F);
		cBox.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue)->{
			if(newValue.equals(C_F)) {
				isC_F=true; 			//User selected Celsius to Fahrenheit
			}
			else {
				isC_F=false;			//User selected Fahrenheit to Celsius
			}
		});
		convertButton.setOnAction(event -> { 
			convert();
		});
		
	}

	private void convert() {
		
		String input = userInputField.getText();
		float enteredTemperature=0.0f;
		
		try {
			enteredTemperature = Float.parseFloat(input);
		}
		catch(Exception e) {
			warnUser();
			return;
		}
		float newTemperature=0.0f;
		if(isC_F) {
			newTemperature= (enteredTemperature * 9/5)+32;    // C to F
		}
		else {
			newTemperature= (enteredTemperature-32)*5/9;     // F to C
		}
		display(newTemperature);
	}

	private void warnUser() {
		Alert alert =new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error Occured");
		alert.setHeaderText("Invalid Temperature Entered");
		alert.setContentText("Please enter a valid temperature.");
		alert.show();
		
	}

	private void display(float newTemperature) {
		String unit = isC_F ? " F" : " C";
		
		Alert alert =new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Result");
		alert.setHeaderText("Converted Temperature");
		alert.setContentText("The new tempertaure is "+ newTemperature + unit +".");
		alert.show();
		
	}

}
