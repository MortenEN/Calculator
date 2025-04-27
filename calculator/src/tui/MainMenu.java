//Jimmi is stoooopid
package tui;

import java.util.Scanner;

import Container.CalculationContainer;
import Container.CalculationStorageIF;

import java.util.ArrayList;
import java.util.Iterator;
import Controller.CalculationController;

public class MainMenu {
	private CalculationController calculationController;
	private CalculationStorageIF calculationStorage;
	private ArrayList<Double> listNum;
	private String operator;

	public void mainMenu() {
		listNum = new ArrayList<Double>();
		calculationStorage = CalculationContainer.getUniqueInstance();
		calculationController = new CalculationController(calculationStorage);
		boolean running = true;
		while (running) {
			int choice = writeMainMenu();
			switch (choice) {
			case 1:
				getOperatorFromKeyboard();
				inputNumbers();
				if (operator.equals("/") && calculationController.lookForZero(listNum)) {
					System.out.println("Cannot devide by zero");
				} else {
					calculationController.calculates(listNum, operator);
					System.out.println(calculationStorage.getLast());
				}
				break;
			case 2:
				ArrayList<String> listCalculations = calculationStorage.getList();
				for (String builder : listCalculations) {
					System.out.println(builder);
				}
				break;
			case 0:
				running = false;
				System.out.println("Program has terminated");
				break;
			}
		}
	}

	private int writeMainMenu() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("**MainMenu**");
		System.out.println("(1) Calculate");
		System.out.println("(2) Print all calculations");
		System.out.println("(0) End program");

		while (!keyboard.hasNextInt()) {
			System.out.println("you can only input numbers");
			keyboard.nextLine();
		}
		int choice = keyboard.nextInt();
		return choice;
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
			// System.out.println("Input a number");
			// try{
			// num = keyboard.nextDouble();
			// if(!(num==0)){
			// valid = true;
			// }
			// }
			// catch (Exception ex) {
			// System.out.println("Not a number");
			// }
			// }
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

	public ArrayList<Double> getListNum() {
		return listNum;
	}

	public String getOperator() {
		return operator;
	}
}