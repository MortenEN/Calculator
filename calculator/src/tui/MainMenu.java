//Jimmi is stoooopid
package tui;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import Controller.CalculationController;


public class MainMenu {
	private ArrayList<Double> listNum;
	private String operator;
	private CalculationController calculationController;
	
	public void mainMenu() {
		calculationController = new CalculationController();
		boolean running = true;
		while (running) {
			int choice = writeMainMenu();
			switch (choice) {
			case 1:
				calculationController.getOperatorFromKeyboard();
				calculationController.inputNumbers();
				calculationController.calculates();
				break;
			case 2:

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
}