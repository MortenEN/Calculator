package Container;
import java.util.ArrayList;


public class CalculationContainer implements CalculationStorageIF {
	private static CalculationContainer uniqueInstance;
	private ArrayList<String> listCalculations = new ArrayList<>();
	
	private CalculationContainer(){
		
	}

	
	public static synchronized CalculationContainer getUniqueInstance(){
		if(uniqueInstance == null){
			uniqueInstance = new CalculationContainer();
		}
		return uniqueInstance;
	} 
	@Override
	public void printAll() {
		for (String builder : listCalculations) {
			System.out.println(builder);
		}
	}
	@Override
	public void add(String calculation) {
		listCalculations.add(calculation);
	}
}
