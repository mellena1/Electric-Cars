package electicCars;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Cars {
	//TODO: Add array of names of cars
	
	public static final ArrayList<String> carNames = new ArrayList<String>(
			Arrays.asList("BMW i3","Chevrolet Bolt","Chevrolet Spark EV",
			"Fiat 500e","Ford Focus Electric","Kia Soul EV",
			"Mercedes B Class Electric Drive","Mitsubishii MiEV","Nissan Leaf",
			"Smart Electric Drive","Tesla Model 3","Tesla Model S",
			"Tesla Model X","Volkswagen E Golf"));
	
	public abstract Integer milesLeft(Integer powerLeft);
	
	public abstract Integer chargeTime(Integer powerLeft);
	
	public abstract Integer GetCost();
}
