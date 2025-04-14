package runtime;

import java.util.Scanner;
import classes.Gradebook;
import classes.Student;

public class Driver {

	private boolean running;             // Controls the application loop
	private int entries;                 // Number of student entries to collect
	private int selection;              // User menu selection
	private Gradebook gradebook;        // Gradebook instance to manage students
	private static final Scanner scan = new Scanner(System.in); // Static Scanner for input

	public Driver() {
		running = true;
		entries = 5;     // Required number of student entries
		selection = 0;
		gradebook = new Gradebook();
	}

	public void run() {
		while (running) {
			// Display menu
			System.out.println("-----------------------------");
			System.out.println("Welcome to Parkland Gradebook Manager");
			System.out.println("-----------------------------");
			System.out.println("Enter any of the following:");
			System.out.println("     1) Enter new Student List");
			System.out.println("     2) Print the List");
			System.out.println("     3) Quit");

			try {
				selection = scan.nextInt(); // Get user menu choice
				scan.nextLine(); // Consume newline
			} catch (Exception e) {
				System.out.println("Invalid input! Please enter a number.");
				scan.nextLine(); // Clear buffer
				continue;
			}

			// Handle menu options
			switch (selection) {
			case 1:
				gradebook.clearGradebook();
				System.out.println("Add " + entries + " students to the gradebook:");
				String[] temp;
				for (int i = 0; i < entries; i++) {
					try {
						System.out.print("<First Name> <Last Name> <Score>: ");
						temp = scan.nextLine().trim().split("\\s+");

						// Validate input
						if (temp.length < 3) {
							throw new IllegalArgumentException("Expected format: <FirstName> <LastName> <Score>");
						}

						String firstName = temp[0];
						String lastName = temp[1];
						int score = Integer.parseInt(temp[2]);

						if (score < 0 || score > 100) {
							throw new IllegalArgumentException("Score must be between 0 and 100");
						}

						// Add student to gradebook
						gradebook.addStudent(new Student(firstName, lastName, score));
					} catch (NumberFormatException e) {
						System.out.println("Score must be an integer.");
						i--; // Retry entry
					} catch (IllegalArgumentException e) {
						System.out.println("Invalid input: " + e.getMessage());
						i--; // Retry entry
					} catch (Exception e) {
						System.out.println("Unexpected error: " + e.getMessage());
						i--; // Retry entry
					}
				}
				break;

			case 2:
				gradebook.sortStudents();          // Sort the students by score
				System.out.println(gradebook);     // Print the list
				break;

			case 3:
				running = false;                   // Exit the program
				System.out.println("Thank you, please come again!");
				break;

			default:
				System.out.println("Invalid Selection"); // Invalid menu option
				break;
			}
		}
	}

	public static void main(String[] args) {
		Driver driver = new Driver();
		driver.run();
	}
}
