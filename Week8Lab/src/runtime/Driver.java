package runtime;

import java.util.Scanner;
import classes.RationalNumber;

public class Driver {
	private String input; // Stores the user input from the console
	private static final Scanner scan = new Scanner(System.in); // Scanner for reading user input
	private RationalNumber fraction;

	public Driver() {
		input = "";
		fraction = new RationalNumber();
	}

	public void run() {
		// Display welcome message
		System.out.println("-----------------------------");
		System.out.println("Welcome to Parkland Greatest Common Divisor Calculator");
		System.out.println("-----------------------------");

		try {
			System.out.print("Enter positive integer as numerator: ");
			input = scan.nextLine(); // Read numerator
			int number = Integer.parseInt(input);
			fraction.setNumerator(number);

			System.out.print("Enter positive integer as denominator: ");
			input = scan.nextLine(); // Read denominator
			number = Integer.parseInt(input);
			if (number == 0) {
				throw new ArithmeticException("denominator can't be zero!");
			}
			fraction.setDenominator(number);
			System.out.println("Greatest common denominator of " + fraction + " is " + fraction.getGCD());
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

		// End of program message
		System.out.println("Thank you, goodbye!");

	}

	public static void main(String[] args) {
		Driver driver = new Driver();
		driver.run();
	}

}
