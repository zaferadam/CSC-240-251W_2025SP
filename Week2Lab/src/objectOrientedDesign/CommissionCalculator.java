package objectOrientedDesign;

import java.util.Scanner;
import insurance.Auto;
import insurance.Home;
import insurance.Life;

/**
 * Design and implement a CommissionCalculator class that contains (or “has a”)
 * single Auto, Home, and Life insurance policy object (from the classes
 * developed in the previous lab). Create each object in the
 * CommissionCalculator constructor. Also in the CommissionCalculator class,
 * write a method named Run that creates and uses the menu below to prompt the
 * user to enter information for each Auto, Home, and Life policy object and
 * computes commission and prints the commission for each policy object as
 * demonstrated in the example program output below.
 */

public class CommissionCalculator {

	private Auto auto;
	private Home home;
	private Life life;
	private int selection = 0;
	private Boolean running = true;
	private static int count = 0;

	/************************
	 * Constructors
	 ************************/
	public CommissionCalculator() {
		auto = new Auto();
		home = new Home();
		life = new Life();
	}

	public void Run() {
		
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("-----------------------------");
			System.out.println("Welcome to Parkland Insurance");
			System.out.println("-----------------------------");
			System.out.println("Enter any of the following:");
			System.out.println("     1) Enter auto insurance policy information");
			System.out.println("     2) Enter home insurance policy information");
			System.out.println("     3) Enter life insurance policy information");
			System.out.println("     4) Compute commission and print auto policy");
			System.out.println("     5) Compute commission and print home policy");
			System.out.println("     6) Compute commission and print life policy");
			System.out.println("     7) Quit");

			selection = scan.nextInt();
			
			switch (selection) {
			case 1:
				auto.setAll();
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				auto.computeCommission();
				System.out.println(auto);
				break;
			case 5:
				home.computeCommission();
				System.out.println(home);
				break;
			case 6:
				life.computeCommission();
				System.out.println(life);
				break;
			case 7:
				running = false;
				break;
			default:
				System.out.println("Invalid Selection");
				break;
			}
			count++;
		} 
		while (running);
		scan.close();
		System.out.println("Thank you for using the Parkland Insurance tool " + count + " times!");
	}
}
