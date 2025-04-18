package Controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import Container.CalculationContainer;
import java.lang.StringBuilder;

public class CalculationController {
	private ArrayList<Double> listNum;
	private String operator;
	private CalculationContainer calculationContainer;
	private String builder;
	
	public CalculationController() {
		calculationContainer  = CalculationContainer.getUniqueInstance();
	}
	
	public void inputNumbers() {
		listNum = new ArrayList<>();
		boolean valid = false;
		do {
			System.out.println("How many numbers?");
			double numOfNum = getNumberFromKeyboard();
			if (numOfNum >= 2) {
				for (int tries = 0; tries < numOfNum; tries++) {
					listNum.add(getNumberFromKeyboard());
				}
				valid = true;
			} else {
				System.out.println("Must be 2 or greater");
			}
		} while (!valid);
	}

	private double getNumberFromKeyboard() {
		boolean valid = false;
		double num = 0;
		Scanner keyboard = new Scanner(System.in);
		do {
			System.out.println("Input a number");
//			if(operator.equals("/")) {
	//			System.out.println("Input a number");
		//		try{
			//			num = keyboard.nextDouble();
				//		if(!(num==0)){
					//	valid = true;	
					//}
					//}
				 //catch (Exception ex) {
					//System.out.println("Not a number");
				//}
			//}
			try {
				num = keyboard.nextDouble();
				valid = true;
			} catch (Exception ex) {
				System.out.println("Not a number");
			}
		} while (!valid);
		return num;
	}

	public String getOperatorFromKeyboard() {
		boolean valid = false;
		do {
			Scanner keyboard = new Scanner(System.in);
			System.out.println("Input a operator +,-,*,/");
			operator = keyboard.nextLine();
			if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")) {
				valid = true;
			} else {
				System.out.println("Not a operator");
			}
		} while (!valid);
		return operator;

	}

	public void calculates() {
		double sum = listNum.getFirst();
		switch (operator) {
		case "+":
			System.out.print(sum);
			for (int i = 1; i < listNum.size(); i++) {
				System.out.print(operator + listNum.get(i));
				sum = sum + listNum.get(i);
			}
			System.out.print("=" + sum);
			System.out.println();
			listNum.addLast(sum);
			break;

		case "-":
			System.out.print(sum);
			for (int i = 1; i < listNum.size(); i++) {
				System.out.print(operator + listNum.get(i));
				sum = sum - listNum.get(i);
			}
			System.out.print("=" + sum);
			System.out.println();
			listNum.addLast(sum);
			break;

		case "*":
			System.out.print(sum);
			for (int i = 1; i < listNum.size(); i++) {
				System.out.print(operator + listNum.get(i));
				sum = sum * listNum.get(i);
			}
			System.out.print("=" + sum);
			System.out.println();
			listNum.addLast(sum);
			break;

		case "/":
			if(!lookForZero()) {
				
			System.out.print(sum);
			for (int i = 1; i < listNum.size(); i++) {
				System.out.print(operator + listNum.get(i));
				sum = sum / listNum.get(i);
			}
			System.out.print("=" + sum);
			System.out.println();
			listNum.addLast(sum);
			break;
			}
			}
		String resultString = convertToString();
	    calculationContainer.add(resultString);
		}

	public String convertToString() {
		StringBuilder builder= new StringBuilder();
		for (int i = 0; i < listNum.size() - 1; i++) {
			builder.append(listNum.get(i)+operator);
		}
		builder.deleteCharAt(builder.length()-1);
		builder.append("="+listNum.getLast());
		return builder.toString();
	}
	public void addToContainer(String builder) {
		calculationContainer.add(builder);
	}

	private boolean lookForZero() {
		int i = 1;
		boolean zero = false;
		while (i < listNum.size() && !zero) {
			if (listNum.get(i).equals(0.0)) {
				System.out.println("Cannot devide by zero");
				zero = true;
			} else {
				i++;
			}
		}
		return zero;
	}

//redudent methode
	private void subtract() {
		double sum = listNum.getFirst();
		if (listNum == null) {
			ArrayList<Double> listNum = new ArrayList<Double>();
		}
		Iterator<Double> it = listNum.iterator();
		for (Double num : listNum) {
			sum = sum - num;
		}
		for (int i = 0; i < listNum.size() - 1; i++) {
			System.out.print(it.next() + "-");
		}
		System.out.print(it.next());
		System.out.print("=" + sum);
		System.out.println();
	}
}