package carData;

import java.util.ArrayList;

public class BMWi3 extends electicCars.Cars implements electicCars.Graphable{

	private ArrayList<Integer> chargeData = new ArrayList<Integer>();
	
	//In USD
	private final Integer cost = 43300;
	
	private final Integer milesPerCharge = 81;
	
	//In minutes
	private final Integer chargeTime = 200;

	@Override
	public void storeData(Integer powerLeft) {
		chargeData.add(powerLeft);
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
