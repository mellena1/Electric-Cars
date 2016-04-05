package electicCars;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Runner extends Application {

	@Override
	//Open the window
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("mainWindow.fxml")); //get from FXML file
			AnchorPane root = loader.load(); //Load AnchorPane
			WindowController controller = loader.getController();
			controller.populateComboBox(); //Add all car names to combo box
			Scene scene = new Scene(root);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Run
	public static void main(String[] args) {
		launch(args);
	}
}
