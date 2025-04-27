package Container;

import java.util.ArrayList;

public class CalculationContainer implements CalculationStorageIF {
	private static CalculationContainer uniqueInstance;
	private ArrayList<String> listCalculations = new ArrayList<>();

	private CalculationContainer() {

	}

	public static synchronized CalculationContainer getUniqueInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new CalculationContainer();
		}
		return uniqueInstance;
	}

	@Override
	public void add(String calculation) {
		listCalculations.add(calculation);
	}

	@Override
	public String getLast() {
		String last = listCalculations.getLast();
		return last;
	}

	@Override
	public ArrayList<String> getList() {
		return listCalculations;
	}

}
