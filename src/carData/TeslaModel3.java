package carData;

import java.util.ArrayList;

public class TeslaModel3 extends electicCars.Cars implements electicCars.Graphable{

	private ArrayList<Integer> chargeData = new ArrayList<Integer>();
	
	//In USD
	private final Integer cost = 35000;
	
	private final Integer milesPerCharge = 215;
	
	//In minutes
	//Approximated from Tesla model s data
	private final Integer chargeTime = 43;

	@Override
	public void storeData(Integer powerLeft) {
		chargeData.add(powerLeft);
		//TODO some code to update the graph
	}

	@Override
	public Integer milesLeft(Integer powerLeft) {
		return (int)(milesPerCharge*(powerLeft/100.0));
	}

	@Override
	public Integer chargeTime(Integer powerLeft) {
		return (int)(chargeTime*((100-powerLeft)/100.0));
	}

	@Override
	public Integer GetCost() {
		return cost;
	}

	@Override
	public void getData(int index) {
		// TODO Auto-generated method stub
		
	}

}
