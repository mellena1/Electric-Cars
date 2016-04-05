package electicCars;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Arrays;

public class WindowController {
	//JavaFX components
	//mainWindow
	@FXML ComboBox<String> carComboList = new ComboBox<String>(FXCollections.observableArrayList(Cars.carNames));
	@FXML ImageView carImage;
	@FXML TextField batteryTxtField;
	@FXML Button enterButton;
	@FXML Label remainingMilesLbl;
	@FXML Label timeToChargeLbl;
	@FXML Label costLbl;
	@FXML ProgressBar batteryProgBar;
	@FXML Button viewGraphBtn;
	//graphWindow
	@FXML ScatterChart<Integer, Integer> graph;
	//Cars List
	private ArrayList<Cars> carList = new ArrayList<Cars>(Arrays.asList(new carData.BMWi3(), 
					new carData.ChevroletBolt(), new carData.ChevroletSparkEV(), new carData.Fiat500e(), 
					new carData.FordFocusElectric(), new carData.KiaSoulEV(), 
					new carData.MercedesBClassElectricDrive(), new carData.MitsubishiiMiEV(),
					new carData.NissanLeaf(), new carData.SmartElectricDrive(), new carData.TeslaModel3(),
					new carData.TeslaModelS(), new carData.TeslaModelX(), new carData.VolkswagenEGolf()));
	//Other Variables
	private double batteryPercent = 0.0;
	private Cars selectedCar = carList.get(0);
	
	//When the open Graph Window Button
	public void openGraphWindow(){
		try {
			AnchorPane root = FXMLLoader.load(getClass().getResource("graphWindow.fxml"));
			Stage stage = new Stage();
			addDataPointsToGraph();
			stage.setTitle("Graph");
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//When enter button is pressed
	public void enterButton(){
		try{ //Make sure text is a number
			batteryPercent = Double.parseDouble(batteryTxtField.getText());
		}
		catch(NumberFormatException ex){}
		updateProgressBar();
		updateLabels();
	}
	
	//Get selected car model name, update image
	public void carSelectComboBox(){
		selectedCar = carList.get(carComboList.getSelectionModel().getSelectedIndex()); //Update selectedCar
		carImage.setImage(new Image("Images/" + carComboList.getValue().replaceAll(" ", "") + ".png")); //Update ImageView
		costLbl.setText("$" + selectedCar.GetCost()); //Update Cost
		if(batteryPercent != 0.0) //If batteryPercent isn't 0, update the labels based on new car
			updateLabels();
	}
	
	
	//HELPER METHODS:
	
	//Helper Method for enter button, make Progress Bar show current battery percentage
	private void updateProgressBar(){
		batteryProgBar.setProgress(batteryPercent/100.0);
	}
	
	//Add in the calculation method, Helper Method for enter button, 
	private void updateLabels(){
		remainingMilesLbl.setText(selectedCar.milesLeft((int)batteryPercent) + " miles");
		timeToChargeLbl.setText(selectedCar.chargeTime((int)batteryPercent) + " minutes");
	}
	
	//Helper method for Open Graph button, adds data to the graph
	private void addDataPointsToGraph(){
		XYChart.Series<Integer, Integer> series = new XYChart.Series<Integer, Integer>();
		ArrayList<Integer> dataFromCar = selectedCar.getChargeList();
		for(int x = 0; x < dataFromCar.size(); x++){
			series.getData().set(x, new XYChart.Data<>(x, dataFromCar.get(x)));
		}
		graph.getData().add(series);
	}
	
	
	//STARTUP METHODS:
	
	//Setup to put car ArrayList in ComboBox at startup
	public void populateComboBox(){
		carComboList.getItems().setAll(FXCollections.observableArrayList(Cars.carNames));
		carComboList.setValue(Cars.carNames.get(0));
		carSelectComboBox();
	}
}
