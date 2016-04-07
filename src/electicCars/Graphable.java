package electicCars;

import java.util.ArrayList;

//2. INTERFACE
public interface Graphable {
	void storeData(Integer powerLeft);
	
	void loadData();
	
	ArrayList<Integer> getChargeList();
}
