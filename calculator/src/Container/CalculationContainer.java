package Container;
import java.util.ArrayList;


public class CalculationContainer {
	private static CalculationContainer uniqueInstance;
	private ArrayList<String> listCalculations;
	private String Calculation;
	private CalculationContainer(){
		listCalculations = new ArrayList<>();
	}

	public static CalculationContainer getUniqueInstance(){
		if(uniqueInstance == null){
			uniqueInstance = new CalculationContainer();
		}
		return uniqueInstance;
	} 
}
