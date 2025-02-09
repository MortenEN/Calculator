package tui;

import java.util.Scanner;
import java.util.ArrayList;
import mod.*;

public class MainMenu {
	private ArrayList<Double> listNum;
	
	public void mainMenu(){
        boolean running = true;
        while(running){
            int choice = writeMainMenu();
            switch(choice){
                case 1:
                    //add();
                	inputNum();
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
	 private void inputNum() {
		 Scanner keyboard = new Scanner(System.in);
		 listNum = new ArrayList<>();
		 System.out.println("Input amount of numbers");
		 while (!keyboard.hasNextInt()) {
	            System.out.println("Input must be a number");
	            keyboard.nextLine();
	        }
		 int numOfNum = keyboard.nextInt();
		 for(;numOfNum>1;numOfNum--) {
			 System.out.println("Input a number");
			 double num = keyboard.nextDouble();
			 while (!keyboard.hasNextDouble()) {
		            System.out.println("Input must be a number");
		            keyboard.nextDouble();
			 }
			 listNum.add(num);
		 }
	 }
}