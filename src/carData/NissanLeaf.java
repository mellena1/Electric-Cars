package carData;

import java.util.ArrayList;

public class NissanLeaf extends electicCars.Cars implements electicCars.Graphable{

	private ArrayList<Integer> chargeData = new ArrayList<Integer>();
	
	//In USD
	private final Integer cost = 29000;
	
	private final Integer milesPerCharge = 107;
	
	//In minutes
	private final Integer chargeTime = 273;

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
	public Integer getData(int index) {
		return chargeData.get(index);
	}

	@Override
	public int getChargeSize() {
		return chargeData.size();
	}

	@Override
	public ArrayList<Integer> getChargeList() {
		return chargeData;
	}
}
