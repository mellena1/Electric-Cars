package carData;

import java.util.ArrayList;

public class ChevroletSparkEV extends electicCars.Cars implements electicCars.Graphable{

	private ArrayList<Integer> chargeData = new ArrayList<Integer>();
	
	//In USD
	private final Integer cost = 26000;
	
	private final Integer milesPerCharge = 82;
	
	//In minutes
	private final Integer chargeTime = 346;

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

}