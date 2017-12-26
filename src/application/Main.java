package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

	private Stage primaryStage;
	private AnchorPane rootLayout;
	private static String username;
	private static String password;

	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Login System");
		loadDetails();
		initRootLayout();
	}

	/**
	 * Loads the username and password from an external file
	 */
	private void loadDetails() {
		try {
			FileReader fileReader = new FileReader("bin/Details.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			username = bufferedReader.readLine();
			password = bufferedReader.readLine();
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("No username/passwords loaded.");
		}
	}

	/**
	 * Initializes the root layout.
	 */
	public void initRootLayout() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("Display.fxml"));
			rootLayout = (AnchorPane) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns the main stage.
	 * 
	 * @return
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}

	public static boolean login(String attemptedUsername, String attemptedPassword) {
		return (attemptedUsername.equals(username) && attemptedPassword.equals(password));
	}

	public static String getUsername() {
		return username;
	}
}