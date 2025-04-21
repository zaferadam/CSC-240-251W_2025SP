package runtime;

import java.util.Scanner;
import classes.Denomination;

public class Driver {

	private String input; // User menu selection
	private static final Scanner scan = new Scanner(System.in); // Static Scanner for input
	private Denomination tens, fives, ones, quarters, dimes, nickels, pennies;
	private double money;

	public Driver() {
		input = "";
		clearValues();
		tens = new Denomination(10);
		fives = new Denomination(5);
		ones = new Denomination(1);
		quarters = new Denomination(0.25);
		dimes = new Denomination(0.1);
		nickels = new Denomination(0.05);
		pennies = new Denomination(0.01);
	}

	public void run() {
		// Display menu
		System.out.println("-----------------------------");
		System.out.println("Welcome to Parkland Cash Calculator");
		System.out.println("-----------------------------");
		System.out.print("Enter an amount to calculate or type 'quit' to exit:\n$");

		input = scan.nextLine();
		while (!input.equalsIgnoreCase("quit")) {
			try {
				clearValues();
				money = Double.parseDouble(input); // store input money value
				int cents= (int) Math.round(money * 100); // convert to whole cents using rounded values: 999.999 would
															// be converted to 1000
				tens.setCount(cents/1000); // calculate tens
				cents -= tens.valueCents(); // remove tens
				fives.setCount(cents/500); // calculate fives
				cents -= fives.valueCents(); // remove fives
				ones.setCount(cents/100); // calculate ones
				cents -= ones.valueCents(); // remove ones
				quarters.setCount(cents/25); // calculate quarters
				cents -= quarters.valueCents(); // remove quarters
				dimes.setCount(cents/10); // calculate dimes
				cents -= dimes.valueCents(); // remove dimes
				nickels.setCount(cents/5); // calculate nickels
				cents -= nickels.valueCents(); // remove nickels and the remainder in pennies is the number of pennies
				pennies.setCount(cents); // set the remaining pennies amount
				System.out.printf("%-15s %-15s %-10s\n", " ", "Amount", "Dollar Value");
				System.out.println("--------------------------------------------");
				System.out.printf("%-15s %-15s $%-10.2f\n", "Tens:", tens.getCount(), tens.valueDollars());
				System.out.printf("%-15s %-15s $%-10.2f\n", "Fives:", fives.getCount(), fives.valueDollars());
				System.out.printf("%-15s %-15s $%-10.2f\n", "Ones:", ones.getCount(), ones.valueDollars());
				System.out.printf("%-15s %-15s $%-10.2f\n", "Quarters:", quarters.getCount(), quarters.valueDollars());
				System.out.printf("%-15s %-15s $%-10.2f\n", "Dimes:", dimes.getCount(), dimes.valueDollars());
				System.out.printf("%-15s %-15s $%-10.2f\n", "Nickels:", nickels.getCount(), nickels.valueDollars());
				System.out.printf("%-15s %-15s $%-10.2f\n", "Pennies:", pennies.getCount(), pennies.valueDollars());
				System.out.printf("%-15s %s\n", "", "----------------------------");
				System.out.printf("%-15s %-15s $%-10.2f\n", "", "Total:",
						tens.valueDollars() + fives.valueDollars() + ones.valueDollars() + quarters.valueDollars() + dimes.valueDollars() + nickels.valueDollars() + pennies.valueDollars());
			} catch (Exception e) {
				System.out.println("Invalid entry.");
			}
			
			System.out.print("Enter a new value or type 'quit' to quit\n$");
			input = scan.nextLine(); // Get user menu choice

		}
		System.out.println("Thank you, goodbye!");
	}

	public void clearValues() {
		tens.setCount(0);
		fives.setCount(0);
		ones.setCount(0);
		quarters.setCount(0);
		dimes.setCount(0);
		nickels.setCount(0);
		pennies.setCount(0);
		money = 0;
	}

	public static void main(String[] args) {
		Driver driver = new Driver();
		driver.run();
	}
}
