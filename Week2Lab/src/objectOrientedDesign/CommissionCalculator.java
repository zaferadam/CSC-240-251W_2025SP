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
	private boolean running = true;
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
		while (running){
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
			scan.nextLine();
			
			switch (selection) {
			case 1:
				System.out.print("Enter first name of insured: ");
				auto.setFirstName(scan.nextLine());
				System.out.print("Enter last name of insured: ");
				auto.setLastName(scan.nextLine());
				System.out.print("Enter make of vehicle: ");
				auto.setMake(scan.nextLine());
				System.out.print("Enter model of vehicle: ");
				auto.setModel(scan.nextLine());
				System.out.print("Enter amount of liability: $");
				auto.setLiability(scan.nextDouble());
				System.out.print("Enter amount of collision: $");
				auto.setCollision(scan.nextDouble());
				break;
			case 2:
				System.out.print("Enter first name of insured: ");
				home.setFirstName(scan.nextLine());
				System.out.print("Enter last name of insured: ");
				home.setLastName(scan.nextLine());
				System.out.print("Enter house square footage:");
				home.setFootage(scan.nextDouble());
				System.out.print("Enter amount of dwelling: $");
				home.setDwelling(scan.nextDouble());
				System.out.print("Enter amount of contents: $");
				home.setContents(scan.nextDouble());
				System.out.print("Enter amount of liability: $");
				home.setLiability(scan.nextDouble());
				break;
			case 3:
				System.out.print("Enter first name of insured: ");
				life.setFirstName(scan.nextLine());
				System.out.print("Enter last name of insured: ");
				life.setLastName(scan.nextLine());
				System.out.print("Enter age of insured: ");
				life.setAge(scan.nextInt());
				System.out.print("Enter amount of term: $");
				life.setTerm(scan.nextDouble());
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
			selection = 0;
		} 
		scan.close();
		System.out.println("Thank you for using the Parkland Insurance tool " + count + " times!");
	}
}
