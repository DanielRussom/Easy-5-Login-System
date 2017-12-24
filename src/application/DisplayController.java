package application;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class DisplayController {

	@FXML
	TextField tfUsername;
	@FXML
	TextField tfPassword;
	
	@FXML
	private void loginAttempt() {
		String username = tfUsername.getText();
		String password = tfPassword.getText();
		if(Main.login(username, password)) {
			System.out.println("Correct");
		} else {
			System.out.println("Incorrect");
		}
	}
}
