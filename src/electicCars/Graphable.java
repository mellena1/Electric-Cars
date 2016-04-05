package electicCars;

import java.util.ArrayList;

public interface Graphable {
	
	void storeData(Integer powerLeft);
	Integer getData(int index);
	int getChargeSize();
	ArrayList<Integer> getChargeList();
}
