package runtime;

import java.util.Scanner;
import classes.Denomination;

public class Driver {

	private String input; // Stores the user input from the console
	private static final Scanner scan = new Scanner(System.in); // Scanner for reading user input
	private Denomination tens, fives, ones, quarters, dimes, nickels, pennies; // Denominations used
	private double money, upperLimit; // Input monetary value and maximum acceptable limit

	// Constructor: initializes all denomination objects and sets the input limit
	public Driver() {
		input = "";
		tens = new Denomination(10);
		fives = new Denomination(5);
		ones = new Denomination(1);
		quarters = new Denomination(0.25);
		dimes = new Denomination(0.1);
		nickels = new Denomination(0.05);
		pennies = new Denomination(0.01);
		upperLimit = 1_000_000; // Custom upper bound for input validation
		clearValues(); // Resets all counts and money to 0
	}

	// Main application loop
	public void run() {
		// Display welcome message
		System.out.println("-----------------------------");
		System.out.println("Welcome to Parkland Cash Calculator");
		System.out.println("-----------------------------");
		System.out.print("Enter an amount to calculate or type 'quit' to exit:\n$");

		input = scan.nextLine(); // Read initial input

		// Continue looping until the user types "quit"
		while (!input.equalsIgnoreCase("quit")) {
			try {
				clearValues(); // Reset all denomination counts and money to 0

				// Attempt to parse the input into a double value
				money = Double.parseDouble(input);

				// Check if the value is too large
				if (money > upperLimit) {
					throw new ArithmeticException("Input is too large to process. Max amount is $" + upperLimit + ".");
				}

				// Check if the value is negative
				if (money < 0) {
					throw new ArithmeticException("Input is negative. Only positive numbers allowed.");
				}

				// Convert dollar amount to integer cents for calculation
				int cents = (int) Math.round(money * 100);

				// Calculate number of each denomination starting with largest
				tens.setCount(cents / 1000); // $10 bills
				cents -= tens.valueCents();

				fives.setCount(cents / 500); // $5 bills
				cents -= fives.valueCents();

				ones.setCount(cents / 100); // $1 bills
				cents -= ones.valueCents();

				quarters.setCount(cents / 25); // Quarters
				cents -= quarters.valueCents();

				dimes.setCount(cents / 10); // Dimes
				cents -= dimes.valueCents();

				nickels.setCount(cents / 5); // Nickels
				cents -= nickels.valueCents();

				pennies.setCount(cents); // Pennies (remaining cents)

				// Display formatted table of results
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
						tens.valueDollars() + fives.valueDollars() + ones.valueDollars() + quarters.valueDollars()
								+ dimes.valueDollars() + nickels.valueDollars() + pennies.valueDollars());

				// Handle improper numerical formats (e.g., letters or multiple dots)
			} catch (NumberFormatException e) {
				System.out.println("Invalid entry. Please enter a valid number.");

				// Handle custom exceptions for out-of-range or negative values
			} catch (ArithmeticException e) {
				System.out.println(e.getMessage());

				// Catch any other unexpected exceptions
			} catch (Exception e) {
				System.out.println("An unexpected error occurred.");
			}

			// Prompt user again after processing
			System.out.print("Enter a new value or type 'quit' to quit\n$");
			input = scan.nextLine();
		}

		// End of program message
		System.out.println("Thank you, goodbye!");
	}

	// Resets all denomination counts and the monetary amount
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

	// Main entry point of the application
	public static void main(String[] args) {
		Driver driver = new Driver();
		driver.run();
	}
}
