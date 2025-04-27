package Container;

import java.util.ArrayList;

public interface CalculationStorageIF {
	void add(String calculation);

	ArrayList<String> getList();

	String getLast();
}
