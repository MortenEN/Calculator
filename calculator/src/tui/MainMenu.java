package tui;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import mod.*;

public class MainMenu {
	private ArrayList<Double> listNum;

	public void mainMenu(){
		boolean running = true;
		while(running){
			int choice = writeMainMenu();
			switch(choice){
			case 1:
				inputNumbers();
				add();
				break;
			case 2:
				//subtract();
				break;
			case 3:
				//multiply();
				break;
			case 4:
				//devide();
				break;
			case 0:
				running = false;
				System.out.println("program terminated");
				break;
			}
		}
	}
	private int writeMainMenu(){
		Scanner keyboard = new Scanner(System.in);
		System.out.println("**HovedMenu**");
		System.out.println("(1) add numbers");
		System.out.println("(2) subtract numbers");
		System.out.println("(3) multiply numbers");
		System.out.println("(4) devide numbers");
		System.out.println("(0) end program");

		while(!keyboard.hasNextInt()){
			System.out.println("you can only input numbers");
			keyboard.nextLine();
		}
		int choice = keyboard.nextInt();
		return choice;
	}
	private void inputNumbers() {

		listNum = new ArrayList<>();
		System.out.println("How many numbers?");
		double numOfNum = getNumberFromKeyboard();
		for(int tries=0;tries<numOfNum;tries++) {
			listNum.add(getNumberFromKeyboard());
		}
	}
	private double getNumberFromKeyboard() {
		boolean valid=false;
		double num=0;
		do {
			System.out.println("Input a number");
			try { 
				Scanner keyboard = new Scanner(System.in);
				num = keyboard.nextDouble();
				valid=true;
			}
			catch(Exception ex){
				System.out.println("Not a number"); 
			}


		}while(!valid);
		return num;
	} 
	private void add() {
		double sum = 0;
		if(listNum==null) {
			ArrayList<Double> listNum = new ArrayList<Double>();
		}
		Iterator<Double> it = listNum.iterator();
		while(it.hasNext()) {
			System.out.print(it.hasNext()+"+");
		}
		System.out.print("="+sum);
	}
}