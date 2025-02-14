package tui;
//Jimmi is stoooopid
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
				getOperatorFromKeyboard();
				calculates();
				break;
			case 2:
				
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
		System.out.println("**MainMenu**");
		System.out.println("(1) Calculate");
		System.out.println("(2) Print all calculations");
		System.out.println("(0) End program");

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
	
	private String getOperatorFromKeyboard() {
		boolean valid=false;
		Scanner keyboard = new Scanner(System.in);
		String operator=" ";
		System.out.println("Input a operator (+ - * /)");
		operator = keyboard.nextLine();
			if(operator=="+"||operator=="-"||operator=="*"||operator=="/"){
				operator = keyboard.nextLine();
				valid=true;
			}else {
				System.out.println("Not an operator"); 
				keyboard.nextLine();
			}
		while(!valid);
		return operator;
	}
	
	private void calculates() {
		double sum = listNum.getFirst();
		if(listNum==null) {
			ArrayList<Double> listNum = new ArrayList<Double>();
		}
		Iterator<Double> it = listNum.iterator();
		for(Double num : listNum) {
			sum = sum+num;
		}
		for(int i=0; i<listNum.size()-1;i++) {
			System.out.print(it.next()+"+"); 
		}
		System.out.print(it.next()); 
		System.out.print("="+sum); 
		System.out.println(); 
	}
	private void subtract() {
		double sum = listNum.getFirst();
		if(listNum==null) {
			ArrayList<Double> listNum = new ArrayList<Double>();
		}
		Iterator<Double> it = listNum.iterator();
		for(Double num : listNum) {
			sum = sum-num;
		}
		for(int i=0; i<listNum.size()-1;i++) {
			System.out.print(it.next()+"-"); 
		}
		System.out.print(it.next()); 
		System.out.print("="+sum); 
		System.out.println(); 
	}
}