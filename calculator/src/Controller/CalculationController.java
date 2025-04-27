package Controller;

import java.util.ArrayList;
import java.util.Iterator;
import Container.CalculationStorageIF;
import tui.MainMenu;

import java.lang.StringBuilder;

public class CalculationController {
	private CalculationStorageIF calculationStorage;
	private ArrayList<Double> listNum;
	private String operator;

	public CalculationController(CalculationStorageIF calculationStorage) {
		this.calculationStorage = calculationStorage;
	}

	public void calculates(ArrayList<Double> listNum, String operator) {
		this.listNum = listNum;
		this.operator = operator;
		double sum = listNum.getFirst();
		switch (operator) {
		case "+":
			for (int i = 1; i < listNum.size(); i++) {
				sum = sum + listNum.get(i);
			}
			listNum.addLast(sum);
			convertToStringAndAddToStorage();
			break;

		case "-":
			for (int i = 1; i < listNum.size(); i++) {
				sum = sum - listNum.get(i);
			}
			listNum.addLast(sum);
			convertToStringAndAddToStorage();
			break;

		case "*":
			for (int i = 1; i < listNum.size(); i++) {
				sum = sum * listNum.get(i);
			}
			listNum.addLast(sum);
			convertToStringAndAddToStorage();
			break;

		case "/":
			for (int i = 1; i < listNum.size(); i++) {
				sum = sum / listNum.get(i);
			}
			listNum.addLast(sum);
			convertToStringAndAddToStorage();
			break;
		}
	}

	public String convertToString() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < listNum.size() - 1; i++) {
			builder.append(listNum.get(i) + operator);
		}
		builder.deleteCharAt(builder.length() - 1);
		builder.append("=" + listNum.getLast());
		return builder.toString();
	}

	public void addToContainer(String builder) {
		calculationStorage.add(builder);
	}

	private void convertToStringAndAddToStorage() {
		String resultString = convertToString();
		calculationStorage.add(resultString);
	}

	public boolean lookForZero(ArrayList<Double> listNum) {
		int i = 1;
		boolean zero = false;
		while (i < listNum.size() && !zero) {
			if (listNum.get(i).equals(0.0)) {
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