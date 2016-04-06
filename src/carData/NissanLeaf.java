package carData;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class NissanLeaf extends electicCars.Cars implements electicCars.Graphable{

	private ArrayList<Integer> chargeData = new ArrayList<Integer>();
	
	//In USD
	private final Integer cost = 29000;
	
	private final Integer milesPerCharge = 107;
	
	//In minutes
	private final Integer chargeTime = 273;

	public NissanLeaf() {
		loadData();
	}
	
	@Override
	public void storeData(Integer powerLeft) {
		chargeData.add(powerLeft);
		
		try (PrintWriter pw = new PrintWriter(new File("NissanLeaf.txt"))) {
			for (int i = 0; i < chargeData.size(); i++) {
				pw.write(chargeData.get(i) + "\n");
			}
		} catch (Exception ex) {
			System.out.println("A fatal error has occured.");
		}
	}
	
	@Override
	public void loadData() {
		try (Scanner sc = new Scanner(new File("NissanLeaf.txt"))) {
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
	public ArrayList<Integer> getChargeList() {
		return chargeData;
	}
}
