package carData;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MercedesBClassElectricDrive extends electicCars.Cars implements electicCars.Graphable{

	private ArrayList<Integer> chargeData = new ArrayList<Integer>();
	
	//In USD
	private final Integer cost = 42400;
	
	private final Integer milesPerCharge = 85;
	
	//In minutes
	private final Integer chargeTime = 168;

	public MercedesBClassElectricDrive() {
		loadData();
	}
	
	@Override
	public void storeData(Integer powerLeft) {
		chargeData.add(powerLeft);
		
		try (PrintWriter pw = new PrintWriter(new File("MercedesBClassElectricDrive.txt"))) {
			for (int i = 0; i < chargeData.size(); i++) {
				pw.write(chargeData.get(i) + "%n");
			}
		} catch (Exception ex) {
			System.out.println("A fatal error has occured.");
		}
	}
	
	@Override
	public void loadData() {
		try (Scanner sc = new Scanner(new File("MercedesBClassElectricDrive.txt"))) {
			while (true) {
				chargeData.add(Integer.parseInt(sc.nextLine()));
			}
		} catch (Exception e) {}
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
