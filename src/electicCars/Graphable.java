package electicCars;

import java.util.ArrayList;

public interface Graphable {
	
	void storeData(Integer powerLeft);
	
	void loadData();
	
	ArrayList<Integer> getChargeList();
}
