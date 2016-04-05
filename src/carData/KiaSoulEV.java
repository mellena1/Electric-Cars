package carData;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class KiaSoulEV extends electicCars.Cars implements electicCars.Graphable{

	private ArrayList<Integer> chargeData = new ArrayList<Integer>();
	
	//In USD
	private final Integer cost = 34500;
	
	private final Integer milesPerCharge = 93;
	
	//In minutes
	private final Integer chargeTime = 246;

	public KiaSoulEV() {
		loadData();
	}
	
	@Override
	public void storeData(Integer powerLeft) {
		chargeData.add(powerLeft);
		
		try (PrintWriter pw = new PrintWriter(new File("KiaSoulEV.txt"))) {
			for (int i = 0; i < chargeData.size(); i++) {
				pw.write(chargeData.get(i) + "%n");
			}
		} catch (Exception ex) {
			System.out.println("A fatal error has occured.");
		}
	}
	
	@Override
	public void loadData() {
		try (Scanner sc = new Scanner(new File("KiaSoulEV.txt"))) {
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
