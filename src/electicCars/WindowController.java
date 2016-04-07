package electicCars;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Arrays;

public class WindowController {
	//JavaFX components
	//mainWindow (FXML)
	@FXML ComboBox<String> carComboList;
	@FXML ImageView carImage;
	@FXML TextField batteryTxtField;
	@FXML Button enterButton;
	@FXML Label remainingMilesLbl;
	@FXML Label timeToChargeLbl;
	@FXML Label costLbl;
	@FXML ProgressBar batteryProgBar;
	@FXML Button viewGraphBtn;
	//graphWindow
	ScatterChart<Number, Number> graph;
	NumberAxis xAxis = new NumberAxis(0, 100, 10);
	NumberAxis yAxis = new NumberAxis(0, 100, 10);
	//Cars List
	//8. ARRAYLIST and 9. GENERIC PROGRAMMING (UPCASTING)
	private ArrayList<Cars> carList = new ArrayList<Cars>(Arrays.asList(new carData.BMWi3(), 
					new carData.ChevroletBolt(), new carData.ChevroletSparkEV(), new carData.Fiat500e(), 
					new carData.FordFocusElectric(), new carData.KiaSoulEV(), 
					new carData.MercedesBClassElectricDrive(), new carData.MitsubishiiMiEV(),
					new carData.NissanLeaf(), new carData.SmartElectricDrive(), new carData.TeslaModel3(),
					new carData.TeslaModelS(), new carData.TeslaModelX(), new carData.VolkswagenEGolf()));
	//Other Variables
	private double batteryPercent = 0.0;
	private Cars selectedCar = carList.get(0);
	
	
	//-----------------------EVENT DRIVEN METHODS:
	
	//When the open Graph Window Button
	public void openGraphWindow(){
			Stage stage = new Stage();
			//Set the axis labels up
			xAxis.setTickLabelsVisible(false);
			yAxis.setLabel("Battery Percentage");
			//Populate the graph
			graph = new ScatterChart<Number, Number>(xAxis, yAxis, addDataPointsToGraph());
			//Make graph pretty
			graph.setTitle("Last 100 Battery Inputs of " + carComboList.getValue());
			graph.setLegendVisible(false);
			//Display the window
			stage.setResizable(false);
			stage.setTitle("Graph");
			stage.setScene(new Scene(graph, 400, 400));
			stage.show();
	}
	
	//When enter button is pressed
	public void enterButton(){
		try{ //Make sure text is a number
			double tempBatteryPercent = Double.parseDouble(batteryTxtField.getText()); //10. WRAPPER CLASS
			if(tempBatteryPercent >= 0 && tempBatteryPercent <= 100)
				batteryPercent = tempBatteryPercent;
		}
		catch(NumberFormatException ex){}
		selectedCar.storeData((int)batteryPercent);
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
	
	//3. EVENT HANDLER
	//Do things on key presses
	public void onKeyPress(KeyEvent key){
		if(key.getCode().equals(KeyCode.ENTER)){
			enterButton();
		}
		if(key.getCode().equals(KeyCode.UP)){
			carImage.setLayoutY(carImage.getLayoutY()-10);
		}
		if(key.getCode().equals(KeyCode.DOWN)){
			carImage.setLayoutY(carImage.getLayoutY()+10);
		}
		if(key.getCode().equals(KeyCode.LEFT)){
			carImage.setLayoutX(carImage.getLayoutX()-10);
		}
		if(key.getCode().equals(KeyCode.RIGHT)){
			carImage.setLayoutX(carImage.getLayoutX()+10);
		}
		if(key.getCode().equals(KeyCode.CONTROL)){
			carImage.setLayoutX(303.0);
			carImage.setLayoutY(74.0);
		}
	}
	
	//-----------------HELPER METHODS:
	
	//Helper Method for enter button, make Progress Bar show current battery percentage
	private void updateProgressBar(){
		if(batteryPercent <= 25.0){
			batteryProgBar.setStyle("-fx-accent: red;");
		}
		else if(batteryPercent <= 50.0){
			batteryProgBar.setStyle("-fx-accent: yellow;");
		}
		else{
			batteryProgBar.setStyle("-fx-accent: green;");
		}
		batteryProgBar.setProgress(batteryPercent/100.0);
	}
	
	//Add in the calculation method, Helper Method for enter button, 
	private void updateLabels(){
		remainingMilesLbl.setText(selectedCar.milesLeft((int)batteryPercent) + " miles");
		timeToChargeLbl.setText(selectedCar.chargeTime((int)batteryPercent) + " minutes");
	}
	
	//Helper method for Open Graph button, adds data to the graph
	@SuppressWarnings("unchecked")
	//11. GENERICS
	private ObservableList<XYChart.Series<Number, Number>> addDataPointsToGraph(){
		XYChart.Series<Number, Number> series = new XYChart.Series<>();
		ArrayList<Integer> dataFromCar = selectedCar.getChargeList(); //Get Data
		int x = 0;
		if(dataFromCar.size() > 100){ //Only include last 100 data points
			x += (dataFromCar.size() - 100);
		}
		int y = 1; //x values of the chart
		while(x < dataFromCar.size()){ //Add all data points to the series
			series.getData().add(new XYChart.Data<Number, Number>(y, dataFromCar.get(x)));
			x++;
			y++;
		}
		return FXCollections.observableArrayList(series);
	}
	
	
	//---------------------------RUN ON STARTUP METHODS:
	
	//Setup to put car ArrayList in ComboBox at startup
	public void populateComboBox(){
		carComboList.getItems().setAll(FXCollections.observableArrayList(Cars.carNames));
		carComboList.setValue(Cars.carNames.get(0));
		carSelectComboBox();
	}
}
