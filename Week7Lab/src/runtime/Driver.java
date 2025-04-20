package runtime;

import java.util.Scanner;

public class Driver {

	private String selection; // User menu selection
	private static final Scanner scan = new Scanner(System.in); // Static Scanner for input
	private int tens, fives, ones, quarters, dimes, nickels, pennies;
	private double money;

	public Driver() {
		selection = "";
		clearValues();
	}

	public void run() {
		// Display menu
		System.out.println("-----------------------------");
		System.out.println("Welcome to Parkland Cash Calculator");
		System.out.println("-----------------------------");
		System.out.print("Enter an amount to calculate or type 'quit' to exit:\n$");

		selection = scan.nextLine();
		while (!selection.equalsIgnoreCase("quit")) {
			try {
				clearValues();
				money = Double.parseDouble(selection); // store input money value
				pennies = (int) Math.round(money * 100); // convert to whole cents using rounded values: 999.999 would
															// be converted to 1000
				tens = pennies / 1000; // calculate tens
				pennies -= 1000 * tens; // remove tens
				fives = pennies / 500; // calculate fives
				pennies -= 500 * fives; // remove fives
				ones = pennies / 100; // calculate ones
				pennies -= ones * 100; // remove ones
				quarters = pennies / 25; // calculate quarters
				pennies -= quarters * 25; // remove quarters
				dimes = pennies / 10; // calculate dimes
				pennies -= dimes * 10; // remove dimes
				nickels = pennies / 5; // calculate nickels
				pennies -= nickels * 5; // remove nickels and the remainder in pennies is the number of pennies
				System.out.printf("%-15s %-15s %-10s\n", " ", "Amount", "Dollar Value");
				System.out.println("--------------------------------------------");
				System.out.printf("%-15s %-15s $%-10.2f\n", "Tens:", tens, (double) tens * 10);
				System.out.printf("%-15s %-15s $%-10.2f\n", "Fives:", fives, (double) fives * 5);
				System.out.printf("%-15s %-15s $%-10.2f\n", "Ones:", ones, (double) ones);
				System.out.printf("%-15s %-15s $%-10.2f\n", "Quarters:", quarters, (double) quarters * .25);
				System.out.printf("%-15s %-15s $%-10.2f\n", "Dimes:", dimes, (double) dimes * .1);
				System.out.printf("%-15s %-15s $%-10.2f\n", "Nickels:", nickels, (double) nickels * .05);
				System.out.printf("%-15s %-15s $%-10.2f\n", "Pennies:", pennies, (double) pennies * .01);
				System.out.printf("%-15s %s\n", "", "----------------------------");
				System.out.printf("%-15s %-15s $%-10.2f\n", "", "Total:",
						(double) tens * 10 + (double) fives * 5 + (double) ones + (double) quarters * .25
						+ (double) dimes * .1 + (double) nickels * .05 + (double) pennies * .01);
			} catch (Exception e) {
				System.out.println("Invalid entry.");
			}
			
			System.out.print("Enter a new value or type 'quit' to quit\n$");
			selection = scan.nextLine(); // Get user menu choice

		}
		System.out.println("Thank you, goodbye!");
	}

	public void clearValues() {
		tens = 0;
		fives = 0;
		ones = 0;
		quarters = 0;
		dimes = 0;
		nickels = 0;
		pennies = 0;
		money = 0;
	}

	public static void main(String[] args) {
		Driver driver = new Driver();
		driver.run();
	}
}
