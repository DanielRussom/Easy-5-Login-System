package application;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
		if (Main.login(username, password)) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Login Success");
			alert.setHeaderText(null);
			alert.setContentText("Welcome " + Main.getUsername() + ".\nYou have successfully logged in.");
			alert.showAndWait();
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Login Error");
			alert.setHeaderText(null);
			alert.setContentText("You have not entered a valid username/password!");
			alert.showAndWait();
		}
	}
}
