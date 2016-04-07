package electicCars;

import java.util.ArrayList;
import java.util.Arrays;

//1. ABSTRACT CLASS
public abstract class Cars implements Graphable {
	//3. STATIC METHOD
	public static final ArrayList<String> carNames = new ArrayList<String>(
			Arrays.asList("BMW i3","Chevrolet Bolt","Chevrolet Spark EV",
			"Fiat 500e","Ford Focus Electric","Kia Soul EV",
			"Mercedes B Class Electric Drive","Mitsubishii MiEV","Nissan Leaf",
			"Smart Electric Drive","Tesla Model 3","Tesla Model S",
			"Tesla Model X","Volkswagen E Golf"));
	
	public abstract Integer milesLeft(Integer powerLeft); //10. WRAPPER CLASS
	
	public abstract Integer chargeTime(Integer powerLeft);
	
	public abstract Integer GetCost();
}
