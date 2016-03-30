package electicCars;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.ScatterChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class WindowController {
	//JavaFX components
	//mainWindow
	@FXML ComboBox<String> carComboList;
	@FXML ImageView carImage;
	@FXML TextField batteryTxtField;
	@FXML Button enterButton;
	@FXML Label remainingMilesLbl;
	@FXML Label timeToChargeLbl;
	@FXML ProgressBar batteryProgBar;
	@FXML Button viewGraphBtn;
	//graphWindow
	@FXML ScatterChart<Integer, Double> graph;
	
	//When the open Graph Window Button
	public void openGraphWindow(){
		try {
			AnchorPane root = FXMLLoader.load(getClass().getResource("graphWindow.fxml"));
			Stage stage = new Stage();
			stage.setTitle("Graph");
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//When enter button is pressed
	public void enterButton(){
		double percent = 0.0;
		try{ //Make sure text is a number
			percent = Double.parseDouble(batteryTxtField.getText());
		}
		catch(NumberFormatException ex){}
		updateProgressBar(percent);
		updateLabels(percent);
	}
	
	//TODO: Get selected car model name, update image
	public void carSelectComboBox(){
		
	}
	
	
	//HELPER METHODS:
	
	//Helper Method for enter button, make Progress Bar show current battery percentage
	public void updateProgressBar(double percent){
		batteryProgBar.setProgress(percent/100.0); //Update the bar
	}
	
	//TODO: Add in the calculation method, Helper Method for enter button, 
	public void updateLabels(double percent){
		
	}
	
	//Helper method for Combo Box, updates the Image View with a car picture
	public void updateCarImage(String carName){
		carImage.setImage(new Image(carName + ".png"));
	}
	
	//Helper method for Open Graph button, adds data to the graph
	public void addDataPointsToGraph(){
		
	}
}
