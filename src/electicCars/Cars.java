package electicCars;

public abstract class Cars {
	//TODO: Add array of names of cars
	
	String[] carNames = new String[] 
			{"BMWi3","ChevroletBolt","ChevroletSparkEV",
			"Fiat500e","FordFocusElectric","KiaSoulEV",
			"MercedesBClassElectricDrive","MitsubishiiMiEV","NissanLeaf",
			"SmartElectricDrive","TeslaModel3","TeslaModelS",
			"TeslaModelX","VolkswagenEGolf"};
	
	public abstract Integer milesLeft(Integer powerLeft);
	
	public abstract Integer chargeTime(Integer powerLeft);
	
	public abstract Integer GetCost();
}
